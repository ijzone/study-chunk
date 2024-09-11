package codingTest.hackerRank.implementation.numberLineJumps;

import java.io.*;

public class NumberLineJumps {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader(System.getenv("input")));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("output")));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int x1 = Integer.parseInt(firstMultipleInput[0]);
        int v1 = Integer.parseInt(firstMultipleInput[1]);
        int x2 = Integer.parseInt(firstMultipleInput[2]);
        int v2 = Integer.parseInt(firstMultipleInput[3]);

        String result = NumberLineJumps.kangaroo(x1, v1, x2, v2);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }

    /*
     * Complete the 'kangaroo' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts following parameters:
     *  1. INTEGER x1
     *  2. INTEGER v1
     *  3. INTEGER x2
     *  4. INTEGER v2
     */
    public static String kangaroo(int x1, int v1, int x2, int v2) {
        if (v1 < v2) {
            System.out.println("NO");
            return "NO";
        }

        var totalDistance1 = x1 + v1;
        var totalDistance2 = x2 + v2;

        for (int i = 1; i <= 10000; i++) {
            if (totalDistance1 == totalDistance2) {
                System.out.println("YES");
                return "YES";
            }

            totalDistance1 += v1;
            totalDistance2 += v2;
        }

        return "NO";
    }
}