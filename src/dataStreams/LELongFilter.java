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

    }
}
