package p11831;

import java.io.*;
import java.util.StringTokenizer;

import static java.lang.Double.parseDouble;
import static java.lang.Integer.parseInt;
import static java.lang.Long.parseLong;
import static java.lang.System.exit;

public class Main {

    static char[][] grid;
    static int [] dr = {-1, 0, 1, 0};
    static int [] dc = { 0, 1, 0,-1};
    static int N,M;
    //N S L O
    static void solve() throws Exception {

        String line;
        while((line = in.readLine()) != null & !line.equals("0 0 0")){
            String [] params = line.split(" ");
            N = Integer.parseInt(params[0]);
            M = Integer.parseInt(params[1]);
            int S = Integer.parseInt(params[2]);
            grid = new char[N][M];
            for (int i = 0; i < N; i++) {
                grid[i] = in.readLine().toCharArray();
            }
            char[]instr = in.readLine().toCharArray();
            int count = -1;
            for (int i = 0; i < N && count<0; i++) {
                for (int j = 0; j < M && count<0; j++) {
                    switch(grid[i][j]){
                        case'N':count = move(0,i,j,0,instr);
                            break;
                        case'L':count = move(1,i,j,0,instr);
                            break;
                        case'S':count = move(2,i,j,0,instr);
                            break;
                        case'O':count = move(3,i,j,0,instr);
                            break;
                    }
                }
            }
            out.println(count);
        }
    }

    static int move(int dir, int r, int c, int pos, char[] instr) {
        if(r < 0 || r >= N  || c < 0 || c >= M || grid[r][c] == '#')
            return move(dir, r-dr[dir], c-dc[dir], pos, instr);
        int val = 0;
        if(grid[r][c]=='*'){
            grid[r][c]='.';
            val = 1;
        }
        if(pos == instr.length)
            return val;
        else if(instr[pos] == 'D'){
            return val + move((dir+1)%4,r,c,pos+1,instr);
        }
        else if(instr[pos] == 'E'){
            return val + move((dir+3)%4,r,c,pos+1,instr);
        }
        else{
            return val + move(dir,r+dr[dir],c+dc[dir],pos+1,instr);
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