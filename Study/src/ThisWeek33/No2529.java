package ThisWeek33;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No2529 {
	static int k;
	static int[] nums;
	static boolean[] visit;
	static char[] signs;
	static String min, max;
	public static void main(String[] args) throws IOException {
		input();
		pro();
	}
	private static void pro() {
		min = "";
		max = "";
		for(int i=0; i<10; i++) {
			visit[i] = true;
			nums[0] = i;
			dfs(1);
			visit[i] = false;
		}
		System.out.println(max);
		System.out.println(min);
	}
	private static void dfs(int depth) {
		if(depth == k+1) {
			max = "";
			for(int i=0; i<=k; i++) {
				max += nums[i];
			}
			if(min.length()==0) {
				for(int i=0; i<=k; i++)
					min += nums[i];
			}
			return;
		}
		
		for(int i=0; i<10; i++) {
			if(visit[i])
				continue;
			if(signs[depth-1] == '<') {
				if(nums[depth-1] > i)
					continue;
			}
			else {
				if(nums[depth-1] < i)
					continue;
			}
			visit[i] = true;
			nums[depth] = i;
			dfs(depth + 1);
			visit[i] = false;
		}
	}
	private static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		k= Integer.parseInt(br.readLine());
		nums = new int[k+1];
		signs = new char[k];
		visit = new boolean[10];
		
		String line = br.readLine();
		for(int i=0; i<k; i++)
			signs[i] = line.charAt(i*2);
		br.close();
	}
}
