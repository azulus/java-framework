package us.surrenderto.example.dao.google;

import java.util.UUID;

import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.PrimaryKey;
import javax.jdo.listener.StoreCallback;

import us.surrenderto.example.common.objects.Example;

@PersistenceCapable
public class ExampleGoogleImpl implements Example, StoreCallback {
	@PrimaryKey
	private String id = null;
	private String someText;
	
	/* (non-Javadoc)
	 * @see us.surrenderto.example.common.objects.Example#getId()
	 */
	public String getId() {
		return id;
	}
	/* (non-Javadoc)
	 * @see us.surrenderto.example.common.objects.Example#setId(java.lang.String)
	 */
	public void setId(String id) {
		this.id = id;
	}
	/* (non-Javadoc)
	 * @see us.surrenderto.example.common.objects.Example#getSomeText()
	 */
	public String getSomeText() {
		return someText;
	}
	/* (non-Javadoc)
	 * @see us.surrenderto.example.common.objects.Example#setSomeText(java.lang.String)
	 */
	public void setSomeText(String someText) {
		this.someText = someText;
	}
	
	@Override
	public void jdoPreStore() {
		if(this.id == null) {
			synchronized(this) {
				if(this.id == null) {
					this.id = UUID.randomUUID().toString();
				}
			}
		}
	}
}
