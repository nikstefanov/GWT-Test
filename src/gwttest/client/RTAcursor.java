package gwttest.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.Scheduler.ScheduledCommand;
import com.google.gwt.dom.client.Element;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.MouseOverEvent;
import com.google.gwt.event.dom.client.MouseOverHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Grid;
import com.google.gwt.user.client.ui.InlineLabel;
import com.google.gwt.user.client.ui.MenuBar;
import com.google.gwt.user.client.ui.RichTextArea;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.impl.RichTextAreaImplMozilla;

public class RTAcursor implements EntryPoint,ClickHandler,ScheduledCommand,MouseOverHandler{

	RichTextArea rta;
	Button BtnGet,BtnIns,BtnA,BtnB;
	InlineLabel SymbolButton;
	Grid ButtonGird;
	
	public RTAcursor(){
		rta = new RichTextArea();
		BtnGet = new Button("Get Content",this);
		BtnIns = new Button("Insert",this);
		SymbolButton = new InlineLabel("Symbols");
		SymbolButton.addStyleName("pos_fixed");
//		SymbolButton.addClickHandler(this);
		SymbolButton.addMouseOverHandler(this);
		
		BtnA = new Button("A",this);
		BtnB = new Button("B",this);
		ButtonGird = new Grid(2,1);
		ButtonGird.setWidget(0, 0, BtnA);
		ButtonGird.setWidget(1, 0, BtnB);
		ButtonGird.addStyleName("pos_fixed");
		
	}
	
	@Override
	public void onModuleLoad() {
		RootPanel root = RootPanel.get("rootPanel");		
		rta.setHTML("<p style=\"font-style:italic\">line1<br/>Line2</p><p>New Paragraph.</p>\r\n<p>Third Paragraph!</p>");
		root.add(rta);
		root.add(BtnGet);
		root.add(BtnIns);
		root.add(SymbolButton);
		
		 MenuBar fooMenu = new MenuBar(true);
		    fooMenu.addItem("the", this);
		    fooMenu.addItem("foo", this);
		    fooMenu.addItem("menu", this);
		    fooMenu.setFocusOnHoverEnabled(false);
		    fooMenu.addHandler(this, ClickEvent.getType());
		 MenuBar menu = new MenuBar();
		    menu.addItem("foo", fooMenu);
		    menu.setAutoOpen(true);
		    menu.setFocusOnHoverEnabled(false);

		root.add(menu);
		
	}
	
	@Override
	public void execute() {
//		rta.getFormatter().insertHTML("This was <b>inserted</b>.");		
	}
	
	@Override
	public void onMouseOver(MouseOverEvent event) {
		RootPanel.get("rootPanel").add(ButtonGird);		
	}

	@Override
	public void onClick(ClickEvent event) {
		if (event.getSource().equals(BtnGet)){
//			System.out.println("Text: "+rta.getText());
//			System.out.println("HTML: "+rta.getHTML());	
			
//			setSelectionRange(rta.getElement(), 5, 2);
//            rta.setFocus(true);
			System.out.println(getSelection(rta.getElement()));
		}else
		if(event.getSource().equals(BtnIns)){
			rta.getFormatter().insertHTML("This is <b>inserted</b>.");
		}else
		if (event.getSource().equals(SymbolButton)){
			rta.getFormatter().insertHTML("This was <b>inserted</b>.");
		}else
		if (event.getSource().equals(BtnA)){
			rta.getFormatter().insertHTML("This was <b>A</b>.");
			RootPanel.get("rootPanel").remove(ButtonGird);
		}else
		if (event.getSource().equals(BtnB)){
			rta.getFormatter().insertHTML("This was <b>B</b>.");
			RootPanel.get("rootPanel").remove(ButtonGird);
		}
		else{rta.getFormatter().insertHTML("This was <b>inserted</b>.");		}
	}
	
	public native void setSelectionRange(Element elem, int pos, int length) /*-{
    try {
        var selection = null, range2 = null;
        var iframeWindow = elem.contentWindow;
        var iframeDocument = iframeWindow.document;

        selection = iframeWindow.getSelection();
        range2 = selection.getRangeAt(0);

        //create new range
        var range = iframeDocument.createRange();
        range.setStart(selection.anchorNode, pos);
        range.setEnd(selection.anchorNode, length);

        //remove the old range and add the newly created range
        if (selection.removeRange) { // Firefox, Opera, IE after version 9
            selection.removeRange(range2);
        } else {
            if (selection.removeAllRanges) { // Safari, Google Chrome
                selection.removeAllRanges();
            }
        }
        selection.addRange(range);
    } catch (e) {
        $wnd.alert(e);
    }
}-*/;
	
	public native int getSelection(Element elem) /*-{
	    var txt = "";
	    var pos = 0;
	    var range;
	    var parentElement;
	    var container;
	
	if (elem.contentWindow.getSelection) {
	    txt = elem.contentWindow.getSelection();
	    pos = elem.contentWindow.getSelection().getRangeAt(0).startOffset;
	} else if (elem.contentWindow.document.getSelection) {
	    txt = elem.contentWindow.document.getSelection();
	    pos = elem.contentWindow.document.getSelection().getRangeAt(0).startOffset;
	} else if (elem.contentWindow.document.selection) {
	    range = elem.contentWindow.document.selection.createRange();
	    txt = range.text;
	    parentElement = range.parentElement();
	    container = range.duplicate();
	    container.moveToElementText(parentElement);
	    container.setEndPoint('EndToEnd', range);
	    pos = container.text.length - range.text.length;
	}
	return pos;
}-*/;	
}
