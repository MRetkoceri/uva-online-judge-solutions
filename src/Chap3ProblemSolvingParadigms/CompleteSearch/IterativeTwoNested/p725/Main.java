package Chap3ProblemSolvingParadigms.CompleteSearch.IterativeTwoNested.p725;

import java.io.*;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

import static java.lang.Double.parseDouble;
import static java.lang.Integer.parseInt;
import static java.lang.Long.parseLong;
import static java.lang.System.exit;

public class Main {

    static void solve() throws Exception {

        int n;
        boolean first = true;
        while ((n = nextInt()) != 0) {
            boolean nosol = true;
            if(!first){
                System.out.println();
            }else{
                first=false;
            }
            Set<Character> set = new HashSet<Character>();
            for (int a = 1234 ; a <= 98765/n ; a++) {
                int b = a*n;
                String da = (a<10000)? "0"+a:a+"";
                String digits = (a<10000)? "0"+a+""+b : a+""+b;
                for (int i = 0; i < digits.length(); i++) {
                    set.add(digits.charAt(i));
                }
                if(set.size() == 10) {
                    System.out.printf("%d / %s = %d%n", b, da, n);
                    nosol = false;
                }
                set.clear();
            }
            if(nosol)
                System.out.printf("There are no solutions for %d.%n",n);
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