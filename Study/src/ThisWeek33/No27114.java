package ThisWeek33;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 시간초과
public class No27114 {
	static int K;
	static int[] cost = new int[3];
	static int[] dir = {3, 1, 2};
	
	public static void main(String[] args) throws IOException {
		input();
		pro();
	}
	private static void pro() {
		Queue<int[]> queue = new LinkedList<int[]>();
		queue.add(new int[] {0, K, 0});
		while(!queue.isEmpty()) {
			int[] cur = queue.poll();
			if(cur[0]==0 && cur[1] == 0) {
				System.out.println(cur[2]);
				return;
			}
			for(int di=0; di<3; di++) {
				int ndir = (cur[0] + dir[di]) % 4;
				int nenergy = cur[1] - cost[di];
				
				if(nenergy < 0)
					continue;
				queue.add(new int[] {ndir, nenergy, cur[2] + 1});
			}
		}
		System.out.println(-1);
	}
	private static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		cost[0] = Integer.parseInt(st.nextToken());
		cost[1] = Integer.parseInt(st.nextToken());
		cost[2] = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		br.close();
	}
}
