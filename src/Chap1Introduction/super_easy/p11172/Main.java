package Chap1Introduction.super_easy.p11172;

import java.util.Scanner;
public class Main {
    public static void main(String []arg){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            sc.nextLine();
            int a = sc.nextInt();
            int b = sc.nextInt();
            if(a<b)
                System.out.println("<");
            else if(a>b)
                System.out.println(">");
            else
                System.out.println("=");
        }
    }
}
