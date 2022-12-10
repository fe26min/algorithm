package backjoon.fastcampus.ch08.TopoSort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class No2056 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		
		// 건물 짓는데 드는 시간
		int[] cost = new int[N+1];
		// 이 건물을 짓는데 선행까지 짓고 난 후에 걸리는 시간
		int[] sum = new int[N+1];
		// 선행 건물 갯수
		int[] inCnt = new int[N+1];
		// 연결 리스트
		ArrayList<Integer>[] list = new ArrayList[N+1];
		for(int i=0; i<=N; i++)
			list[i] = new ArrayList<Integer>();
		
		// 최대로 걸리는 건물
		int MAX = 0;
		
		Queue<Integer> queue = new LinkedList<Integer>();
		
		// 입력
		for(int i=1; i<=N; i++) {
			st = new StringTokenizer(br.readLine());
			// 처음은 비용
			cost[i] = Integer.parseInt(st.nextToken());
			// 두번째는 inCnt
			inCnt[i] = Integer.parseInt(st.nextToken());
			// 만약 선행이 없다면 sum = cost
			if(inCnt[i]==0) {
				queue.add(i);
				sum[i] = cost[i];
				MAX = Math.max(sum[i], MAX);
			}
			
			for(int j=0; j<inCnt[i]; j++) {
				// 선행 조건 리스트에 넣기
				int parent = Integer.parseInt(st.nextToken());
				list[parent].add(i);
			}
		}
		
		while(!queue.isEmpty()) {
			int cur = queue.poll();
			for(int child : list[cur]) {
				inCnt[child]--;
				sum[child] = Math.max(sum[child], sum[cur] + cost[child]);
				MAX = Math.max(sum[child], MAX);
				
				if(inCnt[child]==0)
					queue.add(child);
			}
		}
		
		System.out.println(MAX);
		
		br.close();
	}
}
