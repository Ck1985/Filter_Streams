package dataStreams;

import java.io.*;
import filterStreamClasses.*;
import inputStreams.*;
/**
 * Created by anonymous.vn1985@gmail.com
 */
public class FileDumper_3 {
    public static final int ASC = 0;
    public static final int DEC = 1;
    public static final int HEX = 2;
    public static final int SHORT = 3;
    public static final int INT = 4;
    public static final int LONG = 5;
    public static final int FLOAT = 6;
    public static final int DOUBLE = 7;

    public static void main(String[] args) {
        if (args.length < 1) {
            System.out.println("Usage: java FileDumper_3 -[ahdfilfx] -[little] file1 file2 ....");
        }

        boolean bigEndian = true;
        int firstFile;
        int mode = ASC;

        for (firstFile = 0; firstFile < args.length; firstFile++) {
            if (!args[firstFile].startsWith("-")) break;
            if (args[firstFile].equals("-h")) mode = HEX;
            else if (args[firstFile].equals("-d")) mode = DEC;
            else if (args[firstFile].equals("-s")) mode = SHORT;
            else if (args[firstFile].equals("-i")) mode = INT;
            else if (args[firstFile].equals("-l")) mode = LONG;
            else if (args[firstFile].equals("-f")) mode = FLOAT;
            else if (args[firstFile].equals("-x")) mode = DOUBLE;
            else if (args[firstFile].equals("-little")) bigEndian = false;
        }

        for (int i = firstFile; i < args.length; i++) {

        }
    }

    public static void dump(InputStream input, OutputStream output, int mode, boolean bigEndian) throws IOException {
        if (bigEndian) {
            DataInputStream din = new DataInputStream(input);
            switch (mode) {
                case HEX:
                    input = new HexFilter(input);
                    break;
                case DEC:
                    input = new DecimalFilter(input);
                    break;
                case INT:
                    input = new IntFilter(din);
                    break;
                case SHORT:
                    input = new ShortFilter(din);
                    break;
                case LONG:
                    input = new LongFilter(din);
                    break;
                case DOUBLE:
                    input = new DoubleFilter(din);
                    break;
                case FLOAT:
                    input = new FloatFilter(din);
                    break;
                default:
            }
        } else {
            LittleEndianInputStream lin = new LittleEndianInputStream(input);
            switch (mode) {
                case HEX:
                    input = new HexFilter(input);
                    break;
                case DEC:
                    input = new DecimalFilter(input);
                    break;
                case INT:
                    input = new LEIntFilter(lin);
                    break;
                case SHORT:
                    input = new LEShortFilter(lin);
                    break;
                case LONG:
                    input = new LEShortFilter(lin);
                    break;
                case DOUBLE:
                    input = new LEDoubleFilter(lin);
                    break;
                case FLOAT:
                    input = new LEFloatFilter(lin);
                    break;
                default:
            }
        }
        StreamCopier.copy(input, output);
    }
}
