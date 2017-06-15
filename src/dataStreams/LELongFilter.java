package dataStreams;

import java.io.*;

/**
 * Created by anonymous.vn1985@gmail.com
 */
public class LELongFilter extends LEFilter {
    public LELongFilter(LittleEndianInputStream lin) {
        super(lin);
    }
    protected void fill() throws IOException {
        long number = lin.readLong();
        String s = Long.toString(number) + System.getProperty("line.separator","\r\n");
        byte[] b = s.getBytes();
        buf = new int[b.length];
        for (int i = 0; i < b.length; i++) {
            buf[i] = b[i];
        }
    }
}
