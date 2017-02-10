package gwttest.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.event.logical.shared.BeforeSelectionEvent;
import com.google.gwt.event.logical.shared.BeforeSelectionHandler;
import com.google.gwt.event.logical.shared.SelectionEvent;
import com.google.gwt.event.logical.shared.SelectionHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.TabBar;

public class TabBarExample implements EntryPoint {

	  public void onModuleLoad() {
	    // Create a tab bar with three items.
	    TabBar bar = new TabBar();
	    bar.addTab("foo");
	    bar.addTab("bar");
	    bar.addTab("<img src=\"http://debian.fmi.uni-sofia.bg/~nikstefanov/ocean_floor.jpg\">",true);
//	    bar.setTabText(0, "Example1");

	    // Hook up a tab listener to do something when the user selects a tab.
	    bar.addSelectionHandler(new SelectionHandler<Integer>() {
	      public void onSelection(SelectionEvent<Integer> event) {
	        // Let the user know what they just did.
	        Window.alert("You clicked tab " + event.getSelectedItem());
	      }
	    });

	    // Just for fun, let's disallow selection of 'bar'.
	    bar.addBeforeSelectionHandler(new BeforeSelectionHandler<Integer>() {
	      public void onBeforeSelection(BeforeSelectionEvent<Integer> event) {
	        if (event.getItem().intValue() == 1) {
	          event.cancel();
	        }
	      }
	    });

	    // Add it to the root panel.
	    RootPanel.get().add(bar);
	  }
	}

