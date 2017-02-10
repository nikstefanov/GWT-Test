package gwttest.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.event.dom.client.BlurEvent;
import com.google.gwt.event.dom.client.BlurHandler;
import com.google.gwt.event.dom.client.ChangeEvent;
import com.google.gwt.event.dom.client.ChangeHandler;
import com.google.gwt.user.client.ui.RichTextArea;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.TextArea;
import com.google.gwt.user.client.ui.VerticalPanel;

public class TextFields implements EntryPoint,BlurHandler,ChangeHandler{

	@Override
	public void onModuleLoad() {
		VerticalPanel vp = new VerticalPanel();
		TextArea ta = new TextArea();
		RichTextArea rta = new RichTextArea();
		vp.add(ta);
		vp.add(rta);		
		ta.addChangeHandler(this);
		rta.addBlurHandler(this);
		RootPanel root = RootPanel.get("rootPanel");
		root.add(vp);

	}

	@Override
	public void onChange(ChangeEvent event) {
		String oldValue;
		TextArea Source = (TextArea)event.getSource();
		oldValue = Source.getValue();
		System.out.println("TextArea value: "+oldValue);
		Source.setValue("");
		
		Source.setValue("S\u001F Se\u00F1or");
	}

	@Override
	public void onBlur(BlurEvent event) {
		String oldValue;
		RichTextArea Source = (RichTextArea)event.getSource();
		oldValue = Source.getHTML();
		System.out.println("RichTextArea value: "+oldValue);
		Source.setHTML("");
		Source.setHTML(oldValue);
	}

}
