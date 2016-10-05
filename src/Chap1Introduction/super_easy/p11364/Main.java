package Chap1Introduction.super_easy.p11364;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by Muhamed on 7/7/2016.
 */

// 13 24 37 89
// 7 14 30 39 41 42
public class Main {
    public static void main(String[]arg){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            sc.nextLine();
            int nr = sc.nextInt();
            sc.nextLine();
            int [] arr = new int[nr];
            for (int j = 0; j < nr; j++) {
                arr[j] = sc.nextInt();
            }
            int total = 0;
            Arrays.sort(arr);
            for (int j = 0; j < nr - 1; j++) {
                total+=arr[j+1]-arr[j];
            }
            System.out.println(total*2);
        }
    }
}
