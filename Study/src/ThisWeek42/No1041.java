package ThisWeek42;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class No1041 {
	static int N;
	static int[] dice;
	public static void main(String[] args) throws IOException {
		input();
		pro();
	}
	private static void pro() {
		if(N==1) {
			Arrays.sort(dice);
			int sum = 0;
			for(int i=0; i<5; i++) {
				sum += dice[i];
			}
			System.out.println(sum);
			return;
		}
		
		long[] num = new long[4];
		num[1] = 5L * (N - 2) * (N - 2) + 4L * (N - 2);
		num[2] = 8L * (N - 2) + 4L;
		num[3] = 4L;
		
		long ans = 0;
		
		long min = dice[0];
		for (int i = 1; i < 6; i++) {
			min = Math.min(min, dice[i]);
		}
		ans += (long)num[1] * min;

		min = Long.MAX_VALUE;
		for (int i = 0; i < 6; i++) {
			for (int j = i + 1; j < 6; j++) {
				if (j + i != 5) {
					min = Math.min(min, dice[i] + dice[j]);
				}
			}
		}
		ans += num[2] * min;

		long sum = 0;
		for (int i = 0; i < 3; i++) {
			sum += Math.min(dice[i], dice[5 - i]);
		}
		ans += num[3] * sum;
		
		System.out.println(ans);
	}
	private static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		dice = new int[6];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<6; i++)
			dice[i] = Integer.parseInt(st.nextToken());
		br.close();		
	}
}
