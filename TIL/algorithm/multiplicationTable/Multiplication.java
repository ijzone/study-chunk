package multiplicationTable;

import java.util.ArrayList;
import java.util.Scanner;

public class Multiplication {

	public static void main(String[] args) {
		Multiplication multi = new Multiplication();

		/* 구구단 1-9 */
//		multi.multiplication();
		
		/* 구구단 수 입력 */
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		sc.close();
		ArrayList<Integer> list = multi.inputMultiplication(num);
//		Comparator<Object> comp = Collections.reverseOrder(); //ArrayList reverse order
//		Collections.sort(list, comp); //ArrayList sort
	}
	
	/* 구구단 1-9 */
	void multiplication() {
		for(int idx1=2; idx1 < 10; idx1++) {
			for(int idx2=1; idx2 < 10; idx2++) {
				System.out.println(idx1 + "*" + idx2 + "=" + idx1*idx2);
			}
			System.out.println("");
		};
	}
	
	/* 구구단 수 입력 */
	ArrayList<Integer> inputMultiplication(int input) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		
		for( int idx = 1; idx < 10; idx++ ) {
			System.out.println(input + " * " + idx + " = " + input * idx);
			list.add(input*idx);
//			list.add(0, input*idx);
		};
		
		return list;
	}
	
}
