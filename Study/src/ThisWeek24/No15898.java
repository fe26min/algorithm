package ThisWeek24;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class No15898 {
	static int n, answer;
	
	static int[][] amount;
	static char[][] kind;
	static int[][][] ingrAmo;
	static char[][][] ingrKind;
	static boolean[] visit;
	
	public static void main(String[] args) throws IOException {
		input();
		pro();
//		test();
//		testCase();
	}

	private static void testCase() {
		for(int i=0; i<5; i++) {
			for(int j=0; j<5; j++) {
				System.out.print(amount[i][j] + "" + kind[i][j] + " ");
			}System.out.println();
		}System.out.println();
		put(1, 1, 1, 3);
		for(int i=0; i<5; i++) {
			for(int j=0; j<5; j++) {
				System.out.print(amount[i][j] + "" + kind[i][j] + " ");
			}System.out.println();
		}System.out.println();
	}

	private static void test() {
		for(int i=0; i<5; i++) {
			for(int j=0; j<5; j++) {
				System.out.print(amount[i][j] + "" + kind[i][j] + " ");
			}System.out.println();
		}System.out.println();
		
		for(int i=0; i<4; i++) {
			for(int j=0; j<4; j++) {
				System.out.print(ingrAmo[0][i][j] + "" + ingrKind[0][i][j] + " ");
			}System.out.println();
		}System.out.println();
		
		put(0, 0, 0, 3);
		
//		for(int i=0; i<5; i++) {
//			for(int j=0; j<5; j++) {
//				System.out.print(amount[i][j] + "" + kind[i][j] + " ");
//			}System.out.println();
//		}System.out.println();
	}

	private static void pro() {
		answer = Integer.MIN_VALUE;
		dfs(0);
		System.out.println(answer);
	}

	private static void dfs(int depth) {
		if(depth == 3) {
			check();
			return;
		}
		
		int[][] imsiAmo = new int[5][5];
		char[][] imsiKind = new char[5][5];
		
		for(int i=0; i<5; i++) {
			imsiAmo[i] = amount[i].clone();
			imsiKind[i] = kind[i].clone();
		}
		
		for(int idx=0; idx<n; idx++) {
			if(visit[idx])
				continue;
			visit[idx] = true;
			
			for(int i=0; i<2; i++) {
				for(int j=0; j<2; j++) {
					for(int dir=0; dir<4; dir++) {
//						System.out.println(depth + " " + idx + " " + dir);
						put(idx, i, j, dir);
						dfs(depth + 1);
						for(int a=0; a<5; a++) {
							amount[a] = imsiAmo[a].clone();
							kind[a] = imsiKind[a].clone();
						}
					}
				}
			}
			visit[idx] = false;
		}
	}

	private static void put(int idx, int r, int c, int dir) {
		for(int i=0; i<4; i++) {
			for(int j=0; j<4; j++) {
				switch(dir) {
				case 0:
					amount[i+r][j+c] += ingrAmo[idx][i][j];
					if(amount[i+r][j+c] < 0)
						amount[i+r][j+c] = 0;
					else if(amount[i+r][j+c] > 9)
						amount[i+r][j+c] = 9;
					if(ingrKind[idx][i][j]=='W')
						continue;
					kind[i+r][j+c] = ingrKind[idx][i][j];
					break;
				case 1:
					amount[i+r][j+c] += ingrAmo[idx][3-j][i];
					if(amount[i+r][j+c] < 0)
						amount[i+r][j+c] = 0;
					else if(amount[i+r][j+c] > 9)
						amount[i+r][j+c] = 9;
					if(ingrKind[idx][3-j][i]=='W')
						continue;
					kind[i+r][j+c] = ingrKind[idx][3-j][i];
					break;
					
				case 2:
					amount[i+r][j+c] += ingrAmo[idx][3-i][3-j];
					if(amount[i+r][j+c] < 0)
						amount[i+r][j+c] = 0;
					else if(amount[i+r][j+c] > 9)
						amount[i+r][j+c] = 9;
					if(ingrKind[idx][3-i][3-j]=='W')
						continue;
					kind[i+r][j+c] = ingrKind[idx][3-i][3-j];
					break;
					
				case 3:
					amount[i+r][j+c] += ingrAmo[idx][j][3-i];
					if(amount[i+r][j+c] < 0)
						amount[i+r][j+c] = 0;
					else if(amount[i+r][j+c] > 9)
						amount[i+r][j+c] = 9;
					if(ingrKind[idx][j][3-i]=='W')
						continue;
					kind[i+r][j+c] = ingrKind[idx][j][3-i];
					break;
				}
			}
		}
	}

	private static void check() {
		int score = 0;
		
		for(int i=0; i<5; i++) {
			for(int j=0; j<5; j++) {
				int s = 0;
				if(kind[i][j]=='R')
					s = 7;
				else if(kind[i][j]=='B')
					s = 5;
				else if(kind[i][j]=='G')
					s = 3;
				else if(kind[i][j]=='Y')
					s = 2;
				score += s * amount[i][j];
			}
		}
//		System.out.println(score);
//		for(int i=0; i<5; i++) {
//			for(int j=0; j<5; j++) {
//				System.out.print(amount[i][j] + "" + kind[i][j] + " ");
//			}System.out.println();
//		}System.out.println();
		answer = Math.max(answer, score);
	}

	private static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		n = Integer.parseInt(br.readLine());
		
		amount = new int[5][5];
		kind = new char[5][5];
		
		ingrAmo = new int[n][4][4];
		ingrKind = new char[n][4][4];
		
		visit = new boolean[n];
		
		for(int i=0; i<5; i++) {
			Arrays.fill(kind[i], 'W');
		}
		
		for(int idx = 0; idx<n; idx++) {
			for(int i=0; i<4; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0; j<4; j++) {
					ingrAmo[idx][i][j] = Integer.parseInt(st.nextToken());
				}
			}
			for(int i=0; i<4; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0; j<4; j++) {
					ingrKind[idx][i][j] = st.nextToken().charAt(0);
				}
			}
		}
		br.close();
	}
}