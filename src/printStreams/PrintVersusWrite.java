package printStreams;

import java.io.*;
import java.util.*;

/**
 * Created by anonymous.vn1985@gmail.com
 */
public class PrintVersusWrite {
    public static void main(String[] args) throws IOException {
        PrintStream out = new PrintStream(new FileOutputStream("C:\\Users\\anony\\Documents\\Directory_Data\\number.dat"));
        for (int i = 0; i <= 127; i++) {
            // out.write(i);
            //out.print(i);
        }
        //System.out.println();
        //out.write(65);

        int hits = 3;
        System.out.print("As of " + new Date() + "there have been over " + hits + " hits on the website");
        System.out.println();
        StringBuilder sp = new StringBuilder();
        sp.append("As of ");
        Date date = new Date();
        sp.append(date);
        sp.append(" there have been over ");
        sp.append(hits);
        sp.append("hits on the website");
        String s = sp.toString();
        System.out.print(s);
    }
}
