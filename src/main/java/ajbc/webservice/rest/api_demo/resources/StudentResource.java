package ajbc.webservice.rest.api_demo.resources;

import java.util.List;

import ajbc.webservice.rest.api_demo.DBservice.StudentDBService;
import ajbc.webservice.rest.api_demo.models.Student;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("students")
public class StudentResource {

	StudentDBService studentDB = new StudentDBService();
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Student> getAllStudents()
	{
		return studentDB.getAllStudents();
	}
	
	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Student getStudentWithId(@PathParam("id") long id)
	{	
		return studentDB.getStudentById(id);
	}
	
	// add new student
	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Student addStudnet(Student student)
	{
		return studentDB.addStudent(student);
	}
	
	// update an existing student
	@PUT
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Student updateStudent(@PathParam("id") long id, Student student)
	{
		return studentDB.updateStudent(id, student);
	}
	
	// delete student
	@DELETE
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Student deleteStudent(@PathParam("id") long id)
	{
		return studentDB.deleteStudent(id);
	}
	
	
}
