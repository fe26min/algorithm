package ThisWeek40;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No19637 {
	static int N, M;
	static int[] rank, nums;
	static String[] titles;
	
	public static void main(String[] args) throws IOException {
		input();
		pro();
	}

	private static void pro() {
		StringBuilder sb = new StringBuilder();
		for(int num : nums) {
			sb.append(titles[bsearch(num)] + "\n");
		}
		System.out.println(sb.toString());
	}

	private static int bsearch(int num) {
		int s = 0;
		int e = N-1;
		
		int ans = (s + e) / 2;
		while(s<=e) {
			int m = (s + e) / 2;
			
			if(num <= rank[m]) {
				ans = m;
				e = m - 1;
			}else {
				s = m + 1;
			}
		}
		return ans;
	}

	private static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		rank = new int[N];
		titles = new String[N];
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			
			titles[i] = st.nextToken();
			rank[i] = Integer.parseInt(st.nextToken());
		}
		
		nums = new int[M];
		for(int i=0; i<M; i++) {
			nums[i] = Integer.parseInt(br.readLine());
		}
		br.close();		
	}
}
