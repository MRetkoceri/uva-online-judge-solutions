package p11799;

import static java.lang.Double.parseDouble;
import static java.lang.Integer.parseInt;
import static java.lang.Long.parseLong;
import static java.lang.System.exit;
import static java.util.Arrays.fill;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
	
	static void solve() throws Exception {

		int t = nextInt();
		for (int i = 1; i <= t; i++) {
			int clowns = nextInt();
			int max = 0;
			for (int j = 0; j < clowns; j++) {
				int clown = nextInt();
				if(max < clown)
					max = clown;
			}
			System.out.println("Case "+i+": "+max);
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