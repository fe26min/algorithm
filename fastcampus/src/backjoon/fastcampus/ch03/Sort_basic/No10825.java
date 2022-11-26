package backjoon.fastcampus.ch03.Sort_basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class No10825 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		Student[] students = new Student[N];
		
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			String name = st.nextToken();
			int kor = Integer.parseInt(st.nextToken());
			int eng = Integer.parseInt(st.nextToken());
			int math = Integer.parseInt(st.nextToken());
			
			students[i] = new Student(name, kor, eng, math);
		}
		
		Arrays.sort(students);
		
		for(Student s : students) {
			System.out.println(s.name);
		}
		
		br.close();
	}
}

class Student implements Comparable<Student>{
	String name;
	int kor, eng, math;
	
	public Student(String name, int kor, int eng, int math) {
		this.name = name;
		this.kor = kor;
		this.eng = eng;
		this.math = math;
	}
	
	@Override
	public int compareTo(Student o) {
		if(kor == o.kor) {
			if(eng == o.eng) {
				if(math == o.math) {
					return name.compareTo(o.name);
				}
				return o.math - math;
			}
			return eng - o.eng;
		}
		return o.kor - kor;
	}
}
