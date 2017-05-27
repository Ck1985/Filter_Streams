package filterStreamClasses;

import java.io.*;

/**
 * Created by anonymous.vn1985@gmail.com
 */
public class PrintableInputStream extends FilterInputStream {
    public PrintableInputStream(InputStream input) {
        super(input);
    }
    public int read() throws IOException {
            int b = System.in.read();
            if (b >= 32 && b <= 126) {
                return b;
            } else if (b == '\r' || b == '\t' || b == '\n') {
                return b;
            } else {
                return '?';
            }
    }
    public int read(byte[] b, int offset, int length) throws IOException {
        int result = System.in.read(b,offset,length);
        for (int i = offset; i < offset + length; i++) {
            if (b[i] == '\r' || b[i] == '\t' || b[i] == '\n');
            else if (b[i] < 32 || b[i] > 126) {
                b[i] = (byte)'?';
            }
        }
        return result;
    }
    public static void main(String[] args) {

    }
}
