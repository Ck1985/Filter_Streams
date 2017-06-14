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

    public char readChar() throws IOException {
        int byte1 = in.read();
        int byte2 = in.read();
        if ((byte1 == -1) || (byte2 == -1)) throw new EOFException();
        return (char)(((byte2 << 24) >>> 16) + ((byte1 << 24) >> 24));
    }

    public int readInt() throws IOException {
        int byte1 = in.read(),
                byte2 = in.read(),
                byte3 = in.read(),
                byte4 = in.read();
        if (byte4 == -1) throw new EOFException();
        return (byte4 << 24) + ((byte3 << 24) >>> 8) + ((byte2 << 24) >>> 16) + ((byte1 << 24) >>> 24);
    }

    public long readLong() throws IOException {
        int
                byte1 = in.read(),
                byte2 = in.read(),
                byte3 = in.read(),
                byte4 = in.read(),
                byte5 = in.read(),
                byte6 = in.read(),
                byte7 = in.read(),
                byte8 = in.read();
        if (byte8 == -1) throw new EOFException();
        return
                (byte8 << 56)
                + ((byte7 << 56) >>> 8)
                + ((byte6 << 56) >>> 16)
                + ((byte5 << 56) >>> 24)
                + ((byte4 << 56) >>> 32)
                + ((byte3 << 56) >>> 40)
                + ((byte2 << 56) >>> 48)
                + ((byte1 << 56) >>> 56);

    }

    public String readUTF() throws IOException {
        int
                byte1 = in.read(),
                byte2 = in.read();
        if (byte2 == -1) throw new EOFException();
        int
                numBytes = (byte1 << 8) + byte2,
                numRead = 0,
                numChars = 0;
        char[] result = new char[numBytes];
        while (numRead < numBytes) {
            int c1 = this.readUnsignedByte();
            int test = c1 >> 4;
            if (test < 8) {
                numRead++;
                result[numChars++] = (char)c1;
            } else if ((test == 12) || (test == 13)) {
                numRead += 2;
                if (numRead > numBytes) throw new UTFDataFormatException();
                int c2 = this.readUnsignedByte();
                if ((c2 & 0xC0) != 0x80) throw new UTFDataFormatException();
                result[numChars++] = (char)(((c1 & 0x1F) << 6) | (c2 & 0x3F));
            } else if (test == 14) {
                numRead += 3;
                if (numRead > numBytes) throw new UTFDataFormatException();
                int c2 = this.readUnsignedByte();
                int c3 = this.readUnsignedByte();
                if (((c2 & 0xC0) != 0x80) || ((c3 & 0xC0) != 0x80)) throw new UTFDataFormatException();
                result[numChars++] = (char)(((c1 & 0x0F) << 12) | ((c2 & 0x3F) << 6) | (c3 & 0x3F));
            } else {
                throw new UTFDataFormatException();
            }
        }
        return new String(result,0,numChars);
    }

    public final double readDouble() throws IOException {
        return Double.longBitsToDouble(this.readLong());
    }

    public final float readFloat() throws IOException {
        return Float.intBitsToFloat(this.readInt());
    }

    public final int skipByte(int n) throws IOException {
        for (int i = 0; i < n; i += (int)skip(n - 1));
        return n;
    }
}
