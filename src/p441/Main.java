package p441;

import java.io.*;
import java.util.StringTokenizer;

import static java.lang.Double.parseDouble;
import static java.lang.Integer.parseInt;
import static java.lang.Long.parseLong;
import static java.lang.System.exit;

public class Main {

    static void solve() throws Exception {

        int k;
        boolean spaceToPrint = false;
        while ((k = nextInt()) != 0) {
            if(spaceToPrint)
                System.out.println();
            else
                spaceToPrint = true;
            int []arr = new int[k];
            for (int i = 0; i < arr.length; i++) {
                arr[i] = nextInt();
            }
            for (int i = 0; i < k-5; i++) {
                for (int j = i+1; j < k-4; j++) {
                    for (int l = j+1; l < k-3; l++) {
                        for (int m = l+1; m < k-2; m++) {
                            for (int n = m+1; n < k-1; n++) {
                                for (int o = n+1; o < k; o++) {
                                    System.out.printf("%d %d %d %d %d %d%n",arr[i],arr[j],arr[l],arr[m],arr[n],arr[o]);
                                }
                            }
                        }
                    }
                }
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