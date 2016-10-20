package p10567;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

import static java.lang.Double.parseDouble;
import static java.lang.Integer.parseInt;
import static java.lang.Long.parseLong;
import static java.lang.System.exit;

public class Main {

    static int A = 'A';
    static int z = 'z';
    static void solve() throws Exception {

        String S = in.readLine();
        int Q = Integer.parseInt(in.readLine());
        int length = z-A+1;
        int [][] states = new int[length][];
        ArrayList<ArrayList<Integer>> stateslist = new ArrayList<ArrayList<Integer>>(length);
        for (int i = 0; i < length; i++) {
            stateslist.add(new ArrayList<>());
        }
        for (int i = 0; i < S.length(); i++) {
            stateslist.get(S.charAt(i)-A).add(i);
        }
        for (int i = 0; i < length; i++) {
            states[i]=new int[stateslist.get(i).size()];
            states[i]= stateslist.get(i).stream().filter(num -> num != null).mapToInt(num -> num).toArray();
        }
        stateslist = null;
        for (int i = 0; i < Q; i++) {
            String q = in.readLine();
            boolean sol = true;
            int last = -1,first = 0;
            for (int j = 0; j < q.length(); j++) {
                int[]state = states[q.charAt(j)-A];
                last = Arrays.binarySearch(state,last+1);
                if(last==-state.length-1) {
                    sol = false;
                    break;
                }
                else if(last<0)
                    last = state[-last-1];
                else
                    last = state[last];
                if(j==0)
                    first = last;

            }
            if(sol)
                out.printf("Matched %d %d%n",first,last);
            else
                out.println("Not matched");
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