/**
 * 
 */
package gwttest.client;

import org.gwt.advanced.client.ui.widget.Calendar;


import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.VerticalPanel;

/**
 * @author Nikolay
 *
 */
public class AdvCompTest implements EntryPoint {

	/* (non-Javadoc)
	 * @see com.google.gwt.core.client.EntryPoint#onModuleLoad()
	 */
	@Override
	public void onModuleLoad() {
		VerticalPanel vp = new VerticalPanel();
		Calendar c= new Calendar();
		vp.add(c);
		
		RootPanel root = RootPanel.get("formTest");
		root.add(vp);
	}

}
