package Chap1Introduction.super_easy.p10550;

import java.util.Scanner;

/**
 * Created by Muhamed on 7/3/2016.
 */

public class Main {
    public static void main(String[]arg){
        Scanner sc = new Scanner(System.in);
        String line;
        while(!(line=sc.nextLine()).equals("0 0 0 0")){
            String [] vals = line.split(" ");
            int total = 0;
            total += (40-(Integer.parseInt(vals[1])-Integer.parseInt(vals[0])))%40;
            total += (40-(Integer.parseInt(vals[1])-Integer.parseInt(vals[2])))%40;
            total += (40-(Integer.parseInt(vals[3])-Integer.parseInt(vals[2])))%40;
            total*=9;
            total+=360*3;
            System.out.println(total);
        }
    }
}
