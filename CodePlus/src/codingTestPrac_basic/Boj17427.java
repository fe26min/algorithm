package codingTestPrac_basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//https://codejb.tistory.com/4
public class Boj17427 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		long ans = 0L;
		
		for(int i=1; i<=N; i++) {
			ans +=  i * (N/i);
		}
		System.out.println(ans);
		
		br.close();
	}
}