package printStreams;

/**
 * Created by anonymous.vn1985@gmail.com
 */
public class methodPrintfDemo {
    public static void degree_1() {
        for (double degree = 0.0; degree < 360.0; degree++) {
            double radian = Math.PI * degree / 180.0;
            double grads = 400 * degree / 360;
            //System.out.println(degree + " " + radian + " " + grads);
            System.out.printf("%5.1f %5.1f %5.1f", degree, radian, grads);
            System.out.println();
        }
    }
    public static void main(String[] args) {
        degree_1();
    }
}
