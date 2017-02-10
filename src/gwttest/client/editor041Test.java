/**
 * 
 */
package gwttest.client;

import com.gc.gwt.wysiwyg.client.Editor;
import com.gc.gwt.wysiwyg.client.EditorToolbar;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.VerticalPanel;

/**
 * @author Nikolay
 *
 */
public class editor041Test implements EntryPoint {

	/* (non-Javadoc)
	 * @see com.google.gwt.core.client.EntryPoint#onModuleLoad()
	 */
	@Override
	public void onModuleLoad() {
		VerticalPanel vp = new VerticalPanel();
		EditorToolbar etb = new EditorToolbar();
		Editor e = new Editor(etb);
		vp.add(etb);
		vp.add(e);
		
		RootPanel root = RootPanel.get();
		root.add(vp);

	}

}
