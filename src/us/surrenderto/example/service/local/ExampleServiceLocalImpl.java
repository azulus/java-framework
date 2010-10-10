package us.surrenderto.example.service.local;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import us.surrenderto.example.common.dao.ExampleDao;
import us.surrenderto.example.common.objects.Example;
import us.surrenderto.example.common.objects.ExampleImpl;
import us.surrenderto.example.common.service.ExampleService;

@Service
public class ExampleServiceLocalImpl implements ExampleService {
	@Autowired
	ExampleDao exampleDao;

	@Override
	public Example addExample(String text) {
		Example example = new ExampleImpl();
		example.setSomeText(text);
		return exampleDao.save(example);
	}

	@Override
	public void deleteExample(String id) {
		Example example = exampleDao.get(id);
		exampleDao.delete(example);
	}

	@Override
	public Example getExample(String id) {
		return exampleDao.get(id);
	}

	@Override
	public List<Example> getExamples() {
		return exampleDao.getAll();
	}

	@Override
	public Example updateExample(String id, String text) {
		Example example = exampleDao.get(id);
		example.setSomeText(text);
		return exampleDao.save(example);
	}

}
