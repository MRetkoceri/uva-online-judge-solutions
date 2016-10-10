package p12455;

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
            boolean sol = false;
            int target = nextInt();
            int p = nextInt();
            int [] bars = new int[p];
            for (int j = 0; j < p; j++) {
                bars[j] = nextInt();
            }
            for (int j = 0; j < Math.pow(2, p) && !sol; j++) {
                String bits = String.format("%"+p+"s",Integer.toBinaryString(j)).replace(" ","0");
                int sum = 0;
                for (int k = 0; k < bits.length(); k++) {
                    if(bits.charAt(k)=='1')
                        sum+=bars[k];
                }
                if(sum == target){
                    System.out.println("YES");
                    sol = true;
                }
            }
            if(!sol)
                System.out.println("NO");
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