package ThisWeek27;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No1991 {
	
	static int N;
	static Node1991[] tree;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {
		input();
		pro();
	}
	private static void pro() {
		frontSearch(tree[0]);
		sb.append("\n");
		middleSearch(tree[0]);
		sb.append("\n");
		behindSearch(tree[0]);
		System.out.println(sb);
	}
	private static void frontSearch(Node1991 parent) {
		sb.append((char)('A' + parent.idx));
		if(parent.left != null) {
			frontSearch(parent.left);
		}
		if(parent.right != null) {
			frontSearch(parent.right);
		}
	}
	private static void middleSearch(Node1991 parent) {
		if(parent.left != null)
			middleSearch(parent.left);
		sb.append((char)('A' + parent.idx));
		if(parent.right != null)
			middleSearch(parent.right);
	}
	private static void behindSearch(Node1991 parent) {
		if(parent.left != null)
			behindSearch(parent.left);
		if(parent.right != null)
			behindSearch(parent.right);
		sb.append((char)('A' + parent.idx));
	}
	private static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		tree = new Node1991[N];
		
		for(int i=0; i<N; i++) {
			tree[i] = new Node1991();
			tree[i].idx = i;
		}
		
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int p = st.nextToken().charAt(0) - 'A';
			int l = st.nextToken().charAt(0) - 'A';
			int r = st.nextToken().charAt(0) - 'A';
			
			if(0<=l && l<=26) {
				tree[p].left = tree[l];
				tree[l].parent = tree[p];
			}
			if(0<=r && r<=26) {
				tree[p].right = tree[r];
				tree[r].parent = tree[p];
			}
		}
		br.close();
	}
}

class Node1991 {
	int idx;
	Node1991 parent;
	Node1991 left;
	Node1991 right;
}
