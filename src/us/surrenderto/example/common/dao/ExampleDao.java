package us.surrenderto.example.common.dao;

import java.util.List;

import us.surrenderto.example.common.objects.Example;

public interface ExampleDao {

	List<Example> getAll();
	Example get(String id);
	Example save(Example example);
	void delete(Example example);
	
}
