package p573;

import static java.lang.Double.parseDouble;
import static java.lang.Integer.parseInt;
import static java.lang.Long.parseLong;
import static java.lang.System.exit;
import static java.util.Arrays.fill;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
	
	static void solve() throws Exception {
		int H,D,F;
        double U;
		while ((H = nextInt()) != 0) {
			U = nextDouble();
			D = nextInt();
			F = nextInt();
            int day = 0;
            double height = 0;
            double loss = (U* (F/100.0));
            do{
                height+=(U >= 0)?U:0;
                if(height < 0 || height > H) {
                    day++;
                    break;
                }
                height-=D;
                U-=loss;
                day++;
            }while(height >= 0 && height <= H);
            String output = (height <= 0)?"failure":"success";
            System.out.println(output+" on day "+day);
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