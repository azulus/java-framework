package us.surrenderto.example.dao.google;

import java.util.Iterator;
import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

import org.springframework.stereotype.Repository;

import us.surrenderto.example.common.dao.ExampleDao;
import us.surrenderto.example.common.objects.Example;
import us.surrenderto.utils.google.PMF;

@Repository
public class ExampleDaoGoogleImpl implements ExampleDao {

	@Override
	public void delete(Example example) {
		PersistenceManager mgr = PMF.get().getPersistenceManager();
		try {
			Query query = mgr.newQuery(ExampleGoogleImpl.class);
			query.setFilter("id == idParam");
			query.declareParameters("String idParam");
			query.deletePersistentAll(example.getId());
		} finally {
			mgr.close();
		}
	}

	@Override
	public Example get(String id) {
		PersistenceManager mgr = PMF.get().getPersistenceManager();
		try {
			Query query = mgr.newQuery(ExampleGoogleImpl.class);
			query.setFilter("id == idParam");
			query.declareParameters("String idParam");
			return ((List<Example>)query.execute(id)).get(0);
		} finally {
			mgr.close();
		}
	}

	@Override
	public List<Example> getAll() {
		PersistenceManager mgr = PMF.get().getPersistenceManager();
		try {
			Query query = mgr.newQuery(ExampleGoogleImpl.class);
			List<Example> list = ((List<Example>)query.execute());
			Iterator<Example> iterator = list.iterator();
			while(iterator.hasNext()) iterator.next();
			return list;
		} finally {
			mgr.close();
		}
	}

	@Override
	public Example save(Example example) {
		PersistenceManager mgr = PMF.get().getPersistenceManager();
		try {
			mgr.makePersistent(example);
			return example;
		} finally {
			mgr.close();
		}
	}

}
