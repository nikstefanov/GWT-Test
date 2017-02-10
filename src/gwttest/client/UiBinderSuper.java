package gwttest.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiTemplate;
import com.google.gwt.user.client.ui.Widget;

class UiBinderSuper extends UiBinderBase{
	
	private static UiBinderSuperUiBinder uiBinder = GWT
			.create(UiBinderSuperUiBinder.class);

	@UiTemplate("UiBinderTest.ui.xml")
	interface UiBinderSuperUiBinder extends UiBinder<Widget, UiBinderSuper> {
	}

	public UiBinderSuper() {
		initWidget(uiBinder.createAndBindUi(this));
	}

}
