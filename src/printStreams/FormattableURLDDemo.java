package printStreams;

import java.net.*;
import java.io.*;

/**
 * Created by anonymous.vn1985@gmail.com
 */
public class FormattableURLDDemo {
    public static void main(String[] args) throws IOException {
        URL url = new URL("http://www.example.org/index.html?name=value#Fred");
        FormattableURL formattableURL = new FormattableURL(url);
        System.out.printf("%60.40S", formattableURL);
    }
}
