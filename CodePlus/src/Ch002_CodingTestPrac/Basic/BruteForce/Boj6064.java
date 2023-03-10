package Ch002_CodingTestPrac.Basic.BruteForce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj6064 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		for(int ti=0; ti<T; ti++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			int M = Integer.parseInt(st.nextToken());
			int N = Integer.parseInt(st.nextToken());
			int x = Integer.parseInt(st.nextToken()) - 1;
			int y = Integer.parseInt(st.nextToken()) - 1;
			
			int max = M * N / GND(M, N);
			boolean check = false;
			
			for(int i=0; i<max/M; i++) {
				if((M * i + x) % N == y) {
					sb.append(M * i + x + 1).append("\n");
					check = true;
					break;
				}
			}
			if(!check) {
				sb.append(-1).append("\n");
			}
		}
		System.out.println(sb);
		br.close();
	}
	
	private static int GND(int m, int n) {
		int max = Math.max(m, n);
		int min = Math.min(m, n);
		
		while(max % min !=0) {
			max -= min;
			if(max < min) {
				int temp = min;
				min = max;
				max = temp;
			}
		}
		return min;
	}
}
