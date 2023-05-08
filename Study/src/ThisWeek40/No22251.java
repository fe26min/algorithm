package ThisWeek40;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No22251 {
	static int N, K, P, X, count;
	static int[] binary = new int[] {
			Integer.parseInt("1110111" , 2),
			Integer.parseInt("0010010" , 2),
			Integer.parseInt("1011101" , 2),
			Integer.parseInt("1011011" , 2),
			Integer.parseInt("0111010" , 2),
			Integer.parseInt("1101011" , 2),
			Integer.parseInt("1101111" , 2),
			Integer.parseInt("1010010" , 2),
			Integer.parseInt("1111111" , 2),
			Integer.parseInt("1111011" , 2)
	};
	public static void main(String[] args) throws IOException {
		input();
		pro();
	}
	private static void pro() {
		count = 0;
		dfs(0, 0, X);
		System.out.println(count);
	}
	private static void dfs(int depth, int cnt, int num) {
		if(depth == K) {
			if(num >=1 && num <= N && num != X) {
				count++;
			}
			return;
		}
		
		int idx = 1;
		for(int i=0; i<depth; i++) {
			idx *= 10;
		}
		int n = num / idx % 10;
		
		// depth번째 숫자를 바꾸기
		for(int i=0; i<10; i++) {
			int diff = Integer.bitCount(binary[i] ^ binary[n]);
			if(diff + cnt > P)
				continue;
			dfs(depth + 1, diff + cnt, num + (i - n) * idx);
		}
	}
	private static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		P = Integer.parseInt(st.nextToken());
		X = Integer.parseInt(st.nextToken());
		
		br.close();		
	}
}
