package streamsInMemory;

import java.io.*;

/**
 * Created by anonymous.vn1985@gmail.com
 */
public class FibonacciDriver {
    public static void main(String[] args) {
        int howMany;
        try {
            howMany = Integer.parseInt(args[0]);
        } catch (Exception ex) {
            howMany = 20;
        }
        try {
            PipedOutputStream pout = new PipedOutputStream();
            PipedInputStream pin = new PipedInputStream(pout);

            FibonacciProducer fp = new FibonacciProducer(pout,howMany);
            FibonacciConsumer fc = new FibonacciConsumer(pin);
            fp.start();
            fc.start();
        } catch (IOException ex) {
            if ((ex.getMessage().equals("Pipe broken")) || (ex.getMessage().equals("Write end dead"))) {
                return;
            } else {
                ex.printStackTrace();
            }
        }
    }
}
