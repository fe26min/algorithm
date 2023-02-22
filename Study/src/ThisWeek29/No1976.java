package ThisWeek29;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class No1976 {
	static int N, M;
	static int[] arr, base;
	static LinkedList<Integer> list = new LinkedList<>();

	public static void main(String[] args) throws IOException {
		input();
		pro();
	}

	private static void pro() {
		int b = base[list.get(0)];

		for (int i : list) {
			if (b != base[i]) {
				System.out.println("NO");
				return;
			}
		}
		System.out.println("YES");
		return;
	}

	private static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());

		list = new LinkedList<>();

		base = new int[N + 1];

		for (int i = 1; i <= N; i++) {
			base[i] = i;
		}

		for (int i = 1; i <= N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= N; j++) {
				int num = Integer.parseInt(st.nextToken());
				if (num == 1) {
					union(i, j);
				}
			}
		}
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < M; i++) {
			list.add(Integer.parseInt(st.nextToken()));
		}

		br.close();
	}

	public static void union(int x, int y) {
		x = findBase(x);
		y = findBase(y);

		if (x != y) {
			if (x < y) {
				base[y] = x;
			} else {
				base[x] = y;
			}
		}
	}

	private static int findBase(int num) {
		if (base[num] == num)
			return num;
		return base[num] = findBase(base[num]);
	}
}
