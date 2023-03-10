package Ch001_CodingTestPrac.Basic.Math;

import java.util.Scanner;

public class Boj4375 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		while(sc.hasNext()) {
			int N = sc.nextInt();
			int num = 0;
			int idx = 1;
			while(true) {
				num = num * 10 + 1;
				num %= N;
				if(num == 0) {
					System.out.println(idx);
					break;
				}
				idx++;
			}
		}
	}
}
