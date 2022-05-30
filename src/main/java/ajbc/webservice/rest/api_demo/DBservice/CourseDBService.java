package ajbc.webservice.rest.api_demo.DBservice;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import ajbc.webservice.rest.api_demo.demoDB.MyDB;
import ajbc.webservice.rest.api_demo.models.Course;

public class CourseDBService {

	private MyDB db;
	private Map<Long, Course> courses;
	
	public CourseDBService()
	{
		db = MyDB.getInstance();
		courses = db.getCourses();
	}
	
	public List<Course> getAllCourses()
	{
		return new ArrayList<Course>(courses.values());
	}
	
	public Course getCourseById(long id)
	{
		return courses.get(id);
	}
	
	
	public Course addCourse(Course course)
	{
		courses.put(course.getID(), course);
		return course;
	}
	
	public Course updateCourse(long id, Course course)
	{
		if (courses.containsKey(id))
		{
			Course currCourse = courses.get(id);
			currCourse.setName(course.getName());
			currCourse.setStudents(course.getStudents());
			courses.put(id, currCourse);
			return currCourse;
		}
		return null;
	}
	
	
	public Course deleteCourse(long id)
	{
		return courses.remove(id);
	}
}
