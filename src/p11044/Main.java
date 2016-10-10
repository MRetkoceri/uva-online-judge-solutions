package p11044;

import java.util.Scanner;

/**
 * Created by Muhamed on 7/6/2016.
 */
public class Main {
    public static void main(String[]arg){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            int n,m;
            sc.nextLine();
            n = sc.nextInt();
            m = sc.nextInt();
            System.out.println((n/3)*(m/3));
        }
    }
}
