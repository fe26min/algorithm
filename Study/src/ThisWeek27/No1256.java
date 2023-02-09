package ThisWeek27;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No1256 {
	static int N, M;
	static double K;
	static double[][] dp;
	static StringBuilder sb;
	public static void main(String[] args) throws IOException {
		input();
		pro();
	}
	
	private static void pro() {
		dp = new double[101][101];
		sb = new StringBuilder();
		
		if(check(N, M) < K) {
			System.out.println(-1);
			return;
		}
		else {
			makeS(N,M,K);
			System.out.println(sb);
		}
	}
	
	private static void makeS(int a, int z, double k) {
		if(a==0) {
			for(int i=0; i<z; i++) 
				sb.append("z");
			return;
		}
		if(z==0) {
			for(int i=0; i<a; i++)
				sb.append("a");
			return;
		}
		
		double check = check(a-1, z);
		if(k>check) {
			sb.append("z");
			makeS(a, z-1, k-check);
		}
		else {
			sb.append("a");
			makeS(a-1, z, k);
		}
	}

	private static double check(int a, int z) {
		if(a == 0 || z == 0) return 1;
		if(dp[a][z]!=0) return dp[a][z];
		
		return dp[a][z] = Double.min(check(a-1, z)+ check(a,z-1), 1000000001);
	}

	private static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Double.parseDouble(st.nextToken());
		br.close();
	}
}
