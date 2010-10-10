package us.surrenderto.example.common.objects;

import java.io.Serializable;

public class ExampleImpl implements Example, Serializable {
	private String id;
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
}
