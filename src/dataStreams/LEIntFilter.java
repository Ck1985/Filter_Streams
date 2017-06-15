package dataStreams;

import java.io.*;

/**
 * Created by anonymous.vn1985@gmail.com
 */
public class LEIntFilter extends LEFilter {
    public LEIntFilter(LittleEndianInputStream lin) {
        super(lin);
    }
    protected void fill() throws IOException {
        int number = lin.read();
        String s = Integer.toString(number) + System.getProperty("line.separator","\r\n");
        byte[] b = s.getBytes("8859_1");
        buf = new int[b.length];
        for (int i = 0; i < b.length; i++) {
            buf[i] = b[i];
        }
    }
}
