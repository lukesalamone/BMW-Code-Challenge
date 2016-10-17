/* Tests.java
 *
 * Test essential methods from Challenge
 * 
 * Luke Salamone
 */
 
public class Tests{
 	public static void main(String[] args){
 		Challenge challenge = new Challenge();
 		challenge.main(args);
 		
 		System.out.println("\n*** Now running unit tests ***\n");
 		
 		testValidSubjects();
 		testNumStudents(challenge);
 		testNumProfessors(challenge);
 	}
 	
 	private static void testValidSubjects(){
 		boolean test1 = Challenge.isValidSubject("Chemistry");
 		boolean test2 = Challenge.isValidSubject("cHeMiStRy");
 		boolean test3 = Challenge.isValidSubject("");
 		boolean test4 = Challenge.isValidSubject(null);
 		
 		System.out.println("running testValidSubjects():");
 		assertEquals(true, test1);
 		assertEquals(true, test2);
 		assertEquals(false, test3);
 		assertEquals(false, test4);
 	}
 	
 	private static void testNumStudents(Challenge challenge){
 		int numStudents = challenge.numStudents();
 		System.out.println("running testNumStudents():");
 		assertEquals(6, numStudents);
 	}
 	
 	private static void testNumProfessors(Challenge challenge){
 		int numProfessors = challenge.numProfessors();
 		System.out.println("running testNumProfessors():");
 		assertEquals(5, numProfessors);
 	}
 	
 	// simple assertEquals method
 	private static void assertEquals(boolean expected, boolean actual){
 		if(expected == actual){
 			System.out.println("Test successful! (expected " + expected + ")");
 		} else {
 			System.out.println("Test failed. (expected " + expected + ", actual " + actual + ")");
 		}
 	}
 	
 	 private static void assertEquals(int expected, int actual){
 		if(expected == actual){
 			System.out.println("Test successful! (expected " + expected + ")");
 		} else {
 			System.out.println("Test failed. (expected " + expected + ", actual " + actual + ")");
 		}
 	}
}
