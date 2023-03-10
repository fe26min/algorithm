package Ch002_CodingTestPrac.Basic.BruteForce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.TreeSet;

public class Boj2309 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int sum = 0;
		TreeSet<Integer> ts = new TreeSet<>();
		
		for(int i=0; i<9; i++) {
			int num = Integer.parseInt(br.readLine());
			sum += num;
			ts.add(num);
		}
		
		boolean[] isNot = new boolean[101];
		
		for(int i: ts) {
			if(ts.contains(sum - 100 - i)) {
				isNot[i] = true;
				isNot[sum-100-i] = true;
				break;
			}
		}
		
		for(int i : ts) {
			if(isNot[i])
				continue;
			System.out.println(i);
		}
		
		br.close();
	}
}