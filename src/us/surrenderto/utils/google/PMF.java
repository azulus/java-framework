package us.surrenderto.utils.google;

import javax.jdo.JDOHelper;
import javax.jdo.PersistenceManager;
import javax.jdo.PersistenceManagerFactory;

public class PMF {
	private static final PersistenceManagerFactory pmfInstance = JDOHelper.getPersistenceManagerFactory("transactions-optional");
	
	private PMF() {}
	
	public static PersistenceManagerFactory get() {
		return pmfInstance;
	}
}
