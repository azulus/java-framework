package us.surrenderto.example.web.gwt;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import us.surrenderto.example.common.objects.Example;
import us.surrenderto.example.common.service.ExampleAjaxService;
import us.surrenderto.example.common.service.ExampleService;

@Service
public class ExampleAjaxServiceImpl implements ExampleAjaxService {
	@Autowired
	private ExampleService exampleService;
	
	@Override
	public Example addExample(String text) {
		return exampleService.addExample(text);
	}

	@Override
	public void deleteExample(String id) {
		exampleService.deleteExample(id);
	}

	@Override
	public Example getExample(String id) {
		return exampleService.getExample(id);
	}

	@Override
	public List<Example> getExamples() {
		return exampleService.getExamples();
	}

	@Override
	public Example updateExample(String id, String text) {
		return exampleService.updateExample(id, text);
	}

}
