package ThisWeek38;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class No11000 {
	static int N;
	static int[][] list;
	static PriorityQueue<Integer> pq;
	public static void main(String[] args) throws IOException {
		input();
		pro();
	}
	private static void pro() {
		Arrays.sort(list, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				if(o1[0] == o2[0])
					return o1[1] - o2[1];
				return o1[0] - o2[0];
			}
		});

		int e = 0;
		pq = new PriorityQueue<>();
		pq.add(list[0][1]);
		
		for(int i=1; i<N; i++) {
			if(pq.peek() <= list[i][0]) {
				pq.poll();
			}
			pq.add(list[i][1]);
		}
		System.out.println(pq.size());
	}
	private static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		list = new int[N][2];
		
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			list[i][0] = Integer.parseInt(st.nextToken());
			list[i][1] = Integer.parseInt(st.nextToken());
		}
		br.close();		
	}
}
