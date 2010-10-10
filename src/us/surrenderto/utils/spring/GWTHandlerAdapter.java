package us.surrenderto.utils.spring;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.gwtwidgets.server.spring.GWTRPCServiceExporter;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerAdapter;
import org.springframework.web.servlet.ModelAndView;

@Component
public class GWTHandlerAdapter implements HandlerAdapter{

	@Override
	public long getLastModified(HttpServletRequest arg0, Object arg1) {
		return System.currentTimeMillis();
	}

	@Override
	public ModelAndView handle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
		((GWTRPCServiceExporter)handler).doPost(request, response);
		return null;
	}

	@Override
	public boolean supports(Object handler) {
		return handler instanceof GWTRPCServiceExporter;
	}
	
}
