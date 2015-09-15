import static org.junit.Assert.*;

import org.junit.Test;

public class StudentTest {

	@Test
	public void testStudentCollectionAddAndLookup() {
		StudentCollection studentCollection = new StudentCollection();
		Student student1 = new Student("Chri",  1);
		Student student2 = new Student("Devon", 22);
		Student student3 = new Student("River", 333);
		Student student4 = new Student("Ryan",  444);
		assertTrue(studentCollection.add(student1));
		assertTrue(studentCollection.add(student2));
		assertTrue(studentCollection.add(student3));
		assertTrue(studentCollection.add(student4));
		Student queriedStudent = studentCollection.get("Chri");
		assertTrue(queriedStudent.getId() == "Chri" && queriedStudent.getPassword() == 1);
		queriedStudent = studentCollection.get("Devon");
		assertTrue(queriedStudent.getId() == "Devon" && queriedStudent.getPassword() == 22);
		queriedStudent = studentCollection.get("River");
		assertTrue(queriedStudent.getId() == "River" && queriedStudent.getPassword() == 333);
		queriedStudent = studentCollection.get("Ryan");
		assertTrue(queriedStudent.getId() == "Ryan" && queriedStudent.getPassword() == 444);
		
		// tests duplicate players being added
		Student dupStudent = new Student("Ryan", 90210);
		assertFalse(studentCollection.add(dupStudent));
		Student originalStudent = studentCollection.get(dupStudent.getId());
		assertTrue(originalStudent.getId() == "Ryan" && originalStudent.getPassword() == 444);
	
	}
	
	@Test
	public void testStudentMinuteLimit() {
		StudentCollection studentCollection = new StudentCollection();
		Student student1 = new Student("Chri",  1);
		Student student2 = new Student("Devon", 22);
		Student student3 = new Student("River", 333);
		Student student4 = new Student("Ryan",  444);
		assertTrue(studentCollection.add(student1));
		assertTrue(studentCollection.add(student2));
		assertTrue(studentCollection.add(student3));
		assertTrue(studentCollection.add(student4));
		assertTrue( studentCollection.get(student3.getId()).getLifetimeSecondsRemaining() == (1500 * 60) );
		assertFalse(student1.canPlaySong(1501*60));
		student1.setNumOfSongsPlayedToday(3);
		assertFalse(student1.canPlaySong(300));
		assertTrue(student2.canPlaySong(30));
		
	}

}