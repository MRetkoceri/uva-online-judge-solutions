package p12686;

import java.io.*;
import java.util.*;
import java.util.Map;
import static java.lang.Double.parseDouble;
import static java.lang.Integer.parseInt;
import static java.lang.Long.parseLong;
import static java.lang.System.exit;

public class Main {

    static String [] queue = new String[7];
    static int pos = 0;
    static void solve() throws Exception {

        String line;
        while ((line = in.readLine()) != null) {
            if(line.length() == 0)
                continue;
            if(line.equals("<text>")){
                String l;
                String text ="";
                while(!(l = in.readLine()).equals("</text>")){
                    text+=" "+l;
                }
                enqueue(text);
            }
            if(line.startsWith("<top")){
                HashMap<String,Integer> map = new HashMap<String,Integer>();
                int n = Integer.parseInt(line.substring(line.indexOf(" ")+1,line.lastIndexOf(" ")));
                for (int i = 0; i < queue.length; i++) {
                    if(queue[i]==null)
                        break;
                    String [] words = queue[i].split(" ");
                    for (int j = 0; j < words.length; j++) {
                        if(words[j].length()<4)
                            continue;
                        else {
                            if (map.containsKey(words[j])) {
                                int val = map.get(words[j]);
                                map.put(words[j], val + 1);
                            } else {
                                map.put(words[j], 1);
                            }
                        }
                    }
                }
                Map.Entry<String,Integer>[] entries = new Map.Entry[map.size()];
                int pos = 0;
                for (Map.Entry<String,Integer> entry:map.entrySet()){
                    entries[pos++] = entry;
                }
                Arrays.sort(entries, new Comparator<Map.Entry<String, Integer>>() {
                    @Override
                    public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                        if(o1.getValue() == o2.getValue()){
                            return o1.getKey().compareTo(o2.getKey());
                        }else{
                            return o2.getValue().compareTo(o1.getValue());
                        }
                    }
                });
                out.printf("<top %d>%n",n);
                int p = n;
                for (int i = 0; i < entries.length; i++) {
                    if(p==0){
                        if(entries[i].getValue() == entries[i-1].getValue()){
                            out.printf("%s %d%n",entries[i].getKey(),entries[i].getValue());
                        }else{
                            break;
                        }
                    }else{
                        out.printf("%s %d%n",entries[i].getKey(),entries[i].getValue());
                        p--;
                    }
                }
                out.println("</top>");
                map.clear();
            }
        }
    }

    static void enqueue(String s){
        queue[pos++%7]=s;
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
            //INPUT = new FileInputStream("1.in");
            //OUTPUT = new FileOutputStream("2.out");
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