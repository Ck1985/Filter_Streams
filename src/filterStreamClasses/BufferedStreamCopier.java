package filterStreamClasses;

import java.io.*;

/**
 * Created by anonymous.vn1985@gmail.com
 */
public class BufferedStreamCopier {
    public static void main(String[] args) {
        try {
            copy(System.in, System.out);
        } catch (IOException ex) {
            System.err.println(ex);
        }
    }
    private static void copy(InputStream input, OutputStream output) throws IOException {
        BufferedInputStream bin = new BufferedInputStream(input);
        BufferedOutputStream bout = new BufferedOutputStream(output);
        int datum = bin.read();
        while (true) {
            if (datum == -1) break;
            bout.write(datum);
        }
        bout.flush();
    }
}
