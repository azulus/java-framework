package us.surrenderto.exampleAjax.web.resteasy;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.ModelAndView;

@Controller
@Path("/web/exampleAjax")
@Produces(MediaType.TEXT_HTML)
public class ExampleAjaxWebController {

	@GET
	@Path("")
	public ModelAndView home() {
		return new ModelAndView("exampleAjax/home");
	}
	
}
