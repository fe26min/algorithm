package Ch001_CodingTestPrac.Basic.Math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//https://codejb.tistory.com/5
public class Boj17425 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		long[] f = new long[1000001];
		long[] g = new long[1000001];
		
		long ans = 0L;
		
		g[1] = 1;
		for(int i=1; i<=1000000; i++) {
			f[i] = 1; 
		}
		
		for(int i=2; i<=1000000; i++) {
			for(int j=1; j*i <= 1000000; j++) {
				f[i * j] += i;
			}
		}
		
		for(int i=1; i<=1000000; i++) {
			g[i] = g[i-1] + f[i];
		}
		
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<N; i++) {
			int num = Integer.parseInt(br.readLine());
			sb.append(g[num] + "\n");
		}
		System.out.print(sb);
		br.close();
	}
}
