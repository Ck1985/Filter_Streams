package dataStreams;

import java.io.*;

/**
 * Created by anonymous.vn1985@gmail.com
 */
public class LittleEndianInputStream extends FilterInputStream {
    public LittleEndianInputStream (InputStream in) {
        super(in);
    }
    public boolean readBoolean() throws IOException {
        int bool = in.read();
        if (bool == -1) throw new EOFException();
        return (bool != 0);
    }
}
