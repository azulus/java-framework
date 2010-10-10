package us.surrenderto.example.utils;

import us.surrenderto.example.common.objects.Example;
import us.surrenderto.utils.general.Builder;

public class ExampleBuilder extends Builder<Example>{
	private static class Loader {
		private static ExampleBuilder INSTANCE = new ExampleBuilder();
	}
	
	private ExampleBuilder() {
		
	}
	
	public static ExampleBuilder get() {
		return Loader.INSTANCE;
	}

	@Override
	public void copy(Example from, Example to) {
		to.setId(from.getId());
		to.setSomeText(from.getSomeText());
	}

}
