package Other.SwercRegional2015.p7275;

import java.io.*;
import java.util.*;

import static java.lang.Double.parseDouble;
import static java.lang.Integer.parseInt;
import static java.lang.Long.parseLong;
import static java.lang.System.exit;

public class Main {

    static void solve() throws Exception {

        String line;
        boolean firstspace = false;
        while ((line = in.readLine()) != null && line.length()!=0) {
            if(firstspace)
                System.out.println();
            else
                firstspace = true;
            String [] digits = line.split(" ");
            int N = Integer.parseInt(digits[0]);
            int M = Integer.parseInt(digits[1]);
            TreeMap<Integer,Integer> tree = new TreeMap<Integer,Integer>();
            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= M; j++) {
                    int sum = i+j;
                    if(tree.containsKey(sum)){
                        int val = tree.get(sum);
                        tree.put(sum,val+1);
                    }else{
                        tree.put(sum,1);
                    }
                }
            }
            Collection<Integer> col = tree.values();
            ArrayList<Integer> vals = new ArrayList<>(col);
            Collections.sort(vals);
            int res = vals.get(vals.size()-1);
            for(Map.Entry<Integer,Integer> entry : tree.entrySet()) {
                Integer key = entry.getKey();
                Integer value = entry.getValue();
                if(value == res)
                    System.out.println(key);
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