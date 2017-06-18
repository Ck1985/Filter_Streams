package streamsInMemory;

import java.io.*;
import java.util.zip.*;

/**
 * Created by anonymous.vn1985@gmail.com
 */
public class DirectDeflater  {
    private final static String DEFLATE_SUFFIX = ".dfl";
    public static void main(String[] args) throws IOException {
        Deflater def = new Deflater();
        byte[] input = new byte[1024];
        byte[] output = new byte[1024];
        FileInputStream fin = null;
        FileOutputStream fout = null;
        int numBytesRead = 0;
        for (int i = 0; i < args.length; i++) {
            fin = new FileInputStream(args[0]);
            fout = new FileOutputStream(args[0] + DEFLATE_SUFFIX);
            while (true) {
                numBytesRead = fin.read(input);
                if (numBytesRead == -1) {
                    def.finish();
                    while (!def.finished()) {
                        int numCompressedBytes = def.deflate(output,0,output.length);
                        if (numCompressedBytes > 0) {
                            fout.write(output,0,numCompressedBytes);
                        }
                    }
                    break;
                } else {
                    def.setInput(input,0,numBytesRead);
                    while (!def.needsInput()) {
                        int numCompressedBytes = def.deflate(output,0,output.length);
                        if (numCompressedBytes > 0) {
                            fout.write(output,0,numCompressedBytes);
                        }
                    }
                }
            }
            fin.close();
            fout.flush();
            fout.close();
            def.reset();
        }
    }
}
