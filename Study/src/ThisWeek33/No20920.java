package ThisWeek33;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class No20920 {
	static HashMap<String, Integer> wordCnt;
	public static void main(String[] args) throws IOException {
		input();
		pro();
	}
	private static void pro() {
		PriorityQueue<String> pq = new PriorityQueue<>(new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				if(wordCnt.get(o1) == wordCnt.get(o2)) {
					if(o1.length() == o2.length()) {
						return o1.compareTo(o2);
					}
					return o2.length() - o1.length();
				}
				return wordCnt.get(o2) - wordCnt.get(o1);
			}
		});
		
		for(String word : wordCnt.keySet()) {
			pq.add(word);
		}
		
		StringBuilder sb = new StringBuilder();
		while(!pq.isEmpty()) {
			sb.append(pq.poll()+"\n");
		}
		System.out.println(sb);
	}
	private static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		wordCnt = new HashMap<>();
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		for(int i=0; i<N; i++) {
			String word = br.readLine();
			if(word.length() < M)
				continue;
			wordCnt.put(word, wordCnt.getOrDefault(word, 0) + 1);
		}
		br.close();
	}
}
