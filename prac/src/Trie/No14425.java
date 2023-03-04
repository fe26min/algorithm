package Trie;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No14425 {
	static int N, M;
	static Node14425 root;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		root = new Node14425();
		
		while(N-- > 0) {
			String str = br.readLine();
			Node14425 cur = root;
			
			for(int i=0; i<str.length(); i++) {
				char cha = str.charAt(i);
				if(cur.child[cha - 'a'] == null) {
					cur.child[cha - 'a'] = new Node14425();
				}
				cur = cur.child[cha - 'a'];
				
				if(i == str.length() - 1)
					cur.is_last = true;
			}
		}
		int answer = 0;
		while(M-- > 0) {
			String str = br.readLine();
			Node14425 cur = root;
			for(int i=0; i<str.length(); i++) {
				char cha = str.charAt(i);
				
				if(cur.child[cha - 'a'] == null)
					break;
				cur = cur.child[cha - 'a'];
				
				if(i == str.length() - 1 && cur.is_last)
					answer++;
			}
		}
		System.out.println(answer);
		br.close();
	}
}

class Node14425 {
	Node14425[] child = new Node14425[26];
	boolean is_last;
}