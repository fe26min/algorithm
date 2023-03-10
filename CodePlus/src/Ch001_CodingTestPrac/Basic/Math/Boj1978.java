package Ch001_CodingTestPrac.Basic.Math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj1978 {
	static boolean[] isPrime;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		eratos();
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int cnt = 0;
		for(int i=0; i<N; i++) {
			int num = Integer.parseInt(st.nextToken());
			cnt += isPrime[num] ? 1 : 0;
		}
		System.out.println(cnt);
		br.close();
	}

	private static void eratos() {
		isPrime = new boolean[1001];
		boolean[] visit = new boolean[1001];
		for(int i=2; i<1001; i++) {
			if(visit[i])
				continue;
			if(!isPrime[i]) {
				isPrime[i] = true;
				for(int j=i; j<1001; j+=i) {
					visit[j] = true;
				}
			}
		}
	}
}
