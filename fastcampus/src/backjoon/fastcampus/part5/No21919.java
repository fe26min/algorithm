package backjoon.fastcampus.part5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.StringTokenizer;

public class No21919 {

	public static void main(String[] args) throws IOException {
		boolean[] isPrime = new boolean[1_000_001];
		Arrays.fill(isPrime, true);

		isPrime[0] = false;
		isPrime[1] = false;
        
		for (int i = 2; i*i <= 1_000_000; i++) {
			if (isPrime[i]) {
				for (int j = i * 2; j <= 1_000_000; j += i) {
					isPrime[j] = false;
				}
			}
		}

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine());

		HashSet<Integer> primes = new HashSet<>();

		st = new StringTokenizer(br.readLine());

		for (int i = 0; i < N; i++) {
			int num = Integer.parseInt(st.nextToken());
			if (isPrime[num])
				primes.add(num);
		}

		long ans = 1;
		if (primes.size() == 0)
			ans = -1;

		for (int i : primes) {
			ans *= i;
		}
		System.out.println(ans);
		br.close();
	}
}