package Other.regional2014arab;

/**
 * Created by Muhamed on 9/10/2016.
 */

import static java.lang.Integer.parseInt;
import static java.lang.System.exit;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class p7163 {

    static void solve() throws Exception{
        int T = nextInt();

        for (int i = 0; i < T; i++) {
            int X = nextInt();
            int N = nextInt();
            int Y = nextInt();
            int M = nextInt();
            BigInteger c1 = new BigInteger(X+"");
            BigInteger c2 = new BigInteger("0");

            for (int j = 0; j <= M; j++) {
                if(j==N){
                    if(c1.compareTo(c2) < 0) {
                        c2=c2.add(new BigInteger(Y+""));
                    }
                    else
                        c1=c1.add(new BigInteger(Y+""));
                }
                else if(c1.compareTo(c2) < 0){
                    c1=c1.add(c2);
                }
                else
                    c2=c2.add(c1);
                //System.out.println(c1.toString()+" "+c2.toString());
            }
            System.out.println("Case "+(i+1)+": "+c1.gcd(c2));
        }
    }

    static int nextInt() throws IOException {
        return parseInt(next());
    }

    static String next() throws IOException {
        while (tok == null || !tok.hasMoreTokens()) {
            tok = new StringTokenizer(in.readLine());
        }
        return tok.nextToken();
    }

    public static void main(String[] args) {
        try {
            in = new BufferedReader(new InputStreamReader(System.in));
            out = new PrintWriter(new OutputStreamWriter(System.out));
            solve();
            in.close();
            out.close();
        } catch (Throwable e) {
            e.printStackTrace();
            exit(0);
        }
    }

    static BufferedReader in;
    static PrintWriter out;
    static StringTokenizer tok;

}
