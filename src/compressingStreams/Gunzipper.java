package compressingStreams;

import java.io.*;
import java.util.zip.*;

/**
 * Created by anonymous.vn1985@gmail.com
 */
public class Gunzipper {
    public static void main(String[] args) {
        for (int i = 0; i < args.length; i++) {
            if (args[i].toLowerCase().endsWith(GZipper.GZIP_SUFFIX)) {
                try {
                    FileInputStream fin = new FileInputStream(args[i]);
                    FileOutputStream fout = new FileOutputStream(args[i].substring(0,args[i].length() - GZipper.GZIP_SUFFIX.length()));
                    GZIPInputStream gzip = new GZIPInputStream(fin);
                    for (int c = gzip.read(); c != -1; c = gzip.read()) {
                        fout.write(c);
                    }
                    fout.close();
                } catch (IOException ex) {
                    System.err.println(ex);
                }
            } else {
                System.out.println(args[i] + "does not appear to be a gzipped file.");
            }
        }
    }
}
