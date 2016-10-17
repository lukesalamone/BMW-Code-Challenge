import java.util.Collections;
import java.util.ArrayList;
import java.util.Arrays;

public class Student{
	private int id;
	private ArrayList<String> subjects;
	
	public Student(int id){
		this.id = id;
		this.subjects = new ArrayList<>();
	}
	
	public void addSubject(String subject){
		subject = subject.substring(0,1).toUpperCase() + subject.substring(1).toLowerCase();
		if(!subjects.contains(subject)){
			subjects.add(subject);
		}
	}
	
	public String getCourses(){
		Collections.sort(subjects);
		
		// use built-in array printing method
		String courseList = Arrays.toString(subjects.toArray());
		courseList = courseList.replace("[", "").replace("]", "");
		return courseList;
	}
	
	public int id(){
		return this.id;
	}
	
	public int subjectCount(){
		return subjects.size();
	}
}
