package gwttest.client;



import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiFactory;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;

public class UiBinderTest implements EntryPoint {

	private static UiBinderTestUiBinder uiBinder = GWT
			.create(UiBinderTestUiBinder.class);

	interface UiBinderTestUiBinder extends UiBinder<Widget, UiBinderTest> {
	}
	final private TextBox[] row;
	private int count;
	
	
	public UiBinderTest() {
//		initWidget(uiBinder.createAndBindUi(this));
		row = new TextBox[2];
		count = 0;		
	}
	
	
	@UiFactory
	TextBox TextBoxMaker(){
		row[count] = new TextBox();
		row[count].setValue("Row"+count);
		return row[count++];
	}
	@Override
	public void onModuleLoad() {
		VerticalPanel vp = new VerticalPanel();
		
		vp.add(uiBinder.createAndBindUi(this));
		
		RootPanel root = RootPanel.get("rootPanel");
		root.add(vp);
	}

}
