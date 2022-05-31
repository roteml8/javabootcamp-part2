package ajbc.webservice.rest.api_demo.demoDB;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import ajbc.webservice.rest.api_demo.models.Course;
import ajbc.webservice.rest.api_demo.models.Student;

public class MyDB {

	private static MyDB instance = null;
	private Map<Long, Student> students;
	private Map<Long, Course> courses;

	public static synchronized MyDB getInstance() {
		if(instance==null)
			instance = new MyDB();
		return instance;
	}
	
	private MyDB() {
		students = new HashMap<Long, Student>();
		// seeding the db
		seed();
	}

	private void seed() {
		List<Student> studentList = Arrays.asList(
				new Student("Moses", "OOfnik", 88.9),
				new Student("Happy", "Roller", 75.6), 
				new Student("Gabby", "Dice", 98.1),
				new Student("Charles", "Samson", 78.9), 
				new Student("Rachel", "Palace", 89.2)
		);
		
		students = studentList.stream()
	      .collect(Collectors.toMap(Student::getID, Function.identity()));
		
		List<Course> courseList = Arrays.asList(new Course("Linear Algebra"),
				new Course("Computer Science"),
				new Course("Discrete Math"));
		courses = courseList.stream().collect(Collectors.toMap(Course::getID, Function.identity()));
		
		students.get(1001l).setCourses(courseList);
	}
   
	public Map<Long, Student> getStudents(){
		return students;
	}
	
	public Map<Long, Course> getCourses()
	{
		return courses;
	}
}
