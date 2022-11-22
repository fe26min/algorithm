package backjoon.fastcampus.ch02.완탐_응용;

import java.util.Scanner;

public class No9663 {
	
	static int N;
	static int arr[][];
	static int isImpos[][];
	static int count;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		arr = new int[N][N];
		isImpos = new int[N][N];
		count = 0;
		dfs(0);
		System.out.println(count);
		sc.close();
	}
	
	private static void dfs(int depth) {
		if(depth == N) {
			count++;
			return;
		}
		for(int i=0; i<N; i++) {
			if(isImpos[depth][i] > 0)continue;
			check(depth, i, 1);
			dfs(depth+1);
			check(depth, i, -1);
		}
	}

	private static void check(int x, int y, int num) {
		isImpos[x][y]+=num;
		
		for(int i=x + 1; i<N; i++) {
			if(y-(i-x)>=0) {
				isImpos[i][y-(i-x)] += num;
			}
			isImpos[i][y]+=num;
			if(y+(i-x)<N) {
				isImpos[i][y+(i-x)] += num;
			}
		}
	}
}
