package printStreams;

/**
 * Created by anonymous.vn1985@gmail.com
 */
public class IntegerFormatDemo {
    public static void main(String[] args) {
        int num = 1023;
        System.out.printf("decimal: %d \n", num);
        System.out.printf("octal: %o \n", num);
        System.out.printf("hexal lower: %x \n", num);
        System.out.printf("hexal upper: %X \n", num);
    }
}
