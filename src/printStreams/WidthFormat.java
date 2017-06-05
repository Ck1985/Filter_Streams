package printStreams;

/**
 * Created by anonymous.vn1985@gmail.com
 */
public class WidthFormat {
    public static void main(String[] args) {
        System.out.printf("%12f %12f %12f %12f %12f\n", Math.PI, Math.E, 1.0, 0.0, Math.sqrt(2));
        System.out.printf("%-15.3f %-15.3f %-15.3f %-15.3f %-15.3f", Math.PI, Math.E, 1.0, 0.0, Math.sqrt(2));
    }
}
