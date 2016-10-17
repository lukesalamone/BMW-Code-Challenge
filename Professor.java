import java.util.ArrayList;

/* Professor.java
 * 
 * Luke Salamone
 * 
 * Professors have name and teach up to 4 subjects
 */

public class Professor{
	private ArrayList<String> subjects;
	private String name;
	
	public Professor(String name){
		this.subjects = new ArrayList<>();
		this.name = name;
	}
	
	public String name(){
		return name;
	}
	
	public void addSubject(String subject){
		subject = subject.toUpperCase();
		if(subjects.contains(subject)){
			return;
		} else {
			subjects.add(subject);
		}
	}
	
	public int sectionCount(){
		return subjects.size();
	}
}
