package ThisWeek42;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class No1038 {
	static int N, ans;
	static boolean find;
	static ArrayList<Long> list;
	public static void main(String[] args) throws IOException {
		input();
		pro();
	}
	private static void pro() {
		if(N <= 10) {
			System.out.println(N);
			return;
		}
		if(N > 1022) {
			System.out.println(-1);
			return;
		}
		list = new ArrayList<>();
		
		for(int i=0; i<10; i++) {
			bp(i,1);
		}
		Collections.sort(list);
		System.out.println(list.get(N));
	}
	private static void bp(long num, int idx) {
		if(idx > 10) return;
		list.add(num);
		for(int i=0; i<num % 10; i++) {
			bp((num * 10) + i, idx+1);
		}
	}
	private static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		br.close();
	}
}
