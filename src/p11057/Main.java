package p11057;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

import static java.lang.Double.parseDouble;
import static java.lang.Integer.parseInt;
import static java.lang.Long.parseLong;
import static java.lang.System.exit;

public class Main {

    static void solve() throws Exception {
        String line;
        while ((line = in.readLine())!=null) {
            if(line.length()==0)
                continue;
            int N = Integer.parseInt(line);
            int [] books = new int[N];
            for (int i = 0; i < books.length; i++) {
                books[i]=nextInt();
            }
            int sum = nextInt();
            in.readLine();
            Arrays.sort(books);
            int i = 0;
            int book1=0,book2=0;
            while(i<books.length && books[i]<=sum/2 ){
                int find = Arrays.binarySearch(books,i+1,books.length,sum-books[i]);
                if(find>=0) {
                    book1 = books[i];
                    book2 = books[find];
                }
                i++;
            }
            out.printf("Peter should buy books whose prices are %d and %d.%n%n",book1,book2);
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