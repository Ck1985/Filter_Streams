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
    public byte readByte() throws IOException {
        int ch = in.read();
        if (ch < 0) throw new EOFException();
        return (byte)ch;
    }
    public int readUnsignedByte() throws IOException {
        int ch = in.read();
        if (ch < 0) throw new EOFException();
        return ch;
    }
    public short readShort() throws IOException {
        int byte1 = in.read();
        int byte2 = in.read();
        if ((byte1 | byte2) < 0) throw new EOFException();
        return (short) (((byte2 << 24) >>> 16) + ((byte1 << 24) >>> 24));
    }
    public int readUnsignedShort() throws IOException {
        int byte1 = in.read();
        int byte2 = in.read();
        if ((byte1 | byte2) < 0) throw new EOFException();
        return ((byte2 << 24) >> 16) + ((byte1 << 24) >> 24);
    }
}
