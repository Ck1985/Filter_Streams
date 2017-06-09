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
        out.write((v >>> 0) & 0xFF);
        out.write((v >>> 8) & 0xFF);
        this.written += 2;
    }
    public void writeChar(int v) throws IOException {
        out.write((v >>> 0) & 0xFF);
        out.write((v >>> 8) & 0xFF);
        this.written += 2;
    }
    public void writeInt(int v) throws IOException {
        out.write((v >>> 0) & 0xFF);
        out.write((v >>> 8) & 0xFF);
        out.write((v >>> 16) & 0xFF);
        out.write((v >>> 24) & 0xFF);
        this.written += 4;
    }
    public void writeLong(long v) throws IOException {
        out.write((int)(v >>> 0) & 0xFF);
        out.write((int)(v >>> 8) & 0xFF);
        out.write((int)(v >>> 16) & 0xFF);
        out.write((int)(v >>> 24) & 0xFF);
        out.write((int)(v >>> 32) & 0xFF);
        out.write((int)(v >>> 40) & 0xFF);
        out.write((int)(v >>> 48) & 0xFF);
        out.write((int)(v >>> 56) & 0xFF);
        this.written += 8;
    }
    public void writeFloat(float v) throws IOException {
        this.writeInt(Float.floatToIntBits(v));
    }
    public void writeDouble(double v) throws IOException {
        this.writeLong(Double.doubleToLongBits(v));
    }
    public void writeBytes(String s) throws IOException {
        int length = s.length();
        for (int i = 0; i < length; i++) {
            out.write((byte)s.charAt(i));
        }
        this.written += length;
    }
    public void writeChars(String s) throws IOException {
        int length = s.length();
        int n = 0;
        for (int i = 0; i < length; i++) {
            n = s.charAt(i);
            out.write((n >>> 0) & 0xFF);
            out.write((n >>> 8) & 0xFF);
            this.written += 2;
        }
    }
    public void writeUTF(String  s) throws IOException {
        int numChars = s.length();
        int numBytes = 0;
        int c = 0;
        for (int i = 0; i < numChars; i++) {
            c = s.charAt(i);
            if ((c >= 0x0001) && (c <= 0x007F)) numBytes++;
            else if (c > 0x07FF) numBytes += 3;
            else numBytes += 2;
        }
        if (numBytes > 65535) throw new UTFDataFormatException();
         out.write((numBytes >>> 8) & 0xFF);
         out.write((numBytes >>> 0) & 0xFF);
         for (int i = 0; i < numChars; i++) {
             c = s.charAt(i);
             if ((c >= 0x0001) && (c <= 0x007F))
         }
    }

}
