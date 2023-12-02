package dongbinBook.Implemetation;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Impl1 {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N,x,y;
    static String[] commands;
    public void solution() throws Exception {
        N = Integer.parseInt(br.readLine());
        commands = br.readLine().split(" ");
        x = 1;
        y = 1;

        for (String command : commands) {
            switch (command){
                case "L" :
                    if(y > 1){
                        y -= 1;
                    }
                    break;
                case "R" :
                    if(y < N){
                        y += 1;
                    }
                    break;
                case "U" :
                    if(x > 1){
                        x -= 1;
                    }
                    break;
                case "D" :
                    if(x < N){
                        x += 1;
                    }
                    break;
            }
        }
        System.out.println(x + " " + y);
    }

    public static void main
            (String[] args) throws Exception {
        new Impl1().solution();
    }
}
