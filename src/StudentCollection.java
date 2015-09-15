import java.util.HashMap;

public class StudentCollection {
	
	HashMap<String,Student> students;
	int size;
	
	
	public StudentCollection() {
		students = new HashMap<String,Student>();
		size = 0;
	}
	
	public boolean add(Student student) {
		if (!students.containsKey(student.getId())) {
			students.put(student.getId(), student);
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

}
