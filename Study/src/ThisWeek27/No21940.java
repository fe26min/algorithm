package ThisWeek27;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class No21940 {
	// 플로이드 워샬 문제
	// 플로이드 워샬로 최소 왕복 도시들을 구한다.
	// 최소가 되는 도시들을 뽑는다.
	
	
	static int N, K;
	static int[] friends;
	static int[][] mat;
	
	public static void main(String[] args) throws IOException {
		input();
		pro();
	}

	private static void pro() {
		for(int k=0; k<N; k++) {
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					if(mat[i][j] > mat[i][k] + mat[k][j]) {
						mat[i][j] = mat[i][k] + mat[k][j];
					}
				}
			}
		}
		
		int[] max = new int[N];
		int min = Integer.MAX_VALUE;
		for(int i=0; i<N; i++) {
			for(int j=0; j<K; j++) {
				max[i] = Math.max(max[i], mat[friends[j]][i] + mat[i][friends[j]]);
			}
			min = Math.min(min, max[i]);
		}
		ArrayList<Integer> ansList = new ArrayList<>();
		for(int i=0; i<N; i++) {
			if(min >= max[i]) ansList.add(i + 1);
		}
		Collections.sort(ansList);
		
		for(int ans : ansList) {
			System.out.print(ans + " ");
		}
	}

	private static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		// 최단거리를 기록하는 배열
		mat = new int[N][N];
		
		// 최댓값으로 초기화
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {	
				mat[i][j] = Integer.MAX_VALUE;
			}
			mat[i][i] = 0;
		}
		
		while(M-->0) {
			st = new StringTokenizer(br.readLine());

			int A = Integer.parseInt(st.nextToken()) - 1;
			int B = Integer.parseInt(st.nextToken()) - 1;
			int T = Integer.parseInt(st.nextToken());
			
			mat[A][B] = Math.min(mat[A][B], T);
		}
		
		
		K = Integer.parseInt(br.readLine());

		// 친구들 목록
		friends = new int[K];
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<K; i++) {
			friends[i] = Integer.parseInt(st.nextToken()) - 1;
		}
		
		br.close();
	}
}
