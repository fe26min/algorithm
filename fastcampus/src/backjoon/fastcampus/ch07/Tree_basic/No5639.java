package backjoon.fastcampus.ch07.Tree_basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
	
public class No5639 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String line = br.readLine();
		int idx = Integer.parseInt(line);
		Node5639 root = new Node5639(idx);
		
		while(true) {
			line = br.readLine();
            if (line == null || line.equals(""))
                break;
			idx = Integer.parseInt(line);
			root.insert(idx);
		}
		
		root.behindSearch();
		
		br.close();
	}
	
}

class Node5639 {
	int idx;
	Node5639 left;
	Node5639 right;
	
	Node5639(int idx){
		this.idx = idx;
	}

	public void behindSearch() {
		if(left != null)
			left.behindSearch();
		if(right != null)
			right.behindSearch();
		System.out.println(this.idx);
	}

	public void insert(int num) {
		if(num < this.idx) {
			if(this.left==null)
				this.left = new Node5639(num);
			else
				this.left.insert(num);
		}
		else {
			if(this.right==null)
				this.right = new Node5639(num);
			else
				this.right.insert(num);
		}
	}
	
}