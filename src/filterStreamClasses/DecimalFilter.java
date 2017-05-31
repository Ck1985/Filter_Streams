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

    }
}
