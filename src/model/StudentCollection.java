/*+----------------------------------------------------------------------
 ||
 ||  Class StudentCollection
 ||
 ||        Purpose:  Represents a collection of Student objects for the
 ||                  JukeBox implementation
 ||
 |+-----------------------------------------------------------------------
 ||
 ||        Methods: public StudentCollection()
 ||                 public boolean add(Student student)
 ||					public Student get(String id)
 ||                 private void populateStudents()
 ||
 ++-----------------------------------------------------------------------*/
package model;
import java.util.HashMap;

public class StudentCollection {
	
	private HashMap<String,Student> students;	// Contains all students
	private int size;							// How many entries are there?
	
	public StudentCollection() {
		students = new HashMap<String,Student>();
		populateStudents();
	} // Ends Constructor
	
	public boolean add(Student student) {
		if (students.containsKey(student.getId()) != true) {
			students.put(student.getId(), student);
			size++;
			return true;
		} // Ends Condition that the student does not exist in the map
		return false; // The student is already in the map
	} // Ends Method add
	
	public Student get(String id) {
		if (!students.containsKey(id)) {
			return null;
		} // Ends condition that the student is not in the map
		return students.get(id); // Else return the student object
	} // Ends Method get
	
	private void populateStudents() {
		this.add( new Student("Chris",  1) );
 		this.add( new Student("Devon", 22) );
 		this.add( new Student("River", 333) );
		this.add( new Student("Ryan",  4444) );
		
		
	} // Ends Method populateStudents
} // Ends Class StudentCollection
