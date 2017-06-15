package dataStreams;

import java.io.*;

/**
 * Created by anonymous.vn1985@gmail.com
 */
public class ShortFilter extends DataFilter {
    public ShortFilter(DataInputStream din) {
        super(din);
    }
    protected void fill() throws IOException {
        short sh = din.readShort();
        String s = Short.toString(sh) + System.getProperty("line.separator", "\r\n");
        byte[] b = s.getBytes("8859_1");
        buf = new int[b.length];
        for (int i = 0; i < b.length; i++) {
            buf[i] = b[i];
        }

    }
}
