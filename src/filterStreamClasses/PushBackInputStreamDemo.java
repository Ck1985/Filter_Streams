package filterStreamClasses;

import java.io.*;

/**
 * Created by anonymous.vn1985@gmail.com
 */
public class PushBackInputStreamDemo {
    public static void main(String[] args) throws IOException {
        PushbackInputStream pbis = new PushbackInputStream(System.in,5);
        pbis.unread(0);
        pbis.unread(1);
        pbis.unread(2);

        System.out.println(pbis.read());
        System.out.println(pbis.read());
        System.out.println(pbis.read());
    }
}
