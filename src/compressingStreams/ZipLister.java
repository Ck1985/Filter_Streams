package compressingStreams;

import java.io.*;
import java.util.*;
import java.util.zip.*;

/**
 * Created by anonymous.vn1985@gmail.com
 */
public class ZipLister {
    public static void main(String[] args) throws IOException {
        ZipFile zf = new ZipFile(args[0]);
        Enumeration en = zf.entries();
        while (en.hasMoreElements()) {
            System.out.println(en.nextElement());
        }
        System.out.println("-------------");
        System.out.println(zf.getEntry("outputStreams/AsciiArray.class"));
    }
}
