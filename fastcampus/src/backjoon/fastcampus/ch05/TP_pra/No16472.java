package backjoon.fastcampus.ch05.TP_pra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No16472 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// 알파벳 숫자들을 저장하는 곳
		int arr[] = new int[26];
		
		int N = Integer.parseInt(br.readLine());
		
		char string[] = br.readLine().toCharArray();
		int max = 0;
		
		int count = 0;
		for(int s=0, e=-1; s<string.length; s++) {
			while(e+1 < string.length && count<= N) {
				if(arr[string[e+1] - 'a'] == 0)
					count++;
				arr[string[e+1] - 'a']++;
				e++;
				if(count <= N) {
					max = Math.max(max, e - s + 1);
				}
			}
			
			arr[string[s] - 'a']--;
			if(arr[string[s] -'a'] == 0)
				count--;
		}
		System.out.println(max);
		
		br.close();
	}
}
