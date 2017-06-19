package streamsInMemory;

import java.io.*;
import java.util.zip.*;

/**
 * Created by anonymous.vn1985@gmail.com
 */
public class DirectInflater {
    public static void main(String[] args) {
        Inflater inf = new Inflater();
        byte[] input = new byte[1024];
        byte[] output = new byte[1024];
        for (int i = 0; i < args.length; i++) {
            try {
                if (!args[i].endsWith(".dfl")) {
                    System.out.println("Sorry ! we can't decompress this file type");
                    continue;
                }
                FileInputStream fin = new FileInputStream(args[i]);
                FileOutputStream fout = new FileOutputStream(args[i].substring(0,args[i].length()
                                                             - DirectDeflater.DEFLATE_SUFFIX.length()));
                while (true) {
                    int numBytesRead = fin.read(input);
                    if (numBytesRead != -1) {
                        inf.setInput(input,0,numBytesRead);
                    }
                    int numDecompressed = 0;
                    while ((numDecompressed = inf.inflate(output,0,output.length)) != 0) {
                         fout.write(output,0,numDecompressed);
                    }
                    if (inf.finished()) {
                        break;
                    } else if (inf.needsDictionary()) {
                        System.err.println("Dictionary requried! Bailing ....");
                        break;
                    } else if (inf.needsInput()) {
                        continue;
                    }
                }
                fin.close();
                fout.flush();
                fout.close();
                inf.reset();
            } catch (IOException ex) {
                System.err.println(ex);
            } catch (DataFormatException ex) {
                System.err.println(args[i] + "appear to be corrupt");
                System.err.println(ex);
            }
        }
    }
}
