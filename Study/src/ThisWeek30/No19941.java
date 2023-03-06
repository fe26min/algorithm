package ThisWeek30;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No19941 {
	static int N, K;
	static String line;
	static boolean[] used;
	public static void main(String[] args) throws IOException {
		input();
		pro();
	}
	private static void pro() {
		int cnt = 0;
		used = new boolean[N];
		for(int i=0; i<N; i++) {
			if(line.charAt(i) == 'P') {
				for(int j=i-K; j<=i+K && j < N; j++) {
					if(j<0)
						continue;
					if(line.charAt(j) == 'P')
						continue;
					if(used[j])
						continue;
					used[j] = true;
					cnt++;
					break;
				}
			}
		}
		System.out.println(cnt);
	}
	private static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());		
		K = Integer.parseInt(st.nextToken());
		
		line = br.readLine();
		br.close();
	}
}
