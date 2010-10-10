package us.surrenderto.example.common.service;

import java.util.List;

import us.surrenderto.example.common.objects.Example;

public interface ExampleService {

	List<Example> getExamples();
	Example addExample(String text);
	Example getExample(String id);
	Example updateExample(String id, String text);
	void deleteExample(String id);
	
}
