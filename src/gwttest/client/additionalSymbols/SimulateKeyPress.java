package gwttest.client.additionalSymbols;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.dom.client.Document;
import com.google.gwt.dom.client.NativeEvent;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.TextBox;

public class SimulateKeyPress implements EntryPoint,ClickHandler {

	TextBox tb1;
	TextBox tb2;
	Button B;
	
	private SimulateKeyPress(){
		tb1= new TextBox();
		tb2= new TextBox();
		B = new Button("Focus",this);
	}
	
	@Override
	public void onModuleLoad() {		
		RootPanel root = RootPanel.get("rootPanel");
		root.add(tb1);root.add(tb2);root.add(B);
	}

	@Override
	public void onClick(ClickEvent event) {
		NativeEvent ne = Document.get().createKeyPressEvent(false, false,false, false, 55) ;
		tb2.getElement().dispatchEvent(ne);
	}

}
