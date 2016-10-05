package Chap2DataStructuresAndLibraries.NonLinearDS;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

/**
 * Created by Muhamed on 8/21/2016.
 */
public class HayPoints {

    public static void main(String []args){

        Scanner in = new Scanner(System.in);

        int nrPos = in.nextInt();
        int nrJobs = in.nextInt();
        in.nextLine();

        Map<String, Integer> map = new TreeMap<String,Integer>();

        while(nrPos-- > 0){
            String [] t = in.nextLine().split("\\s");
            map.put(t[0],Integer.parseInt(t[1]));
        }

        while(nrJobs-- > 0){
            String s = in.nextLine();
            int total = 0;
            while(!s.equals(".")) {

                String [] t = s.split("\\s");
                for(int i = 0; i < t.length; i++){
                    if(map.containsKey(t[i]))
                        total += map.get(t[i]);
                }
                s = in.nextLine();
            }
            System.out.printf("%d\n", total);
        }
    }
}
