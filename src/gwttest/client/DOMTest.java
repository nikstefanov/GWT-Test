package gwttest.client;

import java.util.Date;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.dom.client.Document;
import com.google.gwt.dom.client.Element;
import com.google.gwt.dom.client.Node;
import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.RichTextArea;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.TextArea;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.datepicker.client.DatePicker;

public class DOMTest implements EntryPoint {

	@Override
	public void onModuleLoad() {
//		ListBox lb = new ListBox(true);
//		lb.addItem("qwe");lb.addItem("qwe1");lb.addItem("qwe543");lb.addItem("qw4 	e");
		final DatePicker datePicker = new DatePicker();
		final RichTextArea rta = new RichTextArea();
		final RichTextArea rta2 = new RichTextArea();
		rta2.setPixelSize(50, 50);
		rta2.setHTML("<font color=\'blue\'>NJJO</font>");
		
		final HTMLPanel hp = new HTMLPanel("");
		hp.add(datePicker);
		

		RootPanel.get().add(rta);
		RootPanel.get().add(new TextArea());
		RootPanel.get().add(rta2);
		Element rta2el = rta2.getElement();
		Node tanode = rta2el.getPreviousSibling();
		Node parent = rta2el.getParentElement();
		Node rtanode = tanode.getPreviousSibling();
		Node ifnode = rtanode.getPreviousSibling();
		Node divnode = ifnode.getPreviousSibling();
		rta2el.removeFromParent();
		divnode.appendChild(rta2el);
		RootPanel.get().add(new HTMLPanel("<IFRAME style=\"WIDTH: 50px; HEIGHT: 50px\" class=gwt-RichTextArea src=\"javascript:\'\'\">"+
		"</IFRAME><TEXTAREA class=gwt-TextArea></TEXTAREA>"));
		
		
		
		System.out.println('\n'+Document.get().getBody().getInnerHTML());
//		Document.get().getBody().appendChild((rta).getElement());
		
	    // Set the value in the text box when the user selects a date
	    datePicker.addValueChangeHandler(new ValueChangeHandler<Date>() {
	      public void onValueChange(ValueChangeEvent<Date> event) {
	        Date date = event.getValue();
	        String dateString = DateTimeFormat.getMediumDateFormat().format(date);
//	        text.setText(dateString);
	      }
	    });


	}

}
