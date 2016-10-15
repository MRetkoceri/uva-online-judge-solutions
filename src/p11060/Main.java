package p11060;

import java.io.*;
import java.util.*;

import static java.lang.Double.parseDouble;
import static java.lang.Integer.parseInt;
import static java.lang.Long.parseLong;
import static java.lang.System.exit;

public class Main {

    static boolean [][] adjMat;
    static int[] inDegree;
    static String [] names;
    static void solve() throws Exception {

        int t = 1;
        String line;
        while((line = in.readLine()) != null && line.length()!=0){
            int n = Integer.parseInt(line);
            names = new String[n];
            HashMap<String,Integer> nameId = new HashMap<String,Integer>();
            for (int i = 0; i < n; i++) {
                names[i] = in.readLine();
                nameId.put(names[i],i);
            }
            adjMat = new boolean[n][n];
            inDegree = new int[n];
            int m = Integer.parseInt(in.readLine());
            for (int i = 0; i < m; i++) {
                String fst = next();
                String snd = next();
                if(!adjMat[nameId.get(fst)][nameId.get(snd)]){
                    adjMat[nameId.get(fst)][nameId.get(snd)]=true;
                    inDegree[nameId.get(snd)]++;
                }
            }
            out.printf("Case #%d: Dilbert should drink beverages in this order:",t++);
            for (String s : kahn()) {
                out.print(s);
            }
            out.printf(".%n%n");
            in.readLine();
        }
    }

    static List<String> kahn(){
        List<String> topsort = new ArrayList<String>();
        PriorityQueue<Integer> queue = new PriorityQueue<Integer>();
        for (int i = 0; i < inDegree.length; i++) {
            if(inDegree[i] == 0)
                queue.add(i);
        }
        while(!queue.isEmpty()){
            int v = queue.poll();
            topsort.add(" "+names[v]);
            for (int i = 0; i < adjMat.length; i++) {
                if(adjMat[v][i] && --inDegree[i]==0){
                    queue.add(i);
                }
            }
        }

        return topsort;
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