package streamsInMemory;

import java.util.*;
import java.io.*;

public class SequencePrinter {
    public static void main(String[] args) throws IOException {
        Vector vector = new Vector();
        InputStream in = null;
        for (int i = 0; i < args.length; i++) {
            in = new FileInputStream(args[i]);
            vector.add(in);
        }
        InputStream sin = new SequenceInputStream(vector.elements());
        for (int i = sin.read(); i != -1; i = sin.read()) {
            System.out.write(i);
        }
    }
}






















































































































