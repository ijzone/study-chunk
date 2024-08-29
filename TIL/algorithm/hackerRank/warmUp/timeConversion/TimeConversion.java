package hackerRank.warmUp.timeConversion;

import java.io.*;

public class TimeConversion {

    public static String timeConversion(String s) {
        String halves = s.substring(s.length() - 2);
        if (halves.equals("PM")) {
            int hr = Integer.parseInt(s.substring(0, 2));
            if (!s.substring(0, 2).equals("12")) {
                hr += 12;
            }
            return hr + s.substring(2, s.length()-2);
        }
        if (s.substring(0, 2).equals("12")) {
            return "00" + s.substring(2);
        }
        return s.substring(0, s.length() - 2);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("output")));

        String s = bufferedReader.readLine();

        String result = timeConversion(s);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
