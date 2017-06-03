package printStreams;

import java.util.*;
import java.io.*;

/**
 * Created by anonymous.vn1985@gmail.com
 */
public class FormatterDemo {
    public static void main(String[] args) throws FileNotFoundException {
        Formatter formatter = new Formatter("C:\\Users\\anony\\Documents\\Directory_Data\\angles.txt");
        for (double degree = 0.0; degree < 360.0; degree++) {
            double radian = Math.PI * degree / 180.0;
            double grads = 400 * degree / 360;
            formatter.format("%5.1f %5.1f %5.1f \r", degree, radian, grads);
        }
        formatter.flush();
        formatter.close();
    }
}
