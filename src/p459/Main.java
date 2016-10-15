package p459;

import java.io.*;
import java.util.*;

import static java.lang.Double.parseDouble;
import static java.lang.Integer.parseInt;
import static java.lang.Long.parseLong;
import static java.lang.System.exit;

public class Main {
    static int base = 'A';
    static Map<Integer,ArrayList<Integer>> adjList;
    static boolean[]visited;
    static void solve() throws Exception {

        int t = nextInt();
        boolean nl = false;
        for (int i = 0; i < t; i++) {
            int n = next().charAt(0) - base + 1;
            adjList = new HashMap<Integer, ArrayList<Integer>>();
            for (int j = 0; j < n; j++) {
                adjList.put(j,new ArrayList<>());
            }
            visited = new boolean[n];
            String edge = "";
            int v1 = 0, v2 = 0;
            while ((edge = in.readLine()) != null && edge.length() != 0) {
                v1 = edge.charAt(0);
                v2 = edge.charAt(1);
                adjList.get(v1 - base).add(v2 - base);
                adjList.get(v2 - base).add(v1 - base);
            }
            int max = 0;
            for (Integer j : adjList.keySet()) {
                if (!visited[j]) {
                    dfs(j);
                    max++;
                }
            }
            if(nl)
                out.println();
            else
                nl=true;
            out.println(max);
        }
    }

    static void dfs(int u){
        if(!adjList.containsKey(u))
            return;
        visited[u] = true;
        for(Integer i:adjList.get(u)){
            if(!visited[i]){
                visited[i] = true;
                dfs(i);
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