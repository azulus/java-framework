package us.surrenderto.utils.general;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public abstract class InstanceConverter {
	Map<Class, Builder> builders = new HashMap<Class,Builder>();
	Map<Class, Class> impls = new HashMap<Class,Class>();
	
	public InstanceConverter(Class[] interfaces, Class[] implementations, Builder[] builders) {
		for(int a=0; a<interfaces.length; a++) {
			impls.put(interfaces[a], implementations[a]);
			this.builders.put(interfaces[a], builders[a]);
		}
	}
	
	protected Object[] sanitize(Object[] args) {
		for(int a=0; a<args.length; a++) {
			args[a] = sanitize(args[a]);
		}
		return args;
	}
	
	protected Map<Class,Class> getClasses() {
		return impls;
	}
	
	protected Map<Class,Builder> getBuilders() {
		return builders;
	}
	
	public Object sanitize(Object obj) {
		Object checkObj = obj instanceof List ? (((List)obj).size() > 0 ? ((List)obj).get(0): null) : obj;
		if(checkObj == null) return null;
		
		Map<Class,Class> classes = getClasses();
		if(classes == null) return obj;
		
		Iterator<Class> iterator = classes.keySet().iterator();
		while(iterator.hasNext()) {
			Class clazz = iterator.next();
			if(clazz.isInstance(checkObj)) {
				return getBuilders().get(clazz).buildFromObject(obj, classes.get(clazz));
			}
		}
		
		return checkObj;
	}
}
