/**
 * 
 */
package gwttest.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.smartgwt.client.widgets.RichTextEditor;

/**
 * @author Nikolay
 *
 */
public class SmartGWTTest implements EntryPoint {

	/* (non-Javadoc)
	 * @see com.google.gwt.core.client.EntryPoint#onModuleLoad()
	 */
	@Override
	public void onModuleLoad() {
		VerticalPanel vp = new VerticalPanel();
		RichTextEditor rte = new RichTextEditor();
		vp.add(rte);
		
		RootPanel root = RootPanel.get("formTest");
		root.add(vp);

	}

}
