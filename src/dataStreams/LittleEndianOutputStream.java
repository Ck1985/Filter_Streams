package dataStreams;

import java.io.*;

/**
 * Created by anonymous.vn1985@gmail.com
 */
public class LittleEndianOutputStream extends FilterOutputStream {
    protected int written;

    public LittleEndianOutputStream(OutputStream out) {
        super(out);
    }
    public void write(int b) throws IOException {
        out.write(b);
        this.written++;
    }
    public void write(byte[] b, int off, int len) throws IOException {
        out.write(b,off,len);
        this.written += len;
    }
    public void writeBoolean(boolean v) throws IOException {
        this.write(v ? 1 : 0);
        written++;
    }
    public void writeByte(int v) throws IOException {
        out.write(v);
        this.written++;
    }
    public void writeShort(int v) throws IOException {
        out.write((v >>> 8) & 0xFF);
        out.write((v >>> 0) & 0xFF);
        this.written += 2;
    }
    public void writeChar(int v) throws IOException {
        out.write((v >>> 8) & 0xFF);
        out.write((v >>> 0) & 0xFF);
        this.written += 2;
    }
    public void writeInt(int v) throws IOException {
        out.write((v >>> 24) & 0xFF);
        out.write((v >>> 16) & 0xFF);
        out.write((v >>> 8) & 0xFF);
        out.write((v >>> 0) & 0xFF);
        this.written += 4;
    }
    public void writeLong(long v) throws IOException {
        out.write((int)(v >>> 56) & 0xFF);
        out.write((int)(v >>> 48) & 0xFF);
        out.write((int)(v >>> 40) & 0xFF);
        out.write((int)(v >>> 32) & 0xFF);
        out.write((int)(v >>> 24) & 0xFF);
        out.write((int)(v >>> 16) & 0xFF);
        out.write((int)(v >>> 8) & 0xFF);
        out.write((int)(v >>> 0) & 0xFF);
        this.written += 8;
    }
    public void writeFloat(float v) throws IOException {
        this.writeInt(Float.floatToIntBits(v));
    }
    public void writeDouble(double v) throws IOException {
        this.writeLong(Double.doubleToLongBits(v));
    }
}
