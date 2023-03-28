package ThisWeek33;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class No1474 {
	static int N, M, len;
	static String[] words;
	public static void main(String[] args) throws IOException {
		input();
		pro();
	}
	private static void pro() {
		StringBuilder sb = new StringBuilder();
		
		M -= len;
		int cnt = M/(N-1);
		
		int[] dash = new int[N];
		
		Arrays.fill(dash, cnt);
		
		cnt = M - cnt*(N-1);
		boolean[] v = new boolean[N];
		
		for(int i=1; i<N; i++) {
			if(cnt == 0) break;
			if(words[i].charAt(0) >='a' && words[i].charAt(0) <= 'z') {
				v[i] = true;
				dash[i]++;
				cnt--;
			}
		}
		for(int i=N-1; i>0; i--) {
			if(cnt == 0)break;
			if(v[i]) continue;
			dash[i]++;
			cnt--;
		}
		for(int i=0; i<N; i++) {
			if(i != 0) {
				for(int k=0; k<dash[i]; k++) {
					sb.append("_");
				}
			}
			sb.append(words[i]);
		}
		
		System.out.println(sb.toString());
	}
	private static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		words = new String[N];
		len = 0;
		for(int i=0; i<N; i++) {
			words[i] = br.readLine();
			len += words[i].length();
		}
		br.close();
	}
}
