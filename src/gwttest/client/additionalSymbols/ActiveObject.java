package gwttest.client.additionalSymbols;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.event.dom.client.BlurEvent;
import com.google.gwt.event.dom.client.BlurHandler;
import com.google.gwt.user.client.Command;
import com.google.gwt.user.client.Element;
import com.google.gwt.user.client.Event;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.MenuBar;
import com.google.gwt.user.client.ui.MenuItem;
import com.google.gwt.user.client.ui.RichTextArea;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.TextBox;

public class ActiveObject implements BlurHandler,Command,EntryPoint {

	@Override
	public void onModuleLoad() {
		RootPanel root = RootPanel.get("rootPanel");
		TextBox tb1 = new TextBox();
		RichTextArea rta1 = new RichTextArea();
		root.add(tb1);
		root.add(rta1);
		rta1.addBlurHandler(this);
		tb1.addBlurHandler(this);
		
		MenuBar mb1 = new MenuBar(false){
			public void onBrowserEvent(Event event){
				Element elem = findActiveElement();
				System.out.println("Event fired! "+event.getTypeInt()+elem.toString());
				super.onBrowserEvent(event);
			}
			private native Element findActiveElement()/*-{
				return $doc.activeElement;
			}-*/;
		};
//		MenuBar mb1 = new MenuBar(false);
		mb1.setFocusOnHoverEnabled(true);
		MenuItem item = new MenuItem("Text",this);
		mb1.addItem(item);
		root.add(mb1);
	}
	@Override
	public void execute() {
        Window.alert("You selected a menu item!");
      }
	@Override
	public void onBlur(BlurEvent event) {
		System.out.println("Blur event "+event.getSource().toString());
	}
}
