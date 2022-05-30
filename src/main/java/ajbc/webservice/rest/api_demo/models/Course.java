package ajbc.webservice.rest.api_demo.models;

import java.util.ArrayList;
import java.util.List;

public class Course {

	private final Long ID;
	private String name;
	private List<Student> students;
	private static long counter = 10;
	
	public Course() {
		this.ID = generateId();
	}
	
	public Course(String name)
	{
		this.ID = generateId();
		setName(name);
		setStudents(new ArrayList<>());
	}
	private synchronized long generateId() {
		return counter++;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getID() {
		return ID;
	}

	public List<Student> getStudents() {
		return students;
	}

	public void setStudents(List<Student> students) {
		this.students = students;
	}

	@Override
	public String toString() {
		return "Course [ID=" + ID + ", name=" + name + ", students=" + students + "]";
	}
	
	
	
	
}
