/**
 * 
 */
package gwttest.client;

import com.google.code.p.gwtchismes.client.*;
import com.google.code.p.gwtchismes.client.editor.GWTCEditor;
import com.google.code.p.gwtchismes.client.editor.Toolbar;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.ui.RichTextArea;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.VerticalPanel;

/**
 * @author Nikolay
 *
 */
public class gwtchismesExample implements EntryPoint {

	public void onModuleLoad() {
		VerticalPanel vp = new VerticalPanel();
		GWTCEditor editor = new GWTCEditor();
//		vp.add(editor);
//		RichTextArea rta = new RichTextArea();
//		Toolbar tb = new Toolbar(rta,new myToolbarConstants());
//		vp.add(tb);
//		vp.add(rta);	
		vp.add(editor);
		RootPanel root = RootPanel.get("formTest");
		root.add(vp);
	}
}
