package printStreams;

/**
 * Created by anonymous.vn1985@gmail.com
 */
public class FormatModifier {
    public static void main(String[] args) {
        float feet = 0.98f;
        System.out.printf("There are %2$f centimetter in %1$f \n", feet, 2.54 * feet * 12);
        System.out.printf("HexaDecimal: %1$H ----- Decimal: %1$f\n", Math.PI);
        //This statement is equals above
        System.out.printf("HexaDecimal: %1$H ------ Decimal: %<f", Math.PI);
    }
}
