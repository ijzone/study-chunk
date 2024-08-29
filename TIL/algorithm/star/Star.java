package star;

import java.util.Scanner;

public class Star {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int starNum = 0;

		System.out.printf("%s%n", "Enter 1 for increase or 2 for decrease or 3 for both:");
		int flag = scan.nextInt();

		if (flag == 1) {
			System.out.printf("%s%n", "Enter number of stars(increse):");
			starNum = scan.nextInt();
			increaseStar(starNum);
		} else if (flag == 2) {
			System.out.printf("%s%n", "Enter number of stars(decrese):");
			starNum = scan.nextInt();
			decreaseStar(starNum);
		} else if (flag == 3) {
			System.out.printf("%s%n", "Enter number of stars(both):");
			starNum = scan.nextInt();
			increaseStar(starNum);
			decreaseStar(starNum - 1);
		}
	}

	public static void increaseStar(int starNum) {
		for (int idx1 = 0; idx1 < starNum; idx1++) {
			for (int idx2 = 0; idx2 <= idx1; idx2++) {
				System.out.printf("%c", '☆');
			}
			System.out.println();
		}
	}

	public static void decreaseStar(int starNum) {
		for (int idx1 = starNum; idx1 > 0; idx1--) {
			for (int idx2 = 0; idx2 < idx1; idx2++) {
				System.out.printf("%c", '☆');
			}
			System.out.println();
		}
	}
}
