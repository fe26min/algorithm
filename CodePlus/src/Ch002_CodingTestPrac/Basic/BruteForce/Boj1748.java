package Ch002_CodingTestPrac.Basic.BruteForce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj1748 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		int sum = 0;
		
		int n = 1;
		int num = 10;
		
		for(int i=1; i<=N; i++) {
			if(i %num == 0) {
				n++;
				num *= 10;
			}
			sum += n;
		}
		System.out.println(sum);
		
		br.close();
	}
}
