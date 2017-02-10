package gwttest.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.ui.CheckBox;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.RichTextArea;
import com.google.gwt.user.client.ui.TextBox;

public class GetTextOfTableCell implements EntryPoint {

	@Override
	public void onModuleLoad() {
		FlexTable FT = new FlexTable();
		FT.setWidget(0, 0, new ListBox());
//		FT.setHTML(0, 0, "&#111;-BALA");
		FT.getCellFormatter().addStyleName(0, 0, "bolded");
		FT.getRowFormatter().addStyleName(0, "centered");
		System.out.println("Text: "+FT.getText(0, 0)+" "+FT.getText(0, 0).length());
		System.out.println("HTML: "+FT.getHTML(0, 0));
	}

}
