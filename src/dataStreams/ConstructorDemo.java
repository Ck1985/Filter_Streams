package dataStreams;

import java.io.*;

/**
 * Created by anonymous.vn1985@gmail.com
 */
public class ConstructorDemo {
    public static void main(String[] args) throws IOException {
        DataInputStream dis = new DataInputStream(new FileInputStream("Data.txt"));
        DataOutputStream dos = new DataOutputStream(new FileOutputStream("Output.dat"));
    }
}
