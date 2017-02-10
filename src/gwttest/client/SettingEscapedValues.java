package gwttest.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.dom.client.Element;
import com.google.gwt.dom.client.IFrameElement;
import com.google.gwt.dom.client.InputElement;
import com.google.gwt.user.client.ui.RichTextArea;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.TextBox;
//import com.google.gwt.user.client.Element;

public class SettingEscapedValues implements EntryPoint {

	@Override
	public void onModuleLoad() {
		RootPanel root = RootPanel.get("rootPanel");
//		RichTextArea tb1= new RichTextArea();
		TextBox tb1= new TextBox();
		root.add(tb1);
//		tb1.setHTML("jsdklfj&amp;");
		tb1.setValue("yyut");
		Element tbEl = tb1.getElement();
		System.out.println("InnerHTML: "+tbEl.getInnerHTML());
		System.out.println("InnerText: "+tbEl.getInnerText());
//		tbEl.setInnerHTML("html&lt;");
		InputElement intb1 = (InputElement)tbEl;
		System.out.println("getValue: "+intb1.getValue());
//		System.out.println("InnerText: "+intb1.getInnerText());
		intb1.setValue("mia@");
		
		RichTextArea rta = new RichTextArea();
		root.add(rta);
		rta.setHTML("<p style=\"color:red\">I'm a superman!</p>");
		com.google.gwt.user.client.Element rtaEl = rta.getElement();
		IFrameElement rtaEl1 = IFrameElement.as(rtaEl);
		System.out.println("IFrame "+rtaEl.toString());
		System.out.println("Document: "+rtaEl1.getContentDocument().getChildCount());
	}

}
