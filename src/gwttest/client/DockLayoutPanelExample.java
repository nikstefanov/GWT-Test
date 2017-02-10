/**
 * 
 */
package gwttest.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.DockLayoutPanel;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.PushButton;
import com.google.gwt.user.client.ui.RootLayoutPanel;

/**
 * @author Nikolay
 *
 */
public class DockLayoutPanelExample implements EntryPoint,ClickHandler{

	/* (non-Javadoc)
	 * @see com.google.gwt.core.client.EntryPoint#onModuleLoad()
	 */
	DockLayoutPanel p;
	PushButton B;
	HTML south;
	public DockLayoutPanelExample(){
		south = new HTML("south");
		p = new DockLayoutPanel(Unit.EM);
		p.animate(3000);
		B = new PushButton("Add something to south.",this);
		// Attach five widgets to a DockLayoutPanel, one in each direction. Lay
	    // them out in 'em' units.	    
	    p.addNorth(new HTML("north"), 2);	    
	    p.addSouth(south, 2);
		p.insertSouth(new HTML("asjd"), 3, south);
	    p.addEast(new HTML("east"), 2);
	    p.addWest(new HTML("west"), 2);
//	    p.add(new HTML("center"));
	    p.add(B);
	    
	}
	@Override
	public void onModuleLoad() {
		// Attach the LayoutPanel to the RootLayoutPanel. The latter will listen for
	    // resize events on the window to ensure that its children are informed of
	    // possible size changes.
	    RootLayoutPanel rp = RootLayoutPanel.get();
	    rp.add(p);
	}
	@Override
	public void onClick(ClickEvent clickEv){
		p.remove(south);
//		p.insertSouth(new HTML("asjd"), 3, south);
//		if (south.isVisible()){
//			p.remove(south);
//			south.setVisible(false);
//		}
//		else{
//		south.setVisible(true);
//		p.addSouth(south, 3);
//		}
	}

}
