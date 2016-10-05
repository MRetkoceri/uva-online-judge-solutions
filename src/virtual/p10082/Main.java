package virtual.p10082;

import java.io.*;
import java.util.StringTokenizer;

import static java.lang.Double.parseDouble;
import static java.lang.Integer.parseInt;
import static java.lang.Long.parseLong;
import static java.lang.System.exit;

public class Main {

    static void solve() throws Exception {

        String n = "`1234567890-=";
        String a = "QWERTYUIOP[]\\";
        String b = "ASDFGHJKL;'";
        String c = "ZXCVBNM,./";
        String line;
        while ((line = in.readLine()) != null) {
            for (int i = 0; i < line.length(); i++) {
                String str = line.charAt(i)+"";
                if(a.contains(str)){
                    System.out.print(a.charAt(a.indexOf(str)-1));
                }
                else if(b.contains(str)){
                    System.out.print(b.charAt(b.indexOf(str)-1));
                }
                else if(c.contains(str)){
                    System.out.print(c.charAt(c.indexOf(str)-1));

                }else if(n.contains(str)){
                    System.out.print(n.charAt(n.indexOf(str)-1));
                }
                else{
                    System.out.print(str);
                }
            }
            System.out.println();
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