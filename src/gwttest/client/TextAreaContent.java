package gwttest.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.TextArea;

public class TextAreaContent implements EntryPoint,ClickHandler {

	private TextArea ta;
	private Button butt; 
	
	public TextAreaContent(){
		ta  = new TextArea();
		butt = new Button("Content",this);
	}	

	@Override
	public void onClick(ClickEvent event) {
		String content = ta.getValue();
		for(int i=0;i<content.length();i++){
			System.out.print((int)content.charAt(i)+" ");
		}
		System.out.println();
		
	}
	
	@Override
	public void onModuleLoad() {
		RootPanel root = RootPanel.get("rootPanel");
		root.add(ta);
		root.add(butt);

	}

}
