package p10114;

/**
 * Created by Muhamed on 9/18/2016.
 */
import static java.lang.Double.parseDouble;
import static java.lang.Integer.parseInt;
import static java.lang.Long.parseLong;
import static java.lang.System.exit;
import static java.util.Arrays.fill;

import java.io.*;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {

    static void solve() throws Exception {

        int duration, depr;
        double down, dept;
        while ((duration = nextInt()) >= 0) {
            down = nextDouble();
            dept = nextDouble();
            double car = down+dept;
            depr = nextInt();
            HashMap<Integer,Double> deprications = new HashMap<Integer,Double>();
            for (int i = 0; i < depr; i++) {
                deprications.put(nextInt(), nextDouble());
            }
            double payment = dept/duration;
            double deprval = deprications.get(0);
            car*=(1.0 - deprval);
            //car*=(1.0 - deprval);
            int months = 0;
            if(dept>=car) {
                for (months = 1; months < duration; months++) {
                    if (deprications.get(months) != null)
                        deprval = deprications.get(months);
                    car *= (1.0 - deprval);
                    dept -= payment;
                    if (dept < car)
                        break;
                }
            }
            System.out.println(months+((months == 1)?" month":" months"));
        }
    }

    static int nextInt() throws IOException {
        return parseInt(next());
    }

    static long nextLong() throws IOException {
        return parseLong(next());
    }

    static double nextDouble() throws IOException {
        return parseDouble(next());
    }

    static String next() throws IOException {
        while (tok == null || !tok.hasMoreTokens()) {
            tok = new StringTokenizer(in.readLine());
        }
        return tok.nextToken();
    }

    public static void main(String[] args) {
        try {
            //INPUT = new FileInputStream("data.txt");
            //OUTPUT = new FileOutputStream("data.out");
            in = new BufferedReader(new InputStreamReader(INPUT));
            out = new PrintWriter(new OutputStreamWriter(OUTPUT));
            solve();
            in.close();
            out.close();
        } catch (Throwable e) {
            e.printStackTrace();
            exit(1);
        }
    }

    static BufferedReader in;
    static PrintWriter out;
    static StringTokenizer tok;
    static InputStream INPUT = System.in;
    static OutputStream OUTPUT = System.out;
}
