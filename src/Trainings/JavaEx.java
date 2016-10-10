package Trainings;

import java.util.*;

/**
 * Created by Muhamed on 23-Sep-16.
 */
public class JavaEx {
    public static void main(String [] arg){

        //System.out.println(Integer.toBinaryString(2));
        //System.out.printf("%3s","a");
        //ex2();
    }
    public static void ex1(){
        Scanner sc = new Scanner(System.in);
        double d = sc.nextDouble();
        System.out.printf("%,7.3f%n",d);
    }
    public static void ex2(){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.printf("%."+n+"f",Math.PI);
    }
}
