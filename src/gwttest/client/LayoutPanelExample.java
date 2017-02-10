/**
 * 
 */
package gwttest.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.dom.client.Style;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.LayoutPanel;
import com.google.gwt.user.client.ui.RootLayoutPanel;
import com.google.gwt.user.client.ui.Widget;


/**
 * @author Nikolay
 *
 */
public class LayoutPanelExample implements EntryPoint {

	/* (non-Javadoc)
	 * @see com.google.gwt.core.client.EntryPoint#onModuleLoad()
	 */
	@Override
	public void onModuleLoad() {
		// Attach two child widgets to a LayoutPanel, laying them out horizontally,
	    // splitting at 50%.
	    Widget childOne = new HTML("left"), childTwo = new HTML("right");
	    LayoutPanel p = new LayoutPanel();
	    p.add(childOne);
	    p.add(childTwo);

	    p.setWidgetLeftWidth(childOne, 0, Style.Unit.PCT, 50, Style.Unit.PCT);
	    p.setWidgetRightWidth(childTwo, 0, Style.Unit.PCT, 50, Style.Unit.PCT);

	    // Attach the LayoutPanel to the RootLayoutPanel. The latter will listen for
	    // resize events on the window to ensure that its children are informed of
	    // possible size changes.
	    RootLayoutPanel rp = RootLayoutPanel.get();
	    rp.add(p);


	}

}
