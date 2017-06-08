package dataStreams;

import java.io.*;

/**
 * Created by anonymous.vn1985@gmail.com
 */
public class RootsFile {
    public static void main(String[] args) throws IOException {
        DataOutputStream dos = null;
        try {
            FileOutputStream fos = new FileOutputStream("C:\\Users\\anony\\Documents\\Directory_Data\\Roots.dat");
            dos = new DataOutputStream(fos);
            for (int i = 0; i <= 1000; i++) {
                dos.writeDouble(Math.sqrt(i));
            }
            dos.flush();
            dos.close();
        } finally {
            if (dos != null) {
                dos.close();
            }
        }
    }
}
