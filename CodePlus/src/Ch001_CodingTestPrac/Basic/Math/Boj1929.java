package Ch001_CodingTestPrac.Basic.Math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj1929 {
	static int M, N;
	static boolean[] isPrime;
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		eratos();
		
		StringBuilder sb = new StringBuilder();
		for(int i=M; i<=N; i++) {
			if(isPrime[i])
				sb.append(i+"\n");
		}
		System.out.println(sb);
		br.close();
	}
	private static void eratos() {
		isPrime = new boolean[N + 1];
		boolean[] visit = new boolean[N + 1];
		for(int i=2; i<=N; i++) {
			if(visit[i])
				continue;
			if(!isPrime[i]) {
				isPrime[i] = true;
				for(int j=i; j<=N; j+=i) {
					visit[j] = true;
				}
			}
		}
	}
}
