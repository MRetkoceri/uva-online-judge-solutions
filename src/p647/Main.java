package p647;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.StringTokenizer;

import static java.lang.Double.parseDouble;
import static java.lang.Integer.parseInt;
import static java.lang.Long.parseLong;
import static java.lang.System.exit;

public class Main {

    static void solve() throws Exception {

        ArrayList<Integer> dieThrows = new ArrayList<>();
        int dthrows;
        while ((dthrows = nextInt()) != 0) {
            dieThrows.add(dthrows);
        }
        int p;
        while((p = nextInt()) != 0){
            HashMap<Integer,Integer> ladders = new HashMap<Integer,Integer>();
            HashMap<Integer,Integer> chutes = new HashMap<Integer,Integer>();
            HashSet<Integer> turns = new HashSet<Integer>();
            String line;
            while(!(line = in.readLine()).equals("0 0")){
                String[]lc = line.split(" ");
                int n1 = Integer.parseInt(lc[0]);
                int n2 = Integer.parseInt(lc[1]);
                if(n1<n2)
                    ladders.put(n1,n2);
                else
                    chutes.put(n1,n2);
            }
            int tt;
            while((tt = nextInt()) != 0){
                turns.add(tt);
            }
            //game
            int [] players = new int[p];
            int i = 0;
            int thrown = 0;
            while(true){
                if(thrown == dieThrows.size())
                    thrown = 0;
                if(i==players.length)
                    i=0;
                if(players[i]<0){
                    players[i]=-players[i];
                    i++;
                    continue;
                }
                int jump = dieThrows.get(thrown);
                if(ladders.containsKey(players[i]+jump)) {
                    players[i] = ladders.get(players[i]+jump);
                }
                else if(chutes.containsKey(players[i]+jump)){
                    players[i] = chutes.get(players[i]+jump);
                }
                else if(turns.contains(players[i]+jump)){
                    players[i]+=jump;
                    thrown++;
                    continue;
                }
                else if(turns.contains(-(players[i]+jump))){
                    players[i]+=jump;
                    players[i]*=-1;
                }
                else if(players[i]+jump < 100){
                    players[i]+=jump;
                }
                else if(players[i]+jump == 100){
                    System.out.println(i+1);
                    break;
                }
                i++;
                thrown++;
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