package dataStreams;

import java.io.*;

/**
 * Created by anonymous.vn1985@gmail.com
 */
public class File1000 {
    public static void main(String[] args) {
        DataOutputStream dos = null;
        try {
             dos = new DataOutputStream(new FileOutputStream("C:\\Users\\anony\\Documents\\Directory_Data\\1000.dat"));
             for (int i = 0; i < 1000; i++) {
                 dos.writeInt(i);
             }
        } catch (IOException ex) {
            System.err.println(ex);
        } finally {
            if (dos != null) {
                try {
                    dos.close();
                } catch (IOException ex) {
                    System.err.println(ex);
                }
            }
        }
    }
}
