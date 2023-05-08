package solve;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No1027 {
	static int N;
	static int[] height, count;
	public static void main(String[] args) throws IOException {
		input();
		pro();
	}
	private static void pro() {
		for(int i=0; i<N-1; i++) {
			count[i]++;
			count[i+1]++;
			
			double incline = height[i+1] - height[i];
			
			for(int j=i+2; j<N; j++) {
				double newIncline = (double)(height[j] - height[i]) / (j-i);
				
				if(newIncline <= incline)
					continue;
				incline = newIncline;
				count[i]++;
				count[j]++;
			}
		}
		int max = 0;
		for(int i : count) {
			max = Math.max(max, i);
		}
		System.out.println(max);
	}
	private static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		height = new int[N];
		count = new int[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			height[i] = Integer.parseInt(st.nextToken());
		}
		br.close();		
	}
}
