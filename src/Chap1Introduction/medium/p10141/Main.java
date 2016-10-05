package Chap1Introduction.medium.p10141;

import static java.lang.Double.parseDouble;
import static java.lang.Integer.parseInt;
import static java.lang.Long.parseLong;
import static java.lang.System.exit;
import static java.util.Arrays.fill;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
	
	static void solve() throws Exception {

		int n;
		int rfp = 1;
		boolean flag = false;
		while ((n = nextInt()) != 0) {
			if(flag)
				System.out.println();
			else
				flag = true;
			int p = nextInt();
			for (int i = 0; i < n; i++) {
				in.readLine();
			}
			double compliance = 0.0;
			String bestProposal = "";
			double lowestPrice = Double.MAX_VALUE;
			for (int i = 0; i < p; i++) {
				String proposal = in.readLine();
				double price = nextDouble();
				double reqMet = nextInt();
				for (int j = 0; j < reqMet; j++) {
					in.readLine();
				}
				if(compliance < reqMet/n){
					bestProposal = proposal;
					compliance = reqMet/n;
					lowestPrice = price;
				}else if(compliance == reqMet/n){
					if(price < lowestPrice){
						bestProposal = proposal;
						compliance = reqMet/n;
						lowestPrice = price;
					}
				}
			}
			System.out.println("RFP #"+rfp);
			System.out.println(bestProposal);
			rfp++;
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