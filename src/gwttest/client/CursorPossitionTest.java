package gwttest.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.event.dom.client.BlurEvent;
import com.google.gwt.event.dom.client.BlurHandler;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.KeyPressEvent;
import com.google.gwt.event.dom.client.KeyPressHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.TextArea;
import com.google.gwt.user.client.ui.TextBox;

public class CursorPossitionTest implements EntryPoint,ClickHandler,KeyPressHandler,BlurHandler{

	private final TextArea	TBItem;
	private final Label		LabelPossition;
	private final Label		LabelLength;
	
	private CursorPossitionTest(){
		TBItem = new TextArea();
		TBItem.addClickHandler(this);
		TBItem.addKeyPressHandler(this);
		TBItem.addBlurHandler(this);
		LabelPossition = new Label();
		LabelLength = new Label();
	}
	
	@Override
	public void onKeyPress(KeyPressEvent event) {
		this.onAction();
	}

	@Override
	public void onClick(ClickEvent event) {
		this.onAction();		
	}
	
	@Override
	public void onBlur(BlurEvent event) {
		this.onAction();
		
		Window.alert(((TextArea)event.getSource()).getCursorPos()+"");
	}	
	
	private void onAction(){
		LabelPossition.setText(TBItem.getCursorPos()+"");
		LabelLength.setText(TBItem.getSelectionLength()+"");	
	}
	
	@Override
	public void onModuleLoad() {
		RootPanel root = RootPanel.get("rootPanel");
		root.add(TBItem);
		root.add(new Label("Possition"));
		root.add(LabelPossition);
		root.add(new Label("Selection Length"));
		root.add(LabelLength);
		root.add(new TextBox());
		
	}	

}
