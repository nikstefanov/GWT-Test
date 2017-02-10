package gwttest.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.uibinder.client.UiFactory;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.TextBox;

class UiBinderBase extends Composite implements EntryPoint {

	final static TextBox [] Array = new TextBox[15];
	static int count = 0;
	
	@UiFactory
	static TextBox TextBoxMaker(){
		Array[count] = new TextBox();
		Array[count].setValue("Row"+count);
		return Array[count++];
	}	
	
	@Override
	public void onModuleLoad() {
		RootPanel root = RootPanel.get("rootPanel");
		root.add(new UiBinderSuper());

	}

}
