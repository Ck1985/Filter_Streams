package compressingStreams;

import java.io.*;
import java.util.zip.*;

/**
 * Created by anonymous.vn1985@gmail.com
 */
public class GZipper {
    public final static String GZIP_SUFFIX = ".gz";
    public static void main(String[] args) {
        for (int i = 0; i < args.length; i++) {
            try {
                FileInputStream fin = new FileInputStream(args[i]);
                FileOutputStream fout = new FileOutputStream(args[i] + GZIP_SUFFIX);
                GZIPOutputStream gzip = new GZIPOutputStream(fout);
                for (int c = fin.read(); c != -1; c = fin.read()) {
                    gzip.write(c);
                }
                gzip.close();
            } catch (IOException ex) {
                System.err.println(ex);
            }
        }
    }
}
