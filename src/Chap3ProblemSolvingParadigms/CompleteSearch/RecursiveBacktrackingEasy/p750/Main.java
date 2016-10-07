package Chap3ProblemSolvingParadigms.CompleteSearch.RecursiveBacktrackingEasy.p750;

import java.io.*;
import java.util.StringTokenizer;

import static java.lang.Double.parseDouble;
import static java.lang.Integer.parseInt;
import static java.lang.Long.parseLong;
import static java.lang.System.exit;

public class Main {

    static int board[] = new int[8];
    static int x,y;
    static int sol;
    static void solve() throws Exception {

        int t = nextInt();
        boolean firstNewLine = false;
        for (int i = 0; i < t; i++) {
            x = nextInt();
            y = nextInt();
            if(firstNewLine)
                out.println();
            else
                firstNewLine=true;
            out.println("SOLN       COLUMN\n #      1 2 3 4 5 6 7 8\n");
            sol=1;
            backtrack(0);
        }
    }

    static void backtrack(int col){
        if(col == board.length && board[y-1] == x){
            out.printf("%2d     ",sol++);
            for (int i = 0; i < board.length; i++) {
                out.printf(" %d",board[i]);
            }
            out.println();
        }
        for (int row = 1; row <= board.length; row++) {
            if(place(row,col)){
                board[col]=row;
                backtrack(col+1);
            }
        }
    }

    static boolean place(int row, int col){
        for (int i = 0; i < col; i++) {
            if(row == board[i] || Math.abs(board[i]-row)==Math.abs(col-i))
                return false;
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