package us.surrenderto.utils.general;

import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public abstract class Builder<T> {
	private class ClassExtractor<K> {
		private Class clazz;
		
		private Class getServiceClass() {
			if(clazz == null) {
				synchronized (this) {
					if (clazz == null) {
						ParameterizedType parameterizedType = (ParameterizedType) (getClass().getGenericSuperclass());
						clazz = (Class) parameterizedType.getActualTypeArguments()[0];
					}
				}
			}
			return clazz;
		}
		
		@SuppressWarnings("unchecked")
		public K newInstance() {
			try{
				return (K)getServiceClass().newInstance();
			}catch(Exception e) {
				e.printStackTrace();
				return null;
			}
		}
	}
	
	public abstract void copy(T from, T to);
	
	@SuppressWarnings("unchecked")
	public T build(Class clazz) {
		try{
			return (T)clazz.newInstance();
		}catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public T buildFrom(T from, Class clazz) {
		T to = build(clazz);
		copy(from,to);
		return to;
	}
	
	public List<T> buildFrom(List<T> from, Class clazz) {
		List<T> list = new ArrayList<T>();
		Iterator<T> iterator = from.iterator();
		while(iterator.hasNext())
			list.add(buildFrom(iterator.next(),clazz));
		return list;
	}
	
	public Object buildFromObject(Object from, Class clazz) {
		if(from instanceof List) {
			return buildFrom((List<T>)from, clazz);
		}else{
			return buildFrom((T)from, clazz);
		}
	}
}
