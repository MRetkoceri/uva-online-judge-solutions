package p624;

import java.io.*;
import java.util.StringTokenizer;

import static java.lang.Double.parseDouble;
import static java.lang.Integer.parseInt;
import static java.lang.Long.parseLong;
import static java.lang.System.exit;

public class Main {

    static int [] cd;
    static int N;
    static void solve() throws Exception {

        String line;
        long start = System.nanoTime();
        while ((line = in.readLine()) != null && line.length() != 0) {
            String[]params = line.split(" ");
            N = Integer.parseInt(params[0]);
            cd = new int[Integer.parseInt(params[1])];
            for (int i = 0; i < cd.length; i++) {
                cd[i] = Integer.parseInt(params[i+2]);
            }
            int max = 0;
            int len = 0;
            String tracks = "";
            for (int i = 1; i < Math.pow(2,cd.length); i++) {
                int sum = 0;
                int l = 0;
                String bits = String.format("%"+cd.length+"s",Integer.toBinaryString(i)).replace(" ","0");
                for (int j = 0; j < bits.length(); j++) {
                    if(sum > N)
                        break;
                    if(bits.charAt(j) == '1'){
                        sum+=cd[j];
                        l++;
                    }
                }
                if(max < sum) {
                    max = sum;
                    tracks = bits;
                    len = l;
                }else if(max == sum && len <= l){
                    max = sum;
                    tracks = bits;
                    len = l;
                }
            }
            for (int i = 0; i < tracks.length(); i++) {
                if(tracks.charAt(i) == '1'){
                    out.printf("%d ",cd[i]);
                }
            }
            out.printf("sum:%d%n",max);
        }
        out.println((System.nanoTime()-start)/10000000000.0);
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