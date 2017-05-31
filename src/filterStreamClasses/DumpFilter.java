package filterStreamClasses;

import java.io.*;

/**
 * Created by anonymous.vn1985@gmail.com
 */
public abstract class DumpFilter extends FilterInputStream {
    private int[] buf = new int[0];
    private int index = 0;

    public DumpFilter(InputStream input) {
        super(input);
    }

    public int read() throws IOException {
        int result;
        if (index < buf.length) {
            result = buf[index];
            index++;
        } else {
            try {
                this.fill();
                result = buf[0];
                index = 1;
            } catch (EOFException ex) {
                result = -1;
            }
        }
        return result;
    }

    protected abstract void fill() throws IOException;

    public int read(byte[] data, int offset, int len) throws IOException {
        if (data == null) {
            throw new NullPointerException();
        } else if ((offset < 0) || (offset > data.length) || (offset + len) > data.length || (len < 0) || (offset + len < 0)) {
            throw new ArrayIndexOutOfBoundsException();
        } else if (len == 0) {
            return 0;
        }
        int datum = this.read();
        if (datum == -1) {
            return -1;
        }
        data[offset] = (byte)datum;
        int bytesRead = 1;
        try {
            for (; bytesRead < len; bytesRead++) {
                datum = this.read();
                if (datum == -1) break;
                data[offset + len] = (byte)datum;
            }
        } catch (IOException ex){}
        return bytesRead;
    }

    public int available() throws IOException {
        return buf.length - index;
    }

    public long skip(long bytesToSkip) throws IOException {
        long bytesSkipped = 0;
        for ( ; bytesSkipped < bytesToSkip; bytesSkipped++) {
            int c = this.read();
            if (c == -1) break;
        }
        return bytesSkipped;
    }

    public void mark(int readLimit){}

    public void reset() throws IOException {
        throw new IOException("marking is not supported");
    }

    public boolean markSupported() {
        return false;
    }
}