package ThisWeek31;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class No5052 {
	static BufferedReader br;
	
	static int N;
	static String[] inputs;
	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int ti =0; ti<T; ti++) {
			input();
			pro();
		}
		
		br.close();
	}

	private static void pro() {
		Node5052 root = new Node5052();
		for(int i=0; i<N; i++) {
			Node5052 idx = root;
			
			String num = inputs[i];
			for(int j=0; j<num.length(); j++) {
				if(idx.isEnd) {
					System.out.println("NO");
					return;
				}
					
				if(idx.children[num.charAt(j) - '0'] == null)
					idx.children[num.charAt(j) - '0'] = new Node5052();
				idx = idx.children[num.charAt(j)-'0'];
			}
			
			idx.isEnd = true;
		}
		System.out.println("YES");
		return;
	}

	private static void input() throws IOException {
		N = Integer.parseInt(br.readLine());
		inputs = new String[N];
		
		for(int i=0; i<N; i++) {
			inputs[i] = br.readLine();
		}
		Arrays.sort(inputs, new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				return o1.length() - o2.length();
			}
		});
	}
}

class Node5052 {
	Node5052[] children = new Node5052[10];
	boolean isEnd;
}