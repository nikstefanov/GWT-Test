package gwttest.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Grid;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.PushButton;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.VerticalPanel;

public class StaticTest extends Grid implements EntryPoint {

	private static int stInt = 0;
	private static final PushButton addB,showB;
	private static final Label L;
	private static final MyClickHandler CL;
	
	static{
		CL = new MyClickHandler();
		showB = new PushButton("Show",CL);
		addB = new PushButton("Add 1",CL);
		L = new Label(stInt+"");
	}
	
	private StaticTest(){
		super(1,3);
		this.setWidget(0,0,showB);
		this.setWidget(0,1,L);
		this.setWidget(0,2,addB);
	}
	private static class MyClickHandler implements ClickHandler{
	@Override
	public void onClick(ClickEvent event){
		PushButton source = (PushButton)event.getSource();
		if (source.equals(showB)){
			L.setText(stInt+"");
		}
		if (source.equals(addB)){
			stInt++;
		}
	}
	}
	
	@Override
	public void onModuleLoad() {
		StaticTest A = new StaticTest();
		StaticTest B = new StaticTest();
		VerticalPanel vp = new VerticalPanel();
		vp.add(A);
		vp.add(B);
		RootPanel root = RootPanel.get("rootPanel");
		root.add(vp);

	}

}
