package ThisWeek25;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class No1764 {
	static int N, M;
	static HashSet<String> noSee;
	static PriorityQueue<String> answer;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		noSee = new HashSet<>();
		
		for(int i=0; i<N; i++) {
			String input = br.readLine();
			noSee.add(input);
		}
		
		answer = new PriorityQueue<>();
		
		for(int j=0; j<M; j++) {
			String input = br.readLine();
			if(noSee.contains(input)) {
				answer.add(input);
			}
		}
		
		System.out.println(answer.size());
		for(String i : answer) {
			System.out.println(i);
		}
		
		br.close();
	}
}
