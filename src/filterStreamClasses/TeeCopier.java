package filterStreamClasses;

import java.io.*;

/**
 * Created by anonymous.vn1985@gmail.com
 */
public class TeeCopier {
    public static void main(String[] args) throws IOException {
        if (args.length != 3) {
            System.out.println("Usage TeeCopier inFile outFile1 outFile2");
            return;
        } else {
            FileInputStream fin = new FileInputStream(args[0]);
            FileOutputStream fout1 = new FileOutputStream(args[1]);
            FileOutputStream fout2 = new FileOutputStream(args[2]);
            TeeOutputStream tee = new TeeOutputStream(fout1,fout2);
            BufferedStreamCopier.copy(fin,tee);
            fin.close();
            tee.close();
        }
    }
}
