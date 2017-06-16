package streamsInMemory;

import java.io.*;

/**
 * Created by anonymous.vn1985@gmail.com
 */
public class FibonacciProducer extends Thread {
    private DataOutputStream theOutput;
    private int howMany;
    public FibonacciProducer(OutputStream output, int howMany) {
        this.theOutput = new DataOutputStream(output);
        this.howMany = howMany;
    }
    public void run() {
         try {
             int f1 =  1;
             int f2 = 1;
             this.theOutput.writeInt(f1);
             this.theOutput.writeInt(f2);
             for (int i = 2; i < this.howMany; i++) {
                 int temp = f2;
                 f2 = f2 + f1;
                 f1 = temp;
                 if (f2 < 0) {
                     break;
                 }
                 this.theOutput.writeInt(f2);
             }
         } catch (IOException ex) {
             System.err.println(ex);
         }
    }
}
