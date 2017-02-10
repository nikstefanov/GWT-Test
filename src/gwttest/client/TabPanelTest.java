package gwttest.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiTemplate;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.TabPanel;

public class TabPanelTest implements EntryPoint {
	
	@UiTemplate("TabPanelUiBinder.ui.xml")
	interface TabPanelUiBinder extends UiBinder<TabPanel, TabPanelTest> {}

	@Override
	public void onModuleLoad() {
		RootPanel root = RootPanel.get("rootPanel");
		UiBinder<TabPanel, TabPanelTest> UiBi;
		UiBi = GWT.create(TabPanelUiBinder.class);
		root.add(UiBi.createAndBindUi(this));
	}

}
