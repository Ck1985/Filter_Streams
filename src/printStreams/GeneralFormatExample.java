package printStreams;

import java.net.*;
import java.io.*;

/**
 * Created by anonymous.vn1985@gmail.com
 */
public class GeneralFormatExample {
    public static void main(String[] args) throws IOException {
        URL url = new URL("http://www.dantri.com.vn");
        System.out.printf("boolean %b\n", url);
        System.out.printf("Boolean %B\n", url);
        System.out.printf("hashCode %h \n", url);
        System.out.printf("HashCode %H \n", url);
        System.out.printf("string %s\n", url);
        System.out.printf("String %S\n", url);
    }
}
