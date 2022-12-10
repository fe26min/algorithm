package backjoon.fastcampus.ch08.TopoSort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class No14676 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		ArrayList<Integer>[] list = new ArrayList[N + 1];

		int[] inCnt = new int[N + 1];
		int[] needCnt = new int[N + 1];

		int[] building = new int[N + 1];
		boolean[] canBuild = new boolean[N + 1];

		for (int i = 0; i <= N; i++) {
			list[i] = new ArrayList<Integer>();
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int X = Integer.parseInt(st.nextToken());
			int Y = Integer.parseInt(st.nextToken());
			list[X].add(Y);
			inCnt[Y]++;
		}

		for (int i = 1; i <= N; i++) {
			if (inCnt[i] == 0) {
				canBuild[i] = true;
			}
		}

		String answer = "King-God-Emperor";

		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			int cmd = Integer.parseInt(st.nextToken());
			int bnum = Integer.parseInt(st.nextToken());

			if (cmd == 1) {
				if (!canBuild[bnum]) {
					answer = "Lier!";
					break;
				}

				building[bnum]++;

				if (building[bnum] == 1) {
					for (int next : list[bnum]) {
						needCnt[next]++;
						if (needCnt[next] == inCnt[next]) {
							canBuild[next] = true;
						}
					}
				}
			}

			else if (cmd == 2) {
				if (building[bnum] == 0) {
					answer = "Lier!";
					break;
				}
				building[bnum]--;
				if (building[bnum] == 0) {
					for (int next : list[bnum]) {
						needCnt[next]--;
						canBuild[next] = false;
					}
				}
			}
		}

		System.out.println(answer);
		br.close();
	}
}
