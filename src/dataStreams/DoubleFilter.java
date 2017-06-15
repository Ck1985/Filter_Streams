package dataStreams;

import java.io.*;

/**
 * Created by anonymous.vn1985@gmail.com
 */
public class DoubleFilter extends DataFilter {
    public DoubleFilter(DataInputStream din) {
        super(din);
    }
    public void fill() throws IOException {
        double number = din.readDouble();
        String s = Double.toString(number) + System.getProperty("line.separator", "\r\n");
        byte[] b = s.getBytes("8859_1");
        buf = new int[b.length];
        for (int i = 0; i < b.length; i++) {
            buf[i] = b[i];
        }
    }
}
