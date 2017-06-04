package printStreams;

/**
 * Created by anonymous.vn1985@gmail.com
 */
public class FloatingPointFormatDemo {
    public static void main(String[] args) {
        System.out.printf("Decimal %f\n", Math.PI);
        System.out.printf("Scientific %e\n", Math.PI);
        System.out.printf("Scientific %E\n", Math.PI);
        System.out.printf("Decimal/Scientific %g\n", Math.PI);
        System.out.printf("Decimal/Scientific %G\n", Math.PI);
        System.out.printf("Lowercase hexal %a\n", Math.PI);
        System.out.printf("Uppercase hexal %A\n", Math.PI);
    }
}
