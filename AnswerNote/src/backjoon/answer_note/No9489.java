package backjoon.answer_note;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No9489 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		while(true) {
			st = new StringTokenizer(br.readLine());
			
			// n, k 입력 받기
			int n = Integer.parseInt(st.nextToken());
			int k = Integer.parseInt(st.nextToken());
			if(n==0 && k==0) break;
			
			// 배열 입력 받기
			int[] arr = new int[n];
			// 부모 저장
			int[] parent = new int[n];
			// 맨 위의 노트는 -1
			parent[0] = -1;
			st = new StringTokenizer(br.readLine());
			
			// 찾고자 하는 k 위치
			int fidx = -1;
			
			// 배열 입력
			for(int i=0; i<n; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
				if(k==arr[i]) fidx = i;
			}
			
			// 배열의 크기가 1 초과일 경우!
			// 1번째는 0을 가르키고 있다.
			// 입력이 만약 1 2 3 이런 식으로 들어와도 1은 2와 3의 부모가 되어야 한다
			if(n > 1) {
				parent[1] = 0;
			}
			// 부모의 위치 (연속이 아니면 하나씩 이동)
			int pidx = 0;
			
			// 2번째부터 보기
			for(int i=2; i<n; i++) {
				if(arr[i-1] != arr[i] - 1)
					pidx++;
				parent[i] = pidx;
			}
			int count = 0;
			
			// 배열을 돌면서 부모가 다르면서 부모의 부모가 같은 것들을 세줍니다.
			for(int i=0; i<n; i++) {
				if(parent[i]==-1 || parent[parent[i]] == -1) continue;
				if(parent[i]!=parent[fidx] && parent[parent[i]] == parent[parent[fidx]]) count++;
			}
			// sb에 저장
			sb.append(count +"\n");
		}
		// sb 출력
		System.out.println(sb);
		br.close();
	}
}