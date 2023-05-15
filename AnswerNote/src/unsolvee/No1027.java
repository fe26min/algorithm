package unsolvee;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No1027 {
	static int N;
	static int[] height, cnt;
	
	public static void main(String[] args) throws IOException {
		input();
		pro();
	}

	private static void pro() {
		int max = 0;
		cnt = new int[N];
		
		for(int i=0; i<N -1; i++) {
			cnt[i]++;
			cnt[i+1]++;
			double incline = height[i+1] - height[i];
			
			for(int j=i+2; j<N; j++) {
				double nextIncline = (double)(height[j] - height[i]) / (j-i);
				if(nextIncline > incline) {
					cnt[i]++;
					cnt[j]++;
					incline = nextIncline;
				}
			}
		}
//		for(int i=0; i<N; i++) {
//			System.out.print(cnt[i] + " ");
//		}System.out.println();
		
		for(int i=0; i< N; i++)
			max = Math.max(max, cnt[i]);
		System.out.println(max);
	}

	private static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		height = new int[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			height[i] = Integer.parseInt(st.nextToken());
		}
		br.close();
	}
}
