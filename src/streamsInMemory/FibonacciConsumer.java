package streamsInMemory;

import java.io.*;

/**
 * Created by anonymous.vn1985@gmail.com
 */
public class FibonacciConsumer extends Thread {
    private DataInputStream theInput;
    public FibonacciConsumer(InputStream input) {
        theInput = new DataInputStream(input);
    }
    public void run() {
        try {
            while (true) {
                System.out.println(theInput.readInt());
            }
        } catch (IOException ex) {
            if (ex.getMessage().equals("pipe broken"))
                return;
            System.err.println(ex);
        }
    }
}
