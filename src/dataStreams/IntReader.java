package dataStreams;

import java.io.*;

/**
 * Created by anonymous.vn1985@gmail.com
 */
public class IntReader {
    public static void main(String[] args) throws IOException {
        DataInputStream dis = null;
        try {
            FileInputStream fis = new FileInputStream(args[0]);
            System.out.println("------------" + args[0] + "-------------");
            dis = new DataInputStream(fis);

            int result;
            while (true) {
                result = dis.readInt();
                System.out.print(result + " ");
            }
        } catch (EOFException ex) {
            dis.close();
        } catch (IOException ex) {
            System.out.println(ex);
        }
    }
}
