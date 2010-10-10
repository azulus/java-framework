package us.surrenderto.example.web.resteasy;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import us.surrenderto.example.common.objects.Example;
import us.surrenderto.example.common.service.ExampleService;

@Controller
@Path("/api/example")
@Produces(MediaType.APPLICATION_JSON)
public class ExampleApiController {
	@Autowired
	private ExampleService exampleService;

	@GET
	@Path("")
	public List<Example> getAll() {
		return exampleService.getExamples();
	}
	
	@GET
	@Path("/{id}")
	public Example get(@PathParam("id") String id) {
		return exampleService.getExample(id);
	}
	
	/*
	 * Methods below are for testing and not truly RESTful
	 */
	
	@GET
	@Path("/add")
	public Example add(@QueryParam("text") String text) {
		return exampleService.addExample(text);
	}
	
	@GET
	@Path("/update/{id}")
	public Example update(@PathParam("id") String id, @QueryParam("text") String text) {
		return exampleService.updateExample(id, text);
	}
	
	@GET
	@Path("/delete/{id}")
	public String delete(@PathParam("id") String id) {
		exampleService.deleteExample(id);
		return "[]";
	}
}
