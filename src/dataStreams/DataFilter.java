package dataStreams;

import filterStreamClasses.DumpFilter;

import java.io.*;

/**
 * Created by anonymous.vn1985@gmail.com
 */
public abstract class DataFilter extends DumpFilter {
    protected DataInputStream din;
    public DataFilter(DataInputStream din) {
        super(din);
        this.din = din;
    }
    public int available() throws IOException {
        return (buf.length - index) + in.available();
    }
}
