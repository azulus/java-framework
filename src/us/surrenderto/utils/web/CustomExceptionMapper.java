package us.surrenderto.utils.web;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;
import javax.xml.bind.annotation.XmlRootElement;

import org.springframework.security.authentication.AuthenticationCredentialsNotFoundException;
import org.springframework.stereotype.Component;

@Component
@Provider
public class CustomExceptionMapper implements ExceptionMapper<Exception>{
	@XmlRootElement
	public static class ErrorResponse {
		private String error;
		private int code;
		
		public ErrorResponse(String error, int code) {
			this.error = error;
			this.code = code;
		}

		/**
		 * @return the error
		 */
		public String getError() {
			return error;
		}

		/**
		 * @param error the error to set
		 */
		public void setError(String error) {
			this.error = error;
		}

		public int getCode() {
			return code;
		}

		public void setCode(int code) {
			this.code = code;
		}
	}
	
	public Response toResponse(Exception e) {
		ResponseBuilder builder = Response.status(Status.OK);
		builder.type(MediaType.APPLICATION_JSON);
		Throwable t = (Throwable)e;
		while(t.getCause() != null) 
			t = t.getCause();
		
		if(t instanceof IndexOutOfBoundsException)
			builder.entity(new ErrorResponse("Item not found", 404));
		else if(t instanceof AuthenticationCredentialsNotFoundException)
			builder.entity(new ErrorResponse("Access is denied", 401));
		else
			builder.entity(new ErrorResponse(t.getMessage(), 0));
		
		return builder.build();
	}
}
