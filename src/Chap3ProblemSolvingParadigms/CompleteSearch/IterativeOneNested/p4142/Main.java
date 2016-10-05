package Chap3ProblemSolvingParadigms.CompleteSearch.IterativeOneNested.p4142;

import java.io.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.StringTokenizer;

import static java.lang.Double.parseDouble;
import static java.lang.Integer.parseInt;
import static java.lang.Long.parseLong;
import static java.lang.System.exit;

public class Main {

    static void solve() throws Exception {

        boolean fspace = false;
        int t = nextInt();
        for (int i = 0; i < t; i++) {
            if(fspace)
                System.out.println();
            else
                fspace=true;
            int D = nextInt();
            String [] dbnames = new String[D];
            int [][] db = new int[D][2];
            for (int j = 0; j < D; j++) {
                dbnames[j] = next();
                db[j][0]=nextInt();
                db[j][1]=nextInt();
            }
            int Q = nextInt();
            for (int j = 0; j < Q; j++) {
                int query = nextInt();
                int count = 0;
                int foundindex = 0;
                for (int k = 0; k < D; k++) {
                    if(query >= db[k][0] && query <= db[k][1]) {
                        count++;
                        foundindex=k;
                    }
                }
                if(count == 1)
                    System.out.println(dbnames[foundindex]);
                else
                    System.out.println("UNDETERMINED");

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