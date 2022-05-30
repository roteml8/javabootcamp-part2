package ajbc.webservice.rest.api_demo.resources;

import java.util.List;

import ajbc.webservice.rest.api_demo.DBservice.CourseDBService;
import ajbc.webservice.rest.api_demo.models.Course;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("courses")
public class CourseResource {
	
	CourseDBService courseDB = new CourseDBService();
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Course> getAllCourses()
	{
		return courseDB.getAllCourses();
	}

	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Course getCourseById(@PathParam("id") long id)
	{
		return courseDB.getCourseById(id);
	}
	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Course addNewCourse(Course course)
	{
		return courseDB.addCourse(course);
	}
	
	@PUT
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Course updateCourse(@PathParam("id") long id, Course course)
	{
		return courseDB.updateCourse(id, course);
	}
	
	@DELETE
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Course deleteCourse(@PathParam("id") long id)
	{
		return courseDB.deleteCourse(id);
	}

}
