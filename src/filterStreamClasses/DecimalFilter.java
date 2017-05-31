package filterStreamClasses;

import java.io.*;

/**
 * Created by anonymous.vn1985@gmail.com
 */
public class DecimalFilter extends DumpFilter {
    private int numRead = 0;
    private int breakAfter = 15;
    private int ratio = 4;

    public DecimalFilter(InputStream input) {
        super(input);
    }
    protected void fill() throws IOException {
        buf = new int[ratio];
        int datum = in.read();
        this.numRead++;
        if (datum == -1) {
        }
        String decimal = Integer.toString(datum);
        if (datum < 10) {
            decimal = "00" + decimal;
        } else if (datum < 100) {
            decimal = "0" + decimal;
        }
        for (int i = 0; i < decimal.length(); i++) {
            buf[i] = decimal.charAt(i);
        }
        if (numRead < breakAfter) {
            buf[buf.length - 1] = ' ';
        } else {
            buf[buf.length - 1] = '\n';
            numRead = 0;
        }
    }
}
