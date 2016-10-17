/* Section.java
 *
 * Simple object to keep track of professor-subject pairs
 * 
 * Luke Salamone
 */

public class Section{
	private String professor;
	private String subject;

	public Section(String professor, String subject){
		this.professor = professor;
		this.subject = subject;
	}
	
	public boolean equals(Section section){
		if(this == section){
			return true;
		} else {
			return this.professor.equals(section.professor()) && this.subject.equals(section.subject());
		}
	}
	
	public String professor(){
		return this.professor;
	}
	
	public String subject(){
		return subject;	
	}
}
