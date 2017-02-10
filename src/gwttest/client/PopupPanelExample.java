/**
 * 
 */
package gwttest.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.ClickListener;
import com.google.gwt.user.client.ui.DecoratedPopupPanel;
import com.google.gwt.user.client.ui.DialogBox;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.PopupPanel;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.SimplePanel;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;

/**
 * @author Nikolay
 *
 */
public class PopupPanelExample implements EntryPoint {

	/* (non-Javadoc)
	 * @see com.google.gwt.core.client.EntryPoint#onModuleLoad()
	 */
	private static class MyPopup extends PopupPanel {

	    public MyPopup() {
	      // PopupPanel's constructor takes 'auto-hide' as its boolean parameter.
	      // If this is set, the panel closes itself automatically when the user
	      // clicks outside of it.
	      super(true);

	      // PopupPanel is a SimplePanel, so you have to set it's widget property to
	      // whatever you want its contents to be.
	      setWidget(new Label("Click outside of this popup to close it"));
	    }
	  }

	  public void onModuleLoad() {
	    Button b1 = new Button("Click me to show popup");
	    b1.addClickHandler(new ClickHandler() {
	      public void onClick(ClickEvent event) {
	        // Instantiate the popup and show it.
	        new MyPopup().show();
	      }
	    });

	    RootPanel.get().add(b1);

	    Button b2 = new Button("Click me to show popup partway across the screen");

	    b2.addClickHandler(new ClickHandler() {
	      public void onClick(ClickEvent event) {
	        // Create the new popup.
	        final MyPopup popup = new MyPopup();
	        // Position the popup 1/3rd of the way down and across the screen, and
	        // show the popup. Since the position calculation is based on the
	        // offsetWidth and offsetHeight of the popup, you have to use the
	        // setPopupPositionAndShow(callback) method. The alternative would
	        // be to call show(), calculate the left and top positions, and
	        // call setPopupPosition(left, top). This would have the ugly side
	        // effect of the popup jumping from its original position to its
	        // new position.
	        popup.setPopupPositionAndShow(new PopupPanel.PositionCallback() {
	          public void setPosition(int offsetWidth, int offsetHeight) {
	            int left = (Window.getClientWidth() - offsetWidth) / 3;
	            int top = (Window.getClientHeight() - offsetHeight) / 3;
	            popup.setPopupPosition(left, top);
	          }
	        });
	      }
	    });

	    RootPanel.get().add(b2);
	  }
//	  public void demo()
//	  {
//	      // Create a panel and add it to the screen
//	      panel = new VerticalPanel();
//	      RootPanel.get("demo").add(panel);
//	      panel.setStyleName("table-center");
//	      //
//	      // Create a PopUpPanel with a button to close it
//	      popup = new PopUpPanel(false);
//	      popup.setStyleName("demo-PopUpPanel");
//	      PopUpPanelContents = new VerticalPanel();
//	      popup.setText("PopUpPanel");
//	      message = new HTML("Click 'Close' to close");
//	      message.setStyleName("demo-PopUpPanel-message");
//	      listener = new ClickListener()
//	      {
//	          public void onClick(Widget sender)
//	          {
//	              popup.hide();
//	          }
//	      };
//	      button = new Button("Close", listener);
//	      holder = new SimplePanel();
//	      holder.add(button);
//	      holder.setStyleName("demo-PopUpPanel-footer");
//	      PopUpPanelContents.add(message);
//	      PopUpPanelContents.add(holder);
//	      popup.setWidget(PopUpPanelContents);
//	      //
//	      // Add a button to the demo to show the above PopUpPanel
//	      listener = new ClickListener()
//	      {
//	          public void onClick(Widget sender)
//	          {
//	              popup.center();
//	          }
//	      };
//	      button = new Button("Show PopUpPanel", listener);
//	      panel.add(button);
//	  }

	  


}
