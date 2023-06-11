package ThisWeek44;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No25180 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		br.close();
		int cnt = 0;
		
		if(N < 10) {
			System.out.println(1);
		}
		else {
			cnt = N / 18 * 2;
			N %= 18;
			if(N==0) {
				
			}
			else if(N<10)
				cnt += 1;
			else if(N % 2 == 1)
				cnt += 3;
			else 
				cnt += 2;
			System.out.println(cnt);
		}
	}
}
