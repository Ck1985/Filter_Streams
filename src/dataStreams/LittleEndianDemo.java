package dataStreams;

import java.io.*;

/**
 * Created by anonymous.vn1985@gmail.com
 */
public class LittleEndianDemo {
    public static void main(String[] args) throws IOException {
        FileOutputStream fos = new FileOutputStream("C:\\Users\\anony\\Documents\\Directory_Data\\EndianTest.txt");
        LittleEndianOutputStream leos = new LittleEndianOutputStream(fos);
        leos.writeShort(8965);
        fos.flush();
        fos.close();
    }
}
