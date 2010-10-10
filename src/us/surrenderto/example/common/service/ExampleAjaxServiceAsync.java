package us.surrenderto.example.common.service;

import java.util.List;

import us.surrenderto.example.common.objects.Example;

import com.google.gwt.user.client.rpc.AsyncCallback;

public interface ExampleAjaxServiceAsync {

	void addExample(String text, AsyncCallback<Example> callback);

	void deleteExample(String id, AsyncCallback<Void> callback);

	void getExample(String id, AsyncCallback<Example> callback);

	void getExamples(AsyncCallback<List<Example>> callback);

	void updateExample(String id, String text, AsyncCallback<Example> callback);

}
