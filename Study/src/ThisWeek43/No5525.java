package ThisWeek43;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class No5525 {
	static int N, M ;
	static char[] S;
	public static void main(String[] args) throws IOException {
		input();
		pro();
	}
	private static void pro() {
		int ans = 0;
		int cnt = 0;
		
		for(int i=1; i<M-1; i++) {
			if(S[i-1] =='I' && S[i] == 'O' && S[i+1] =='I') {
				cnt++;
				
				if(cnt == N) {
					cnt--;
					ans++;
				}
				i++;
			}
			else {
				cnt = 0;
			}
		}
		System.out.println(ans);
	}
	private static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		S = br.readLine().toCharArray();
		br.close();		
	}
}
