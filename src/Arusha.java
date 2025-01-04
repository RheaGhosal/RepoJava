import java.io.*;
import java.util.*;

public class Arusha {

    //Right Rotation
    public static String rightRotate(String s, int k) {
        int n = s.length();
        k = k % n;
        return s.substring(n - k) + s.substring(0, n - k);
    }

//Left rotation

    public static String leftRotate(String s, int k) {
        int n = s.length();
        k = k % n;
        return s.substring(k) + s.substring(0, k);
    }

    public static void main(String[] args) {
        try {

            File file = new File("arusha.dat");
            Scanner reader = new Scanner(file);

            int T = Integer.parseInt(reader.nextLine());


            for (int t = 0; t < T; t++) {

                String[] input = reader.nextLine().split(" ");
                String s = input[0];
                String instructions = input[1];


                for (int i = 0; i < instructions.length(); i++) {
                    char direction = instructions.charAt(i);
                    int count = Integer.parseInt(String.valueOf(instructions.charAt(i + 1)));
                    i++;

                    if (direction == 'L') {
                        s = leftRotate(s, count);
                    } else if (direction == 'R') {
                        s = rightRotate(s, count);
                    }
                }


                System.out.println(s);
            }


            reader.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}


