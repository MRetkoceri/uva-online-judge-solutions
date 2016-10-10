package p353;

import java.io.*;
import java.util.HashSet;
import java.util.StringTokenizer;

import static java.lang.Double.parseDouble;
import static java.lang.Integer.parseInt;
import static java.lang.Long.parseLong;
import static java.lang.System.exit;

public class Main {

    static void solve() throws Exception {
        HashSet<String> set = new HashSet<String>();
        String line;
        while ((line = in.readLine()) != null && line.length()!=0) {
            int palin = 0 ;
            for (int s = 1; s <= line.length(); s++) {
                for (int i = 0; i <= line.length()-s; i++) {
                    String pal = line.substring(i,i+s);
                    if(isPalindrome(pal)&&!set.contains(pal)) {
                        set.add(pal);
                        palin++;
                    }
                }
            }
            set.clear();
            System.out.printf("The string '%s' contains %d palindromes.%n",line,palin);
        }
    }
    static boolean isPalindrome(String s){
        for (int i = 0; i < s.length()/2; i++) {
            if(s.charAt(i)!=s.charAt(s.length()-1-i))
                return false;
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