package filterStreamClasses;

import java.io.*;

/**
 * Created by anonymous.vn1985@gmail.com
 */
public class PrintableOutputStream extends FilterOutputStream {
    public PrintableOutputStream(OutputStream output) {
        super(output);
    }
    public void write(int b) throws IOException {
        if ((char)b == '\n' || (char)b == '\r' || (char)b == '\t') {
            System.out.write(b);
        } else if (b < 32 || b > 126) {
            System.out.write('?');
        } else {
            System.out.write(b);
        }
    }
    public void write(byte[] b, int offset, int length) throws IOException {
        for (int i = offset; i < offset + length; i++) {
            this.write(b[i]);
        }
    }
    public static void main(String[] args) throws IOException {
        // To use this class, we have to chain it to another stream which write actually to eventually target
        PrintableOutputStream printable = new PrintableOutputStream(System.out);
        // If subclass of filter stream just override methods of superclass without add
        // more additional method, we can say:
        OutputStream out = new PrintableOutputStream(System.out);
        // we can create directly underlying stream:
        OutputStream out2 = new PrintableOutputStream(new FileOutputStream("data.txt"));

        FileOutputStream fout = new FileOutputStream("data.txt");
        BufferedOutputStream bout = new BufferedOutputStream(fout);
        PrintableOutputStream pout = new PrintableOutputStream(bout);
        //We can done thid by using only OutputStream
        OutputStream output = new FileOutputStream("data.txt");
        output = new BufferedOutputStream(output);
        output = new PrintableOutputStream(output);
    }
}
