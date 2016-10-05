package Chap1Introduction.easy.p11559;

import static java.lang.Double.parseDouble;
import static java.lang.Integer.parseInt;
import static java.lang.Long.parseLong;
import static java.lang.System.exit;
import static java.util.Arrays.fill;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
	
	static void solve() throws Exception {


		int N,B,H,W;
        String line;
		while ((line = in.readLine()) != null && line.length() > 0) {
			String [] input = line.split(" ");
            N = Integer.parseInt(input[0]) ;
            B = Integer.parseInt(input[1]);
            H = Integer.parseInt(input[2]);
            W = Integer.parseInt(input[3]);
            int price;
            int bestDeal = B+1;
            for (int i = 0; i < H; i++) {
                price = nextInt();
                int [] rooms = new int[W];
                for (int j = 0; j < W; j++) {
                    rooms[j]=nextInt();
                }
                int totalPrice = price*N;
                if(totalPrice <= B){
                    for (int j = 0; j < rooms.length; j++) {
                        if(N <= rooms[j]){
                            if(totalPrice < bestDeal)
                                bestDeal = totalPrice;
                            break;
                        }
                    }
                }
            }
            if(bestDeal > B)
                System.out.println("stay home");
            else
                System.out.println(bestDeal);
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