package p11565;

import java.io.*;
import java.util.StringTokenizer;

import static java.lang.Double.parseDouble;
import static java.lang.Integer.parseInt;
import static java.lang.Long.parseLong;
import static java.lang.System.exit;

public class Main {

    static void solve() throws Exception {

        int t = nextInt();
        for (int i = 0; i < t; i++) {
            int A = nextInt();
            int B = nextInt();
            int C = nextInt();
            boolean sol = false;
            for (int x = -100; x <= 100 && !sol; x++) {
                for (int y = -100; y <= 100 && !sol; y++) {
                    for (int z = -100; z <= 100 && !sol; z++) {
                        if(x != y && x != z && y != z){
                            if(x+y+z == A && x*y*z == B && x*x+y*y+z*z==C){
                                System.out.printf("%d %d %d%n",x,y,z);
                                sol = true;
                            }
                        }
                    }
                }
            }
            if(!sol)
                System.out.println("No solution.");
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