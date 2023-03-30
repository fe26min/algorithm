package Math;

import java.io.InputStreamReader;

import java.io.BufferedReader;
import java.io.IOException;

public class No1676 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		int tw = 0, fi = 0;
		int cnt = 0;
		
		for(int i=1; i<=N; i++) {
			int num = i;
			
			while(num > 0) {
				if(num%2==0) {
					tw++;
					num/=2;
				}
				else if(num%5==0) {
					fi++;
					num/=5;
				}
				else
					break;
			}
		}
		cnt = tw < fi ? tw : fi;
		System.out.println(cnt);
	}
}
