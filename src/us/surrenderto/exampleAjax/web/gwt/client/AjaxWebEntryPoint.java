package us.surrenderto.exampleAjax.web.gwt.client;

import java.util.Iterator;
import java.util.List;

import us.surrenderto.example.common.objects.Example;
import us.surrenderto.example.common.service.ExampleAjaxService;
import us.surrenderto.example.common.service.ExampleAjaxServiceAsync;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.RootPanel;

public class AjaxWebEntryPoint implements EntryPoint {
	ExampleAjaxServiceAsync exampleService = (ExampleAjaxServiceAsync) GWT.create(ExampleAjaxService.class);
	
	HTML output;

	@Override
	public void onModuleLoad() {
		
		output = new HTML();
		output.setHTML("this should be replaced");
		RootPanel.get().add(output);
		
		exampleService.getExamples(new AsyncCallback<List<Example>>() {

			@Override
			public void onFailure(Throwable caught) {
				Window.alert(caught.getMessage());
			}

			@Override
			public void onSuccess(List<Example> result) {
				if(result == null) {
					output.setHTML("no examples added yet");
				}else{
					StringBuilder builder = new StringBuilder();
					Iterator<Example> iterator = result.iterator();
					while(iterator.hasNext()) {
						builder.append("<p>").append(iterator.next().getSomeText()).append("</p>");
					}
					output.setHTML(builder.toString());
				}
			}
			
		});
	}

}
