package filterStreamClasses;

import java.io.*;

/**
 * Created by anonymous.vn1985@gmail.com
 */
public class HexFilter extends DumpFilter {
    private int numsRead = 0;
    private int ratio = 3;
    private int breakAfter = 15;

    public HexFilter(InputStream input) {
        super(input);
    }
    protected void fill() throws IOException {
        buf = new int[ratio];
        int datum = in.read();
        if (datum == -1) {
            throw new EOFException();
        }
        this.numsRead++;
        String hex = Integer.toHexString(datum);
        if (datum < 16) {
            hex = '0' + hex;
        }
        for (int i = 0; i < hex.length(); i++) {
            buf[i] = hex.charAt(i);
        }
        if (numsRead < breakAfter) {
            buf[buf.length - 1] = ' ';
        } else {
            buf[buf.length - 1] = '\n';
            numsRead = 0;
        }
    }
    public int available() throws IOException {
        return buf.length - index + ratio * in.available();
    }
}
