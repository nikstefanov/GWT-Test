package gwttest.client.additionalSymbols;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.TextAreaElement;
import com.google.gwt.event.dom.client.BlurEvent;
import com.google.gwt.event.dom.client.BlurHandler;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.FocusEvent;
import com.google.gwt.event.dom.client.FocusHandler;
import com.google.gwt.event.dom.client.MouseOverEvent;
import com.google.gwt.event.dom.client.MouseOverHandler;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiTemplate;
import com.google.gwt.user.client.Command;
import com.google.gwt.user.client.Element;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.MenuBar;
import com.google.gwt.user.client.ui.MenuItem;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.TextArea;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Widget;

public class MenuBarTest1 implements EntryPoint,MouseOverHandler,BlurHandler{

	private Element activeElement = null;
	
	@UiTemplate("MenuBarTest1.ui.xml")
	interface MenuBarUiBinder extends UiBinder<Widget, MenuBarTest1> {
	}
//	private class CommandSymbol extends  
	public void onModuleLoad() {
	    // Make a command that we will execute from all leaves.
	    Command cmd = new Command() {
	      public void execute() {
//	        Window.alert("You selected a menu item!");
	    	 if (activeElement!=null){
//	    		 System.out.println(activeElement.toString());
	    		 System.out.println(activeElement.getTagName());
//	    		 System.out.println(activeElement.getInnerHTML());
//	    		 activeElement.setInnerHTML(activeElement.getInnerHTML()+"&amp;");
	    		if (activeElement.getTagName().equals("TEXTAREA")){
	    			TextAreaElement taElement = TextAreaElement.as(activeElement);
	    			taElement.setValue(taElement.getValue()+"&");
	    		}
	    		 activeElement.focus();
	    	 }
	    	 	
	      }
	    };

	    // Make some sub-menus that we will cascade from the top menu.
	    MenuBar fooMenu = new MenuBar(true);
	    fooMenu.addItem("the", cmd);
	    fooMenu.addItem("foo", cmd);
	    fooMenu.addItem("menu", cmd);

	    MenuBar barMenu = new MenuBar(true);
	    barMenu.addItem("the", cmd);
	    barMenu.addItem("bar", cmd);
	    barMenu.addItem("menu", cmd);

	    MenuBar bazMenu = new MenuBar(true);
	    bazMenu.addItem("the", cmd);
	    bazMenu.addItem("baz", cmd);
	    bazMenu.addItem("menu", cmd);

	    // Make a new menu bar, adding a few cascading menus to it.
	    MenuBar menu = new MenuBar(true);
	    menu.addItem("foo", fooMenu);
	    menu.addItem("bar", barMenu);
	    menu.addItem("baz", bazMenu);

//	    menu.addStyleName("pos_fixed");
	    // Add it to the root panel.
	    RootPanel root = RootPanel.get("rootPanel");
//	    menu.setWidth("30ex");
	    root.add(menu);
	    MenuBarUiBinder menuUiBinder = GWT.create(MenuBarUiBinder.class);
	    Widget Menu2 = menuUiBinder.createAndBindUi(this);
	    Menu2.setWidth("50ex");
	    root.add(Menu2);
	    
	    MenuBar menuSym = new MenuBar(false);
	    MenuBar sub = new MenuBar(true);
	    sub.addItem("&alpha;",true,cmd);
	    sub.addItem("&beta;",true,cmd);
	    sub.addItem("&gamma;",true,cmd);
	    sub.addItem("&mu;",true,cmd);
	    MenuItem itemSym = new MenuItem("<span style=\"font-size:x-small;letter-spacing:.7ex;\">Symbols</span>",true,sub);
	    menuSym.addItem(itemSym);
//	    menuSym.setWidth("7ex");
	    menuSym.addStyleName("pos_fixed");
	    itemSym.setStyleName("sym-MenuItem");
	    root.add(menuSym);
//	    menuSym.setAutoOpen(true);
	    menuSym.setFocusOnHoverEnabled(false);
//	    sub.setFocusOnHoverEnabled(false);
	 	
	    menuSym.addDomHandler(this, MouseOverEvent.getType());
	    TextArea ta1 = new TextArea();
	    ta1.addDomHandler(this, BlurEvent.getType());
	  
	    root.add(new TextBox());
	    root.add(new TextArea());
	    root.add(ta1);
	  }
	@Override
	public void onMouseOver(MouseOverEvent event) {
		System.out.println("MouseOverEvent");
		activeElement = findActiveElement();
		
	}
	@Override
	public void onBlur(BlurEvent event) {
		System.out.println("Blur Event");
		
	}
	private native Element findActiveElement()/*-{
		return $doc.activeElement;
	}-*/;
	
}
