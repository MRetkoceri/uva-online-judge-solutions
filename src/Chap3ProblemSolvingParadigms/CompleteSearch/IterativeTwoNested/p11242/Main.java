package Chap3ProblemSolvingParadigms.CompleteSearch.IterativeTwoNested.p11242;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

import static java.lang.Double.parseDouble;
import static java.lang.Integer.parseInt;
import static java.lang.Long.parseLong;
import static java.lang.System.exit;

public class Main {

    static void solve() throws Exception {

        int f;
        while ((f = nextInt()) != 0) {
            int r = nextInt();
            int [] front = new int[f];
            int [] rear = new int[r];
            for (int i = 0; i < f; i++) {
                front[i] = nextInt();
            }
            for (int i = 0; i < r; i++) {
                rear[i]=nextInt();
            }
            int c = 0;
            double[] ratio = new double[r*f];
            for (int i = 0; i < rear.length; i++)
                for (int j = 0; j < front.length; j++)
                    ratio[c++] = rear[i] * 1.0 / front[j];

            Arrays.sort(ratio);
            double max = 0.0;
            for (int i = 1; i < ratio.length; i++) {
                max = Math.max(max, ratio[i] / ratio[i-1]);
            }
            System.out.printf("%.2f%n", max);
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