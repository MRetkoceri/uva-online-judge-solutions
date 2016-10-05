package virtual.p10098;

import java.io.*;
import java.util.*;

import static java.lang.Double.parseDouble;
import static java.lang.Integer.parseInt;
import static java.lang.Long.parseLong;
import static java.lang.System.exit;

public class Main {
    static TreeSet<String> treeset;
    static StringBuffer sb;
    static void solve() throws Exception {

        int t = nextInt();
        for (int i = 0; i < t; i++) {
            char[]c = in.readLine().toCharArray();
            Arrays.sort(c);
            double start = System.nanoTime();
            sb = new StringBuffer();
            perm1("",new String(c));
            //sb.append((System.nanoTime()-start)/1000000000.0);
            out.print(sb.toString());
        }
    }
    private static void perm1(String prefix, String s) {
        int n = s.length();
        if (n == 0) {
            out.println(prefix);
            sb.append(prefix);
            sb.append("\n");
        }
        else {
            for (int i = 0; i < n; i++) {
                if (i < s.length() - 1) {
                    if (s.charAt(i) == s.charAt(i + 1)) {
                        continue;
                    }
                }
                perm1(prefix + s.charAt(i), s.substring(0, i)+s.substring(i + 1, n));
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