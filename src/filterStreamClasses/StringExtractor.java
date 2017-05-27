package filterStreamClasses;

import java.io.*;

/**
 * Created by anonymous.vn1985@gmail.com
 */
public class StringExtractor {
    public static void main(String[] args) {
        if (args.length < 1) {
            System.out.println("Usage: java StringExtractor inFile");
            return;
        }
        try {
            InputStream input = new FileInputStream(args[0]);
            OutputStream output;
            if (args.length == 2) {
                output = new FileOutputStream(args[1]);
            } else {
                output = System.out;
            }
            OutputStream pout = new PrintableOutputStream(output);
            for (int in = input.read(); in != -1; in = input.read()) {
                pout.write(in);
            }
            output.close();
        } catch (FileNotFoundException ex) {
            System.err.println(ex);
    }catch (IOException ex) {
            System.err.println(ex);
        }
    }
}
