package ThisWeek40;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class No1545 {
	static char[] P;
	public static void main(String[] args) throws IOException {
		input();
		pro();
	}

	private static void pro() {
		Arrays.sort(P);
		int N = P.length;
		for(int idx = N/2 + N%2; idx<N; idx++) {
			if(P[N - idx - 1] == P[idx]) {
				int i = idx + 1;
				while(i < N && P[i] == P[idx]) {
					i++;
				}
				if(i == N) {
					System.out.println(-1);
					return;
				}
				char temp = P[idx];
				P[idx] = P[i];
				P[i] = temp;
			}
		}
		for(char c : P) {
			System.out.print(c);
		}System.out.println();
	}

	private static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		P = br.readLine().toCharArray();
		br.close();
	}
}
