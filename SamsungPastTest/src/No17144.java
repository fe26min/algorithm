import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class No17144 {
	static int R, C, T;
	static int[][] mat;
	
	static Queue<int[]> dusts;
	static int acu, acd;

	static int[] dirx = {-1, 0, 1, 0};
	static int[] diry = {0, -1, 0, 1};
	
	public static void main(String[] args) throws IOException {
		input();
		pro();
	}

	private static void pro() {
		
//		show();
		for(int t=0; t<T; t++) {

			// 먼지 찾기
			dusts = new LinkedList<int[]>();			
			for(int i=0; i<R; i++) {
				for(int j=0; j<C; j++) {
					if(mat[i][j] >= 5) {
						dusts.add(new int[] {i, j, mat[i][j]});
						mat[i][j] = 0;
					}
				}
			}
			// 확산
			while(!dusts.isEmpty()) {
				int[] cur = dusts.poll();
				int count = 0;
				for(int di=0; di<4; di++) {
					int nx = cur[0] + dirx[di];
					int ny = cur[1] + diry[di];
					
					if(nx<0||ny<0||nx>=R||ny>=C)
						continue;
					if(mat[nx][ny]==-1)
						continue;
					count++;
					mat[nx][ny] += cur[2] / 5;
				}
				mat[cur[0]][cur[1]] += cur[2] - (cur[2]/5)*count;
			}
			
			// 확산 되었는지 테스트
//			show();
			
			// 작동
			// 윗 부분 작동
			for(int i=acu-1; i>0; i--) {
				mat[i][0] = mat[i-1][0];
			}
			for(int j=0; j<C-1; j++) {
				mat[0][j] = mat[0][j+1];
			}
			for(int i=0; i<acu; i++) {
				mat[i][C-1] = mat[i+1][C-1];
			}
			for(int j=C-1; j>1; j--) {
				mat[acu][j] = mat[acu][j-1];
			}
			mat[acu][1] = 0;
			
			// 아래 부분 작동
			for(int i=acd+1; i<R-1; i++) {
				mat[i][0] = mat[i+1][0];
			}
			for(int j=0; j<C-1; j++) {
				mat[R-1][j] = mat[R-1][j+1];
			}
			for(int i=R-1; i>acd; i--) {
				mat[i][C-1] = mat[i-1][C-1];
			}
			for(int j=C-1; j>1; j--) {
				mat[acd][j] = mat[acd][j-1];
			}
			mat[acd][1] = 0;
//			show();
//			System.out.println();
		}
		int answer = 0;
		for(int i=0; i<R; i++) {
			for(int j=0; j<C; j++) {
				answer += mat[i][j];
			}
		}
		System.out.println(answer + 2);
		
	}
	// 테스트용 : 현재 mat를 출력
	private static void show() {
		for(int i=0; i<R; i++) {
			for(int j=0; j<C; j++) {
				System.out.print(mat[i][j] + " ");
			}System.out.println();
		}System.out.println();
	}

	private static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());
		
		mat = new int[R][C];
		
		for(int i=0; i<R; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<C; j++) {
				mat[i][j] = Integer.parseInt(st.nextToken());
				
				if(mat[i][j]==-1) {
					if(acu==0)
						acu = i;
					else
						acd = i;
				}
			}
		}
		br.close();
	}
}
