package hackerRank.warmUp.staircase;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Staircase {

    static void staircase(int n) {
        int spaceCount = n - 1;
        int stairCount = n - spaceCount;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < spaceCount; j++) {
                System.out.print(" ");
            }
            for (int k = 0; k < stairCount; k++) {
                System.out.print("#");
            }
            System.out.println();
            spaceCount--;
            stairCount++;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        staircase(n);

        bufferedReader.close();
    }
}
