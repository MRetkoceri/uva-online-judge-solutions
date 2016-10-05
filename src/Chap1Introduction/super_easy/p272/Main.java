package Chap1Introduction.super_easy.p272; /**
 * Created by Muhamed on 7/2/2016.
 */
import java.util.Scanner;
public class Main {
    public static void main(String[]arg){
        Scanner sc = new Scanner(System.in);
        String line;
        boolean left = true;
        while (sc.hasNextLine()){
            line = sc.nextLine();
            for (int i = 0; i < line.length();i++){
                if(line.charAt(i)=='"'){
                    String rep;
                    if(left) {
                        rep = "``";
                        left = false;
                    }else {
                        rep = "''";
                        left = true;
                    }
                    line = line.substring(0,i)+rep+line.substring(i+1);
                }
            }
            System.out.println(line);
        }
    }
}