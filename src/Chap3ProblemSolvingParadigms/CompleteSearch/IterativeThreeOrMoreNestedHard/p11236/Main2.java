package Chap3ProblemSolvingParadigms.CompleteSearch.IterativeThreeOrMoreNestedHard.p11236;

import java.io.*;
import java.math.BigDecimal;
import java.util.StringTokenizer;

import static java.lang.Double.parseDouble;
import static java.lang.Integer.parseInt;
import static java.lang.Long.parseLong;
import static java.lang.System.exit;

public class Main2 {

    //naive solution without using BigDecimal
    static void solve() throws Exception {

        StringBuffer sb = new StringBuffer();
        double a,b,c,d;
        int count = 0;
        long start = System.nanoTime();
        for(a = 0.01; a<=20.0; a+=0.01){
            //a = r(a);
            for(b = a; a+b<=20.0; b+=0.01){
                //b = r(b);
                for(c = b; a+b+c<=20.0; c+=0.01){
                    //c = r(c);
                    d = (a+b+c)/((a*b*c-1));
                    if( d < 0 || d > 20 || a+b+c+d > 20.01 || d+0.01<c )
                        continue;
                    if(r(a+b+c+d) == Math.round(a*b*c*d*100000000.0)/100000000.0) {
                        sb.append(String.format("%.2f %.2f %.2f %.2f%n", a, b, c, d));
                        //count++;
                    }
                }
            }
        }
        out.print(sb.toString());
        //out.println(count+" "+(System.nanoTime()-start)/1000000000.0);
    }

    static double r(double a){
        return Math.round(a*100.0)/100.0;
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