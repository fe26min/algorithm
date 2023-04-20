package Math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No1016 {
	static long min, max;
	static boolean[] isSquare;
	public static void main(String[] args) throws IOException {
		input();
		pro();
	}
	private static void pro() {
		isSquare = new boolean[(int)(max - min + 1)];
		int sqrt = (int) Math.sqrt(max);
		for(long i=2; i<=sqrt; i++){
			long sequence = i * i;
			
			//몫
			long start = min % sequence == 0 ? min/sequence : (min / sequence) + 1;
			// 몫을 증가시키면서 제곱수 구해주기
			for(long j=start; j*sequence <= max; j++) {
				isSquare[(int) (j * sequence - min)] = true;
			}
		}
		int count = 0;
		for(int i=0; i<max - min + 1; i++) {
			if(!isSquare[i])
				count++;
		}
		System.out.println(count);
	}
	private static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		min = Long.parseLong(st.nextToken());
		max = Long.parseLong(st.nextToken());
		br.close();
	}
}