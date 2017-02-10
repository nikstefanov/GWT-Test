package gwttest.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.dom.client.Document;
import com.google.gwt.dom.client.NativeEvent;
import com.google.gwt.event.dom.client.DomEvent;
import com.google.gwt.event.dom.client.KeyPressHandler;
import com.google.gwt.user.client.ui.RichTextArea;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.TextArea;
import com.google.gwt.user.client.ui.VerticalPanel;

public class SimulateKeyStroke implements EntryPoint {

	@Override
	public void onModuleLoad() {
		VerticalPanel vp = new VerticalPanel();
		TextArea ta = new TextArea();
		RichTextArea rta = new RichTextArea();
		vp.add(ta);
		vp.add(rta);		
//		ta.addChangeHandler(this);
//		rta.addBlurHandler(this);
		RootPanel root = RootPanel.get("rootPanel");
		root.add(vp);
		
		rta.setFocus(true);
		NativeEvent ne = Document.get().createKeyDownEvent(false, false, false, false, 'p','p');
		DomEvent.fireNativeEvent(ne, rta);
		ne = Document.get().createKeyUpEvent(false, false, false, false, 'p','p');
		DomEvent.fireNativeEvent(ne, rta);
	}

}
