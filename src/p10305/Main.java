package p10305;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import static java.lang.Double.parseDouble;
import static java.lang.Integer.parseInt;
import static java.lang.Long.parseLong;
import static java.lang.System.exit;

public class Main {

    static boolean [] visited;
    static List<Integer> topsort;
    private static List<List<Integer>> adjList;

    static void solve() throws Exception {

        int n,m;
        while ((n = nextInt()) != 0) {
            m=nextInt();
            adjList = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                adjList.add(new ArrayList<>());
            }
            topsort=new ArrayList<>();
            visited=new boolean[n];
            for (int i = 0; i < m; i++) {
                int f = nextInt()-1;
                int s = nextInt()-1;
                adjList.get(f).add(s);
            }
            for (int i = 0; i < n; i++)
            {
                if (!visited[i])
                    dfs(i);
            }
            out.print(topsort.get(topsort.size()-1));
            for (int i = topsort.size()-2; i >=0; i--) {
                out.printf(" %d",topsort.get(i));
            }
            out.println();
        }
    }

    private static void dfs(final int i)
    {
        visited[i] = true;

        for (int j = 0; j < adjList.get(i).size(); j++)
        {
            int n = adjList.get(i).get(j);
            if (!visited[n])
            {
                dfs(n);
            }
        }

        topsort.add(i+1);
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