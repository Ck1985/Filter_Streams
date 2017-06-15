package dataStreams;

import filterStreamClasses.DumpFilter;
import java.io.*;

/**
 * Created by anonymous.vn1985@gmail.com
 */
public abstract class LEFilter extends DumpFilter {
    protected LittleEndianInputStream lin;
    public LEFilter(LittleEndianInputStream lin) {
        super(lin);
        this.lin = lin;
    }
    public int available() throws IOException {
        return (buf.length - index) + lin.available();
    }
}
