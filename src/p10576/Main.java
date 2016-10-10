package p10576;

import java.io.*;
import java.util.StringTokenizer;

import static java.lang.Double.parseDouble;
import static java.lang.Integer.max;
import static java.lang.Integer.parseInt;
import static java.lang.Long.parseLong;
import static java.lang.System.exit;

public class Main {

    static void solve() throws Exception {

        int [][] conf = {{10,2},{8,4},{6,6},{3,9}};
        String line;
        while ((line = in.readLine()) != null && line.length()!=0) {
            String [] sd = line.split(" ");
            int s = Integer.parseInt(sd[0]);
            int d = Integer.parseInt(sd[1]);
            int totalSurplus = 0;
            int p1 = 4, p2 = 1;
            int maxNegative = Integer.MIN_VALUE;
            for (int i = 0; i < conf.length; i++,p1--,p2++) {
                int val = s*p1-d*p2;
                if(val < 0 && val > maxNegative) {
                    totalSurplus = conf[i][0] * s - conf[i][1] * d;
                    maxNegative = val;
                }
            }
            if(totalSurplus > 0){
                out.println(totalSurplus);
            }
            else{
                out.println("Deficit");
            }
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