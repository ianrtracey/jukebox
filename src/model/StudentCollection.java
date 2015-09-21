package model;
import java.util.HashMap;

public class StudentCollection {
	
	HashMap<String,Student> students;
	int size;
	
	
	public StudentCollection() {
		students = new HashMap<String,Student>();
		populateStudents();
	}
	
	public boolean add(Student student) {
		if (!students.containsKey(student.getId())) {
			students.put(student.getId(), student);
			size++;
			return true;
		
		}
		
		return false;
	}
	
	public Student get(String id) {
		if (!students.containsKey(id)) {
			return null;
		}
		
		return students.get(id);
	}
	
	private void populateStudents() {
		this.add( new Student("Chri",  1) );
 		this.add( new Student("Devon", 22) );
 		this.add( new Student("River", 333) );
		this.add( new Student("Ryan",  444) );
	}

}
