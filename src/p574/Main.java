package p574;

import java.io.*;
import java.util.*;

import static java.lang.Double.parseDouble;
import static java.lang.Integer.parseInt;
import static java.lang.Long.parseLong;
import static java.lang.System.exit;

public class Main {

    static void solve() throws Exception {

        int t,n;
        while (((t = nextInt()) != 0)&&((n = nextInt()) != 0)) {
            int [] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = nextInt();
            }
            Arrays.sort(arr);
            reverseInts(arr);
            ArrayList<String> list = new ArrayList<String>();
            out.printf("Sums of %d:%n",t);
            Set<String> set = new HashSet<String>();
            for (int i = 1; i <= Math.pow(2,arr.length); i++) {
                String bits = String.format("%"+arr.length+"s",Integer.toBinaryString(i)).replace(" ","0");
                int sum = 0;
                StringBuilder sb = new StringBuilder("");
                boolean f = false;
                for (int j = 0; j < bits.length(); j++) {
                    if(bits.charAt(j)=='1'){
                        if(f)
                            sb.append("+");
                        else
                            f = true;
                        sb.append(arr[j]);
                        sum+=arr[j];
                    }
                }
                if(sum == t && !set.contains(sb.toString())){
                    list.add(sb.toString());
                    set.add(sb.toString());
                }
            }
            if(list.size() == 0)
                out.println("NONE");
            else{
                Collections.reverse(list);
                for (String s:list){
                    out.println(s);
                }
            }
        }
    }

    static void reverseInts(int [] arr){
        for (int i = 0; i < arr.length/2; i++) {
            int temp = arr[i];
            arr[i] = arr[arr.length-1-i];
            arr[arr.length-1-i] = temp;
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