package ThisWeek30;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No2134 {
	static int n,m,k;
	static int[] prev, next;
	public static void main(String[] args) throws IOException {
		input();
		pro();
	}
	private static void pro() {	
		int pidx = 0;
		int nidx = 0;
		
		long cnt = 0;
		long ans = 0;
		while(pidx < n && nidx  < m) {
			if(prev[pidx] <= next[nidx]) {
				cnt += prev[pidx];
				ans += (pidx + nidx + 2) * (prev[pidx]);
				next[nidx] -= prev[pidx];
				prev[pidx] = 0;
				pidx++;
			}
			else {
				cnt += next[nidx];
				ans += (pidx + nidx + 2) * (next[nidx]);
				prev[pidx] -= next[nidx];
				next[nidx] = 0;
			}
			if(next[nidx] == 0) {
				nidx++;
			}
		}
		System.out.println(cnt + " " + ans);
	}
	private static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		
		prev = new int[n];
		next = new int[m];
		
		for(int i=0; i<n; i++) {
			prev[i] = Integer.parseInt(br.readLine());
		}
		
		for(int i=0; i<m; i++) {
			next[i] = Integer.parseInt(br.readLine());
		}
		
		br.close();
	}
}
