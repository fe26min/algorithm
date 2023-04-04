package ThisWeek34;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class No1135 {
	static List<Integer>[] list;
	static int N;
	static int[] dp;
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		input();
		pro();
	}

	private static void pro() {
		dp = new int[N];
		int rt = 0;
		for(int i=0; i<N; i++) {
			list[i] = new ArrayList<>();
			int a = Integer.parseInt(st.nextToken());
			if(a==-1) {
				rt = i;
			} else {
				list[a].add(i);
			}
		}
		int min = find(rt);
		System.out.println(min);
	}

	private static int find(int idx) {
		for (int nxt : list[idx]) {
			dp[nxt] = 1 + find(nxt);
		}
		Collections.sort(list[idx], new DepthComp());
		int res = 0;
		for(int i=0; i<list[idx].size(); i++) {
			int num = list[idx].get(i);
			dp[num] += i;
			res = Math.max(res, dp[num]);
		}
		return res;
	}

	private static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		list = new ArrayList[N];
		st = new StringTokenizer(br.readLine());
		br.close();
	}
	static class DepthComp implements Comparator<Integer> {
		@Override
		public int compare(Integer o1, Integer o2) {
			return dp[o2]-dp[o1];
		}
	}
}

