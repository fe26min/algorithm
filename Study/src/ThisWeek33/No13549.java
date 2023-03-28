package ThisWeek33;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class No13549 {
	static int N, K;
	public static void main(String[] args) throws IOException {
		input();
		pro();
	}
	private static void pro() {
		int[] dist = new int[200_001];
		Arrays.fill(dist, 200_001);
		
		PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparing(o->o[1]));
		pq.add(new int[] {N, 0});
		
		while(!pq.isEmpty()) {
			int[] cur = pq.poll();
			int goal = cur[0];
			int time = cur[1];
			
			if(dist[goal] < time)
				continue;
			dist[goal] = time;
			if(goal == K)
				break;
			if(goal - 1 >= 0 && dist[goal-1] > time+1)
				pq.add(new int[] {goal-1, time + 1});
			
			if(goal + 1 <= 200_000 && dist[goal+1] > time+1)
				pq.add(new int[] {goal+1, time + 1});
			
			if(goal * 2 <= 200_000 && dist[goal * 2] > time+1)
				pq.add(new int[] {goal * 2, time});
		}
		System.out.println(dist[K]);
	}
	private static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		br.close();
	}
}
