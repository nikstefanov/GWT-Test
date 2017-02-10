package gwttest.client;

import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.UIObject;

import com.google.gwt.dom.client.Document;
import com.google.gwt.event.dom.client.KeyDownEvent;
import com.google.gwt.event.dom.client.KeyDownHandler;
import com.google.gwt.event.dom.client.KeyPressEvent;
import com.google.gwt.event.dom.client.KeyPressHandler;

public class TextBoxUF extends TextBox implements KeyPressHandler,KeyDownHandler {

	public TextBoxUF(){
		this.addKeyPressHandler(this);
		this.addKeyDownHandler(this);
	}
	@Override
	public void onKeyPress(KeyPressEvent event) {
		System.out.println((int)event.getCharCode());
		if(event.getCharCode()==13)
//			this.setFocus(false);
//			Document.get().createKeyPressEvent(false, false, false, false, 9);
			((UIObject)event.getSource()).getElement().getNextSiblingElement().focus();
	}
	@Override
	public void onKeyDown(KeyDownEvent event) {
		System.out.println((int)event.getNativeKeyCode());
		if(event.getNativeKeyCode()==13)
//			this.setFocus(false);
//			Document.get().createKeyPressEvent(false, false, false, false, 9);
			((UIObject)event.getSource()).getElement().getNextSiblingElement().focus();
	}

}
