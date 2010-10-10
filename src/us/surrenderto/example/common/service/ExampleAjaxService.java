package us.surrenderto.example.common.service;

import java.util.List;

import org.gwtwidgets.server.spring.GWTRequestMapping;

import us.surrenderto.example.common.objects.Example;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

@GWTRequestMapping("/example")
@RemoteServiceRelativePath("../rpc/example")
public interface ExampleAjaxService extends RemoteService{

	List<Example> getExamples();
	Example addExample(String text);
	Example getExample(String id);
	Example updateExample(String id, String text);
	void deleteExample(String id);
	
}
