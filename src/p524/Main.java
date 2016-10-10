package p524;

import java.io.*;
import java.util.StringTokenizer;

import static java.lang.Double.parseDouble;
import static java.lang.Integer.parseInt;
import static java.lang.Long.parseLong;
import static java.lang.System.exit;

public class Main {

    static void solve() throws Exception {
        boolean f = false;
        String line;
        int c = 1;
        while ((line = in.readLine()) != null && line.length() !=0) {
            int n = Integer.parseInt(line);
            int [] circle = new int[n];
            circle[0] = 1;
            if(f)
                out.println();
            else
                f=true;
            out.printf("Case %d:%n",c++);
            backtrack(1, circle);
        }
    }

    static void backtrack(int pos, int [] circle){
        if(pos == circle.length){
            out.print(circle[0]);
            for (int i = 1; i < circle.length; i++) {
                out.printf(" %d",circle[i]);
            }
            out.println();
        }else {
            for (int i = 2; i <= circle.length; i++) {
                if (((pos == circle.length-1 && isPrime(circle[pos - 1] + i) && isPrime(circle[0] + i))
                        || (pos < circle.length-1 && isPrime(circle[pos - 1] + i)))
                        && !isRepeated(i,circle))
                {
                    circle[pos] = i;
                    backtrack(pos + 1, circle);
                    circle[pos] = 0;
                }
            }
        }
    }

    static boolean isRepeated(int i, int[]circle) {
        for (int j = 0; j < circle.length; j++) {
            if(circle[j]==i)
                return true;
        }
        return false;
    }

    static boolean isPrime(int n) {
        for (int i = 2; i <= n / 2; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
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