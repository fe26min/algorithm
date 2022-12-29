package implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No16935 {
	static int N, M, R;
	static int[] cmds;
	static int[][] mat;
	
	public static void main(String[] args) throws IOException {
		input();
		for(int cmd : cmds)
			pro(cmd);
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				System.out.print(mat[i][j] + " ");
			}System.out.println();
		}
	}

	private static void pro(int cmd) {
		int[][] temp = new int[N][M];
		int tn = M;
		int tm = N;
		
		switch(cmd) {
		case 1 :
			for(int i=0; i<N; i++) {
				for(int j=0; j<M; j++) {
					temp[i][j] = mat[N-1-i][j];
				}
			}
			break;
		case 2 :
			for(int i=0; i<N; i++) {
				for(int j=0; j<M; j++) {
					temp[i][j] = mat[i][M-1-j];
				}
			}
			break;
		case 3 :
			temp = new int[tn][tm];
			for(int i=0; i<tn; i++) {
				for(int j=0; j<tm; j++) {
					temp[i][j] = mat[N-1-j][i];
				}
			}
			N = tn;
			M = tm;
			break;
		case 4 :
			temp = new int[tn][tm];
			for(int i=0; i<tn; i++) {
				for(int j=0; j<tm; j++) {
					temp[i][j] = mat[j][M-1-i];
				}
			}
			N = tn;
			M = tm;
			break;
		case 5 :
			for(int i=0; i<N; i++) {
				temp[i] = mat[i].clone();
			}
			// 1영역
			for(int i=0; i<N/2; i++) {
				for(int j=0; j<M/2; j++) {
					temp[i][j] = mat[i + N/2][j];
				}					
			}
			// 2영역
			for(int i=0; i<N/2; i++) {
				for(int j=M/2; j<M; j++) {
					temp[i][j] = mat[i][j - M/2];
				}
			}
			// 3영역
			for(int i=N/2; i<N; i++) {
				for(int j=M/2; j<M; j++) {
					temp[i][j] = mat[i - N/2][j];
				}
			}
			// 4영역
			for(int i=N/2; i<N; i++) {
				for(int j=0; j<M/2; j++) {
					temp[i][j] = mat[i][j + M/2];
				}
			}
			break;
		case 6 :
			for(int i=0; i<N; i++) {
				temp[i] = mat[i].clone();
			}
			// 1영역
			for(int i=0; i<N/2; i++) {
				for(int j=0; j<M/2; j++) {
					temp[i][j] = mat[i][j + M/2];
				}					
			}
			// 2영역
			for(int i=0; i<N/2; i++) {
				for(int j=M/2; j<M; j++) {
					temp[i][j] = mat[i + N/2][j];
				}
			}
			// 3영역
			for(int i=N/2; i<N; i++) {
				for(int j=M/2; j<M; j++) {
					temp[i][j] = mat[i][j - M/2];
				}
			}
			// 4영역
			for(int i=N/2; i<N; i++) {
				for(int j=0; j<M/2; j++) {
					temp[i][j] = mat[i - N/2][j];
				}
			}
			break;
		}
		mat = temp;
	}

	private static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());

		mat = new int[N][M];
		cmds = new int[R];
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++) {
				mat[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		st = new StringTokenizer(br.readLine());
		
		for(int i=0; i<R; i++) {
			cmds[i] = Integer.parseInt(st.nextToken());
		}
		br.close();
	}
}
