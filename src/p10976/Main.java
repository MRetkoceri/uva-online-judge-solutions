package p10976;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

import static java.lang.Double.parseDouble;
import static java.lang.Integer.parseInt;
import static java.lang.Long.parseLong;
import static java.lang.System.exit;

public class Main {

    static void solve() throws Exception {

        int k;
        String line;
        while ((line = in.readLine()) != null && line.length()!=0) {
            k = Integer.parseInt(line);
            ArrayList<String> sols = new ArrayList<String>();
            for (int x = k+1; x <= 2*k ; x++) {
                int y = LCM(k,x);
                int numerator = y/k-y/x;
                int gcd = GCD(numerator,y);
                numerator /= gcd;
                y /= gcd;
                if(numerator == 1)
                    sols.add(String.format("1/%d = 1/%d + 1/%d",k,y,x));
            }
            System.out.println(sols.size());
            for(String sol:sols)
                System.out.println(sol);
        }
    }
    public static int LCM(int a, int b) {
        return a*b/GCD(a,b);
    }
    public static int GCD(int a, int b) {
        if (b==0) return a;
        return GCD(b,a%b);
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