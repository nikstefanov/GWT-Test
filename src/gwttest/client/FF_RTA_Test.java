package gwttest.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.TabPanel;
import com.google.gwt.user.client.ui.Widget;

public class FF_RTA_Test extends Composite implements EntryPoint{

	private static FF_RTA_TestUiBinder uiBinder = GWT
			.create(FF_RTA_TestUiBinder.class);

	interface FF_RTA_TestUiBinder extends UiBinder<Widget, FF_RTA_Test> {
	}

	public FF_RTA_Test() {
		initWidget(uiBinder.createAndBindUi(this));
	}
	
	@Override
	public void onModuleLoad() {
		RootPanel root = RootPanel.get("rootPanel");
		/*
		TabPanel tp = new TabPanel();
		tp.add(new FF_RTA_Test(), "Tab1", false);
		tp.add(new FF_RTA_Test(), "Tab2", false);
		tp.selectTab(0);
		root.add(tp);
		*/
		FlowPanel fp1 = new FlowPanel();
		fp1.add(new FF_RTA_Test());
		FlowPanel fp2 = new FlowPanel();
		fp2.add(new FF_RTA_Test());
		root.add(fp1);
		root.add(fp2);
		
	}

}
