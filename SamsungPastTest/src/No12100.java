import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No12100 {
	
	static int N, max;
	static int[][] mat;

	public static void main(String[] args) throws IOException {
		input();
		pro();
	}

	private static void pro() {
		max = 0;
		dfs(0);
		System.out.println(max);
	}

	private static void dfs(int depth) {
		if(depth==5) {
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					max = Math.max(max, mat[i][j]);
				}
			}
			return;
		}
		int[][] imsi = new int[N][N];
		
		for(int i=0; i<N; i++) {
			imsi[i] = mat[i].clone();
		}

//		for(int i=0; i<N; i++) {
//			for(int j=0; j<N; j++) {
//				System.out.print(mat[i][j] + " ");
//			}System.out.println();
//		}
//		System.out.println();
//		move(2);
//		for(int i=0; i<N; i++) {
//			for(int j=0; j<N; j++) {
//				System.out.print(mat[i][j] + " ");
//			}System.out.println();
//		}
//		System.out.println();
		for(int di=0; di<4; di++) {
			move(di);
			dfs(depth+1);
			for(int i=0; i<N; i++) {
				mat[i] = imsi[i].clone();
			}
		}

	}

	private static void move(int dir) {
		switch(dir) {
		// 위로 다 올리기
		case 0 :
			for(int i=0; i<N; i++) {
				// 연속된 0이 시작된 곳을 가르키고 있다.
				int idx = 0;
				// idx가 지나오면서 가장 최근에 만난 수
				// 만약 num=0 이라면 합칠 수가 없는 것
				int num = 0;
				for(int j=0; j<N; j++) {
					// mat[j][i]가 0이라면 아무것도 하지 않는다.
					if(mat[j][i]==0) continue;
					
					// 합치기
					if(mat[j][i]==num) {
						// idx는 연속된 0이 시작된 곳인다. 그 전에 거에 num이 들어있다.
						mat[idx-1][i] = 2 * num;
						// mat[j][i]는 이제 비워준다.
						mat[j][i] = 0;
						
						// idx는 변하지 않는다.
						// 이제 합칠 수가 없기 때문에 num = 0;
						num = 0;
					}
					// 0이 아니고 num과 같은 수가 아니라면
					// 이제 idx와 num을 갱신 해준다.
					else {
						// 0의 위치로 옮겨준다.
						num = mat[j][i];
						mat[j][i] = 0;
						mat[idx][i] = num;
						idx++;
					}
				}
			}
			break;
		// 왼쪽으로 몰기
		case 1 :
			for(int i=0; i<N; i++) {
				int idx = 0;
				int num = 0;
				for(int j=0; j<N; j++) {
					if(mat[i][j]==0) continue;
					if(mat[i][j]==num) {
						mat[i][idx-1] = num * 2;
						mat[i][j]= 0;
						num = 0;
					}
					else {
						num = mat[i][j];
						mat[i][j] = 0;
						mat[i][idx] = num;
						idx++;
					}
				}
			}
			
			
			break;
		// 아래로 몰기
		case 2 :
			for(int i=0; i<N; i++) {
				int idx=N-1;
				int num=0;
				for(int j=N-1; j>=0; j--) {
					if(mat[j][i] == 0) continue;
					if(mat[j][i]==num) {
						mat[idx + 1][i] = 2 * num;
						mat[j][i] = 0;
						num = 0;
					}
					else {
						num = mat[j][i];
						mat[j][i]= 0;
						mat[idx][i] = num;
						idx--;
					}
				}
			}
			break;
			
		// 오른쪽 몰기
		case 3:
			for(int i=0; i<N; i++) {
				int idx = N-1;
				int num=0;
				
				for(int j=N-1; j>=0; j--) {
					if(mat[i][j] == 0) continue;
					if(mat[i][j]==num) {
						mat[i][idx+1] = 2 * num;
						mat[i][j] = 0;
						num = 0;
					}
					else {
						num = mat[i][j];
						mat[i][j] = 0;
						mat[i][idx] = num;
						idx--;
					}
				}
			}
			break;
		}
		
		
	}

	private static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		mat = new int[N][N];
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				mat[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		br.close();
	}
}
