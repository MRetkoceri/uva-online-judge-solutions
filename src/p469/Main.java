package p469;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

import static java.lang.Double.parseDouble;
import static java.lang.Integer.parseInt;
import static java.lang.Long.parseLong;
import static java.lang.System.exit;

public class Main {
    static char[][] wlands;
    static char[][] swlands;
    static int R;
    static int C;
    static void solve() throws Exception {

        int t = nextInt();
        boolean nl = false;
        String line = in.readLine();
        for (int i = 0; i < t; i++) {
            ArrayList<int[]> poswlands = new ArrayList<int[]>();
            ArrayList<char[]> wlandslist = new ArrayList<char[]>();

            while ((line = in.readLine()) != null && line.length() != 0) {
                if(Character.isDigit(line.charAt(0))){
                    String[] params = line.split(" ");
                    int[] par = {Integer.parseInt(params[0]), Integer.parseInt(params[1])};
                    poswlands.add(par);
                }else
                    wlandslist.add(line.toCharArray());
            }
            wlands = new char[wlandslist.size()][];
            wlands = wlandslist.toArray(wlands);
            swlands = new char[wlands.length][];
            for (int j = 0; j < wlands.length; j++) {
                swlands[j] = new char[wlands[j].length];
                System.arraycopy(wlands[j],0,swlands[j],0,wlands[j].length);
            }
            R = wlands.length;
            C = wlands[0].length;
            if (nl)
                out.println();
            else
                nl = true;
            for (int j = 0; j < poswlands.size(); j++) {
                int[] par = poswlands.get(j);
                out.println(floodfill(par[0]-1, par[1]-1, 'W', 'L'));
                reset();
            }
        }
    }

    static int dr[] = {1, 1, 0, -1, -1, -1, 0, 1}; // trick to explore an implicit 2D grid
    static int dc[] = {0, 1, 1, 1, 0, -1, -1, -1}; // S,SE,E,NE,N,NW,W,SW neighbors

    static int floodfill(int r, int c, char c1, char c2) {
        if (r < 0 || r >= R || c < 0 || c >= C) return 0;
        if (wlands[r][c] != c1) return 0;
        int ans = 1;
        wlands[r][c] = c2;
        for (int d = 0; d < 8; d++){
            ans += floodfill(r +dr[d], c +dc[d], c1, c2);
        }
        return ans;
    }
    
    static void reset(){
        for (int j = 0; j < wlands.length; j++) {
            System.arraycopy(swlands[j],0,wlands[j],0,wlands[j].length);
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