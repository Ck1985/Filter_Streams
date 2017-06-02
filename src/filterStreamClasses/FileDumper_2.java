package filterStreamClasses;

import java.io.*;

/**
 * Created by anonymous.vn1985@gmail.com
 */
public class FileDumper_2 {
    public static final int ASC = 0;
    public static final int DEC = 1;
    public static final int HEX = 2;
    public static void main(String[] args) {
        if (args.length < 1) {
            System.err.println("Usage: java FileDumper2 [-ahd] file1 file2...");
            return;
        }
        int firstArg = 0;
        int mode = ASC;
        if (args[0].startsWith("-")) {
            firstArg = 1;
            if (args[0].equals("-h")) mode = HEX;
            else if (args[0].equals("-d")) mode = DEC;
        }
        for (int i = firstArg; i < args.length; i++) {
            try {
                InputStream in = new FileInputStream(args[i]);
                dump(in, System.out, mode);
                if (i < args.length-1) { // more files to dump
                    System.out.println( );
                    System.out.println("--------------------------------------");
                    System.out.println( );
                }
            }
            catch (IOException ex) {
                System.err.println(ex);
            }
        }
    }
    public static void dump(InputStream in, OutputStream out, int mode) throws IOException {

        if (mode == ASC) ;
        else if (mode == HEX) in = new HexFilter(in);
        else if (mode == DEC) in = new DecimalFilter(in);

        BufferedStreamCopier.copy(in, out);
        in.close( );
    }
}
