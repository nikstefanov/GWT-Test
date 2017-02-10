package gwttest.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.RichTextArea;
import com.google.gwt.user.client.ui.RootPanel;

public class RTATextTest implements EntryPoint,ClickHandler {

	AMA2RichTextAreaPUT rta;
	Button BtnGet;
	
	@Override
	public void onModuleLoad() {
		RootPanel root = RootPanel.get("rootPanel");
		rta = new AMA2RichTextAreaPUT();
		rta.setHTML("<p style=\"font-style:italic\">line1<br/>Line2</p><p>New Paragraph.</p>\r\n<p>Third Paragraph!</p>");
		root.add(rta);		
		BtnGet = new Button("Get Content",this);
		root.add(BtnGet);
	}

	@Override
	public void onClick(ClickEvent event) {
		if (event.getSource().equals(BtnGet)){
			System.out.println("Text: "+rta.getText());
			System.out.println("HTML: "+rta.getHTML());
		}
		
	}

}
