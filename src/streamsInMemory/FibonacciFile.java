package streamsInMemory;

import java.io.*;

/**
 * Created by anonymous.vn1985@gmail.com
 */
public class FibonacciFile {
    public static void main(String[] args) throws IOException {
        FileOutputStream fout = null;
        try {
            int howMany = 20;
            ByteArrayOutputStream bout = new ByteArrayOutputStream(howMany * 4);
            DataOutputStream dout = new DataOutputStream(bout);
            int num1 = 1;
            int num2 = 1;
            for (int i = 0; i < 20; i++) {
                int temp = num2;
                num2 = num2 + num1;
                num1 = temp;
                dout.writeInt(num2);
            }
            fout = new FileOutputStream("C:\\Users\\anony\\Documents\\Directory_Data\\Fibonaccy.dat");
            bout.writeTo(fout);
            fout.flush();
        } catch (IOException ex) {
            System.err.println(ex);
        } finally {
            fout.close();
        }
    }
}
