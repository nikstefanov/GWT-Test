package gwttest.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.ui.Grid;
import com.google.gwt.user.client.ui.RootPanel;

public class ColumnHiddingInTables implements EntryPoint {

	@Override
	public void onModuleLoad() {
		Grid G = new Grid(3,4);
		G.setText(1, 0, "A");
		G.setText(1, 1, "B");
		G.setText(1, 2, "C");
		G.setText(1, 3, "D");
//		G.setBorderWidth(1);
		G.getColumnFormatter().setStylePrimaryName(2, "erasedStyle");
		G.getColumnFormatter().setStyleName(3, "redBackgroung");
		RootPanel.get("rootPanel").add(G);
	}

}
