package dataStreams;

import java.io.*;

/**
 * Created by anonymous.vn1985@gmail.com
 */
public class LEDoubleFilter extends LEFilter {
    public LEDoubleFilter(LittleEndianInputStream lin) {
        super(lin);
    }
    protected void fill() throws IOException {
        double number = lin.readDouble();
        String s = Double.toString(number) + System.getProperty("line.separator", "\r\n");
        byte[] b = s.getBytes();
        buf = new int[b.length];
        for (int i = 0; i < b.length; i++) {
            buf[i] = b[i];
        }
    }
}
