import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

/* Challenge.java
 * 
 * 29 September, 2016
 * Luke Salamone
 *
 */

public class Challenge{
	private static ArrayList<String> lines;
	
	// map from ID to student and name to professor
	private static HashMap<Integer,Student> students;
	private static HashMap<String,Professor> professors;
	
	private static ArrayList<Section> sections;
	private static int regHistory, regMath, regPhysics, regChem;
	

	// first parameter must be database name
	public static void main(String[] args){
		if(args.length < 1){
			System.out.println("Usage: java Challenge <csv file>");
			return;
		}
		
		students = new HashMap<Integer,Student>();
		professors = new HashMap<String,Professor>();
		sections = new ArrayList<>();
		
		try{
			Scanner scanner = new Scanner(new File(args[0]));
			lines = new ArrayList<>();
			while(scanner.hasNext()){
				lines.add(scanner.nextLine());
			}
		} catch(FileNotFoundException e){
			System.out.println("Fatal error. File " + args[0] + " not found!");
			return;
		}
		
		// read lines into respective lists
		for(String line: lines){
			String[] arr = line.split(",");
			String subject, professorName;
			int studentId;
			
			if(arr.length != 3){
				System.out.println("Invalid line in database: \"" + line + "\"");
				continue;
			}
			
			// valid line is "class, professor, student id"
			subject = arr[0].trim();
			subject = subject.substring(0,1).toUpperCase() + subject.substring(1).toLowerCase();
			professorName = arr[1].trim();
			studentId = Integer.parseInt(arr[2].trim());
			
			if(!isValidSubject(subject)){
				System.out.println("Subject " + subject + " is invalid.\n");
				continue;
			}
			
			// increment registered count for each subject
			switch(subject){
				case "History":
					regHistory++;
					break;
				case "Mathematics":
					regMath++;
					break;
				case "Physics":
					regPhysics++;
					break;
				case "Chemistry":
					regChem++;
					break;
			}
			
			// add course to professor
			if(professors.containsKey(professorName)){
				professors.get(professorName).addSubject(subject);
			} else {	// create new professor if necessary
				Professor tempProf = new Professor(professorName);
				tempProf.addSubject(subject);
				professors.put(professorName, tempProf);
			}
			
			// add course to student
			if(students.containsKey(studentId)){
				students.get(studentId).addSubject(subject);
			} else {	// create new student if necessary
				Student student = new Student(studentId);
				student.addSubject(subject);
				students.put(studentId, student);
			}
			
			// add section if new
			Section temp = new Section(professorName, subject);
			if(!sections.contains(temp)){
				sections.add(temp);
			}
		}// end for loop
		
		// output answers to questions
		question1();
		question2();
		question3();
		question4();
		question5();
	}
	
	private static void question1(){
		System.out.println("Class Sections Taught:");
		for(Section section : sections){
			System.out.println("\t" + section.subject() + ", " + section.professor());
		}
	}
	
	private static void question2(){
		System.out.println("Classes Taken By Each Student:");
		for(Student student: students.values()){
			System.out.println("\t" + student.id() + ": \t" + student.getCourses());
		}
	}
	
	private static void question3(){
		System.out.println("How many students are registered for each class?");
		System.out.println("\tChemistry: " + regChem);
		System.out.println("\tHistory: " + regHistory);
		System.out.println("\tMathematics: " + regMath);
		System.out.println("\tPhysics: " + regPhysics);
	}
	
	private static void question4(){
		System.out.println("How many students take more than one class?");
		int count = 0;
		String studentIdString = "";
		for(Student student : students.values()){
			if(student.subjectCount() > 1){
				if(count > 0){
					studentIdString += ", ";
				}
				count++;
				studentIdString += student.id();
			}
		}
		
		System.out.println("\t" + count + ": " + studentIdString);
	}
	
	private static void question5(){
		System.out.println("How many professors teach more than one class?");
		int count = 0;
		String professorNameString = "";
		for(Professor professor : professors.values()){
			if(professor.sectionCount() > 1){
				if(count > 0){
					professorNameString += ", ";
				}
				count++;
				professorNameString += professor.name();
			}
		}
		
		System.out.println("\t" + count + ": " + professorNameString);
	}
	
	public static boolean isValidSubject(String subject){
		if(subject == null) return false;
		
		subject = subject.toUpperCase();
		return subject.equals("HISTORY") || subject.equals("MATHEMATICS")
			|| subject.equals("CHEMISTRY") || subject.equals("PHYSICS");
	}
	
	public static int numStudents(){
		return students.values().size();
	}
	
	public static int numProfessors(){
		return professors.values().size();
	}
}
