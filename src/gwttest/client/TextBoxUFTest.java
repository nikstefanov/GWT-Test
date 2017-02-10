package gwttest.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.Widget;

public class TextBoxUFTest extends Composite {

	private static TextBoxUFTestUiBinder uiBinder = GWT
			.create(TextBoxUFTestUiBinder.class);

	interface TextBoxUFTestUiBinder extends UiBinder<Widget, TextBoxUFTest> {
	}

	public TextBoxUFTest() {
		initWidget(uiBinder.createAndBindUi(this));
	}
	public void onModuleLoad() {
		RootPanel.get().add(new TextBoxUFTest());
	}

}
