package Chap3ProblemSolvingParadigms.CompleteSearch.IterativeFancyTechniques.p11742;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

import static java.lang.Double.parseDouble;
import static java.lang.Integer.parseInt;
import static java.lang.Long.parseLong;
import static java.lang.System.exit;

public class Main {

    static int [][] constraints;
    static void solve() throws Exception {

        String line;
        int n,m;
        while (!(line = in.readLine()).equals("0 0")) {
            String []nm = line.split(" ");
            n = Integer.parseInt(nm[0]);
            m = Integer.parseInt(nm[1]);
            int [] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i]=i;
            }
            constraints = new int[m][3];
            for (int i = 0; i < m; i++) {
                constraints[i][0] = nextInt();
                constraints[i][1] = nextInt();
                constraints[i][2] = nextInt();
            }
            System.out.println(permutations(a,a.length));
        }
    }

    static int permutations(int[]a,int n){
        if(n==1){
            //System.out.println(Arrays.toString(a));
            if(checkConstraints(a))
                return 1;
            return 0;
        }
        int perms = 0;
        for (int i = 0; i < n; i++) {
            int temp = a[i];
            a[i] = a[n-1];
            a[n-1] = temp;
            perms += permutations(a,n-1);
            temp = a[i];
            a[i] = a[n-1];
            a[n-1] = temp;
        }
        return perms;
    }

    private static boolean checkConstraints(int[] arr) {
        for (int i = 0; i < constraints.length; i++) {
            int a = 0 , b = 0 , c;
            for (int j = 0; j < arr.length; j++) {
                if(arr[j]==constraints[i][0])
                    a = j;
                else if(arr[j]==constraints[i][1])
                    b = j;
            }
            c = constraints[i][2];
            if(c < 0){
                if(Math.abs(a-b) < -c)
                    return false;
            }else{
                if(Math.abs(a-b) > c)
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