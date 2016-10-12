package p11902;

import java.io.*;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;
import java.util.Vector;

import static java.lang.Double.parseDouble;
import static java.lang.Integer.parseInt;
import static java.lang.Long.parseLong;
import static java.lang.System.exit;

public class Main {

    static class IntegerPair implements Comparable {
        Integer _first, _second;

        public IntegerPair(Integer f, Integer s) {
            _first = f;
            _second = s;
        }

        public int compareTo(Object o) {
            if (!this.first().equals(((IntegerPair)o).first()))
                return this.first() - ((IntegerPair)o).first();
            else
                return this.second() - ((IntegerPair)o).second();
        }

        Integer first() { return _first; }
        Integer second() { return _second; }
    }

    static Vector<Vector<IntegerPair>> adjList;
    static int[] visited;

    static void dfs(int u, int disable){
        //out.printf("%d ",u);
        visited[u] = 1;
        for (int i = 0; i < adjList.get(u).size(); i++) {
            IntegerPair v = adjList.get(u).get(i);
            if(v.first() == disable)
                continue;
            if(visited[v.first()]!=1){
                dfs(v.first(),disable);
            }
        }
    }

    static void solve() throws Exception {
        int t = nextInt();
        for (int i = 1; i <= t; i++) {
            int n = nextInt();
            adjList = new Vector<Vector<IntegerPair>>(n);
            for (int j = 0; j < n; j++) {
                adjList.add(new Vector<IntegerPair>());
                for (int k = 0; k < n; k++) {
                    int w = nextInt();
                    if(w != 0)
                        adjList.get(j).add(new IntegerPair(k,w));
                }
            }
            out.printf("Case %d:%n",i);
            printRow(n);
            visited = new int[n];
            dfs(0,-1);
            int [] vif = Arrays.copyOf(visited,visited.length);
            StringBuilder sb = new StringBuilder(printRow(n));
            sb.append("|");
            for (int k = 0; k < visited.length; k++) {
                if(vif[k] == 1)
                    sb.append("Y|");
                else
                    sb.append("N|");
            }
            sb.append("\n");
            sb.append(printRow(n));
            for (int j = 1; j < n; j++) {
                visited = new int[n];
                dfs(0,j);
                sb.append("|");
                for (int k = 0; k < visited.length; k++) {
                    if(visited[k] == 0 && vif[k] == 1)
                        sb.append("Y|");
                    else
                        sb.append("N|");
                }
                sb.append("\n");
                sb.append(printRow(n));
            }
            out.print(sb.toString());
        }
    }

    static String printRow(int n){
        return String.format("+%0" + (2*n-1) + "d+%n", 0).replace('0', '-');
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