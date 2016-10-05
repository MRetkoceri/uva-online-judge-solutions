package Chap3ProblemSolvingParadigms.CompleteSearch.IterativeTwoNested.p10487;

import java.io.*;
import java.util.StringTokenizer;

import static java.lang.Double.parseDouble;
import static java.lang.Integer.parseInt;
import static java.lang.Long.parseLong;
import static java.lang.System.exit;

public class Main {

    static void solve() throws Exception {

        int n;
        int t = 1;
        while ((n = nextInt()) != 0) {
            int [] set = new int[n];
            for (int i = 0; i < n; i++) {
                set[i] = nextInt();
            }
            System.out.printf("Case %d:%n",t++);
            int m = nextInt();
            for (int i = 0; i < m; i++) {
                int dif = Integer.MAX_VALUE;
                int query = nextInt();
                int sum = query;
                for (int j = 0; j < n; j++) {
                    for (int k = j+1; k < n; k++) {
                        if(Math.abs(set[j]+set[k]-query) < dif){
                            dif = Math.abs(set[j]+set[k]-query);
                            sum = set[j]+set[k];
                        }
                    }
                }
                System.out.printf("Closest sum to %d is %d.%n",query,sum);
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