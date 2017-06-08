package dataStreams;

import java.io.*;

/**
 * Created by anonymous.vn1985@gmail.com
 */
public class DoubleReader {
    public static void main(String[] args) {
        DataInputStream dis = null;
        try {
            FileInputStream fis = new FileInputStream(args[0]);
            System.out.println("-------------args[0]-------------");
            dis = new DataInputStream(fis);
            while (true) {
                double result = dis.readDouble();
                System.out.println(result + " ");
            }
        } catch (EOFException ex) {
            try {
                dis.close();
            } catch (IOException e) {
                System.err.println(e);
            }
        } catch (IOException ex) {
            System.err.println(ex);
        }
    }
}
