package dataStreams;

import java.io.*;

/**
 * Created by anonymous.vn1985@gmail.com
 */
public class LittleEndianDemo {
    public static void main(String[] args) {
        FileOutputStream fos = null;
        FileInputStream fis = null;
        try {
            fos = new FileOutputStream("C:\\Users\\anony\\Documents\\IntelliJ_Projects\\Reilly Java IO\\Filter_Streams\\src\\EndianTest.txt");
            LittleEndianOutputStream leos = new LittleEndianOutputStream(fos);
            //leos.write(10);
            //leos.writeShort(25928);
            //leos.writeBoolean(true);
            //leos.writeBoolean(false);
            //leos.writeBoolean(true);
            //leos.writeByte(-3);
            leos.writeShort(58279);
            fis = new FileInputStream("C:\\Users\\anony\\Documents\\IntelliJ_Projects\\Reilly Java IO\\Filter_Streams\\src\\EndianTest.txt");
            LittleEndianInputStream leis = new LittleEndianInputStream(fis);
            int s;
            while (true) {
                s = leis.readShort();
                System.out.print(s + " ");
            }
        }catch (IOException ex) {
            System.err.println(ex);
        } finally {
            try {
                fos.flush();
                fos.close();
                fis.close();
            } catch (IOException ex) {
                System.err.println(ex);
            }
        }
    }
}
