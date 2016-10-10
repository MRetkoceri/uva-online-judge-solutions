package Other.p7196;

/**
 * Created by Muhamed on 9/10/2016.
 */

import static java.lang.Integer.parseInt;
import static java.lang.System.exit;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class p7196 {

    static void solve() throws Exception {
        String n;
        while(!(n=in.readLine()).equals("-1")){
            char[]chars = in.readLine().replaceAll(" ","").toCharArray();
            //ArrayList<String> nums = new ArrayList<>();
            int eq = 0,vari,total = 0;
            char var = 'x';
            for (int i = 0; i < chars.length; i++) {
                if(chars[i] == '=')
                    eq = i;
                if(Character.isLetter(chars[i])){
                    var = chars[i];
                    vari= i;
                }
            }
            boolean neg = false;
            for (int i = 0; i < chars.length; i+=2) {
                if(chars[i] == '+'){
                    if(i<eq){
                        if(Character.isDigit(chars[i+1]))
                            total+=-(Character.getNumericValue(chars[i+1]));
                    }
                    else {
                        if(Character.isDigit(chars[i+1]))
                            total+=(Character.getNumericValue(chars[i+1]));
                    }
                }
                else if(chars[i] == '-'){
                    if(i<eq){
                        if(Character.isDigit(chars[i+1]))
                            total+=(Character.getNumericValue(chars[i+1]));
                        else
                            neg = !neg;

                    }
                    else{
                        if(Character.isDigit(chars[i+1]))
                            total+=-(Character.getNumericValue(chars[i+1]));
                    }
                }
                else if(chars[i]=='=')
                    i--;
                else if(Character.isDigit(chars[i])){
                    if(i<eq)
                        total+=-(Character.getNumericValue(chars[i]));
                    else
                        total+=Character.getNumericValue(chars[i]);
                    i--;
                }else{
                    if(i>eq)
                        neg = !neg;
                }
            }
            if(neg)
                total=-total;
            System.out.println(var+" = "+total);
        }
    }

    static int nextInt() throws IOException {
        return parseInt(next());
    }

    static String next() throws IOException {
        while (tok == null || !tok.hasMoreTokens()) {
            tok = new StringTokenizer(in.readLine());
        }
        return tok.nextToken();
    }

    public static void main(String[] args) {
        try {
            in = new BufferedReader(new InputStreamReader(System.in));
            out = new PrintWriter(new OutputStreamWriter(System.out));
            solve();
            in.close();
            out.close();
        } catch (Throwable e) {
            e.printStackTrace();
            exit(0);
        }
    }

    static BufferedReader in;
    static PrintWriter out;
    static StringTokenizer tok;

}
