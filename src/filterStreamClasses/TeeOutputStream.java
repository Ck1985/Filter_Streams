package filterStreamClasses;

import java.io.*;

/**
 * Created by anonymous.vn1985@gmail.com
 */
public class TeeOutputStream extends FilterOutputStream {
    private OutputStream output_1;
    private OutputStream output_2;

    public TeeOutputStream(OutputStream output_1, OutputStream output_2) {
        super(output_1);
        this.output_1 = output_1;
        this.output_2 = output_2;
    }
    public void write(byte[] b) throws IOException {
        output_1.write(b);
        output_2.write(b);
    }
    public void write(byte[] b, int offset, int len) throws IOException {
        output_1.write(b,offset,len);
        output_2.write(b,offset,len);
    }
    public void flush() throws IOException {
        output_1.flush();
        output_2.flush();
    }
    public void close() throws IOException {
        output_1.close();
        output_2.close();
    }
}
