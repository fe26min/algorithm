package backjoon.answer_note;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class No1495 {
	
	static int N, S, M;
	static int[] arr;
	static int[] di = {-1, 1};
	public static void main(String[] args) throws IOException {
		input();
		pro();
	}
	
	private static void pro() {
		// 값들이 저장 될 곳
		Queue<Integer> queue = new LinkedList<Integer>();
		
		// 맨 처음 큐에는 S를 넣는다. 
		queue.add(S);
		// N번 곡을 쳐야 합니다.
		for(int i=0; i<N; i++) {
			// 이미 칠 수 없는 공연 일 경우 나갑니다.
			if(queue.isEmpty()) break;
			// 이미 고려된 곡인지를 봅니다.
			boolean[] visit = new boolean[M+1];
			
			// 다음에 올 줄입니다.
			Queue<Integer> nextQue = new LinkedList<Integer>();
			
			// 현재 수록된 후보들을 끝까지 돌립니다.
			while(!queue.isEmpty()) {
				
				// 현재 곡
				int cur = queue.poll();
				
				// 빼거나 더해준다.
				for(int j=0; j<2; j++) {
					// arr[i]를 더하거나 빼 준 값이 다음 곡입니다.
					int next = cur + di[j] * arr[i];
					
					// 표현 가능한 곳인지 봅니다.
					if(next<0 || next > M) continue;
					// 이미 큐에 담겨져 있는 곡인지 봅니다.
					if(visit[next]) continue;
					
					// 새로운 큐에 담아 주기
					visit[next] = true;
					nextQue.add(next);
				}
			}
			// 새로운 큐를 현재 큐로 넘겨주기
			queue = nextQue;
		}
		
		// 답이 아닐 경우  -1
		int ans = -1;
		// 큐에 담긴 값들을 보기
		for(int i: queue) {
			// 최댓 값을 넣어준다.
			ans = Math.max(i, ans);
		}
		// 최댓 값을 출력
		System.out.println(ans);
	}

	// 입력
	private static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		arr = new int[N];
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		br.close();
	}
}
