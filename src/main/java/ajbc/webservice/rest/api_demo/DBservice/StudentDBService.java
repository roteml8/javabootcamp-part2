package ajbc.webservice.rest.api_demo.DBservice;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import ajbc.webservice.rest.api_demo.demoDB.MyDB;
import ajbc.webservice.rest.api_demo.models.Student;

public class StudentDBService {

	private MyDB db;
	private Map<Long, Student> students;
	
	public StudentDBService()
	{
		db = MyDB.getInstance();
		students = db.getStudents();
	}
	// returns all students from the DB as a list 
	
	public List<Student> getAllStudents()
	{
		return new ArrayList<Student>(students.values());
	}
	
	public Student getStudentById(long id)
	{
		return students.get(id);
	}
	
	// add student to DB
	
	public Student addStudent(Student student)
	{
		if (students.containsKey(student.getID()))
			return null;
		students.put(student.getID(), student);
		return student;
	}
	
	// update existing student
	public Student updateStudent(long id, Student studentDetails)
	{
		if (students.containsKey(id))
		{
			Student currentStudent = students.get(id);
			currentStudent.setAverage(studentDetails.getAverage());
			currentStudent.setFirstName(studentDetails.getFirstName());
			currentStudent.setLastName(studentDetails.getLastName());
			students.put(id, currentStudent);
			return currentStudent;
		}
		
		return null;
	}
	
	// delete student from map
	public Student deleteStudent(long id)
	{
		return students.remove(id);
	}
	
	// get list of students with average >= {average}
	public List<Student> getStudentsByAverage(double average)
	{
		return students.values().stream().filter(s->s.getAverage() >= average).collect(Collectors.toList());
	}
	
	// get list of students with minRange <= average <= maxRange
	public List<Student> getStudentsByAverageRange(double minAverage, double maxAverage)
	{
		return students.values().stream().filter(s->s.getAverage() >= minAverage && s.getAverage() <= maxAverage)
				.collect(Collectors.toList());
	}
	

}
