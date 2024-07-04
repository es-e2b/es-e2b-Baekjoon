import java.io.*;
import java.util.*;

public class Main{
	public static class Person{
		String name;
		int kor;
		int eng;
		int math;
	}

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		Person[] person = new Person[n];
		StringTokenizer st;

		for(int i = 0; i < n; i++){
			st = new StringTokenizer(br.readLine(), " ");
			person[i] = new Person();
			person[i].name = st.nextToken();
			person[i].kor = Integer.parseInt(st.nextToken());
			person[i].eng = Integer.parseInt(st.nextToken());
			person[i].math = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(person, new Comparator<Person>(){
			public int compare(Person o1, Person o2){
				if(o1.kor == o2.kor && o1.eng == o2.eng && o1.math == o2.math){
					return o1.name.compareTo(o2.name);
				}
				else if(o1.kor == o2.kor && o1.eng == o2.eng){
					return o2.math - o1.math;
				}
				else if(o1.kor == o2.kor){
					return o1.eng - o2.eng;
				}
				else return o2.kor - o1.kor;
			}
		});
		
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i< n; i++){
			sb.append(person[i].name).append('\n');
		}
		System.out.println(sb);
	}
}