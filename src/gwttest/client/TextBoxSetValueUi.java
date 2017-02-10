package gwttest.client;

// Checks in what order a textbox value is set with ui binder. 
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.RootPanel;


public class TextBoxSetValueUi implements EntryPoint {

	interface UiBinderTestUiBinder extends UiBinder<HTMLPanel, TextBoxSetValueUi> {}	
	
	@Override
	public void onModuleLoad() {
		UiBinderTestUiBinder uiBinder = GWT
				.create(UiBinderTestUiBinder.class);
		RootPanel root = RootPanel.get("rootPanel");
		root.add(uiBinder.createAndBindUi(this));

	}

}
