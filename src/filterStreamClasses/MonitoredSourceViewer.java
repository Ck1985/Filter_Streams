package filterStreamClasses;

import java.net.*;
import java.io.*;
import javax.swing.*;

/**
 * Created by anonymous.vn1985@gmail.com
 */

public class MonitoredSourceViewer {
    public static void main(String[] args) {
        if (args.length > 0) {
            try {
                URL url = new URL(args[0]);
                URLConnection urlConn = url.openConnection();
                InputStream input = urlConn.getInputStream();
                ProgressMonitorInputStream pmis = new ProgressMonitorInputStream(null, url.toString(), input);
                ProgressMonitor pm = pmis.getProgressMonitor();
                pm.setMaximum(urlConn.getContentLength());
                for (int c = pmis.read(); c != -1; c = pmis.read()) {
                    System.out.print((char) c);
                }
                pmis.close();
            } catch (MalformedURLException ex) {
                System.err.println(args[0] + " is not a parseable URL");
            } catch (InterruptedIOException ex) {
                //User canceled, do not anything
            } catch (IOException ex) {
                System.err.println(ex);
            }
        }
        System.exit(0);
    }
}
