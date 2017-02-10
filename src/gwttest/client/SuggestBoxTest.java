package gwttest.client;

import java.util.Arrays;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.event.dom.client.FocusEvent;
import com.google.gwt.event.dom.client.FocusHandler;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.MultiWordSuggestOracle;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.SuggestBox;
import com.google.gwt.user.client.ui.TextBox;

public class SuggestBoxTest implements EntryPoint,FocusHandler {

	private SuggestBox S;
	@Override
	public void onFocus(FocusEvent event){S.showSuggestionList();}
	@Override
	public void onModuleLoad() {
		RootPanel root = RootPanel.get("rootPanel");
		TextBox TB = new TextBox();
//		root.add(TB);
		MultiWordSuggestOracle oracle = new MultiWordSuggestOracle();
		oracle.add("Ala-Bala");oracle.add("Diadia");oracle.add("GAGA");oracle.add("Bombom");
		oracle.setDefaultSuggestionsFromText(Arrays.asList("Text1","Miau","Dir.bg","Yahoo"));
//		String [] suggestions = {"Ala-bala","Baba-Yaga","Coco","Diado","Hasan","Handan","Hizbula","Canadian","Canyon","Disco","Forest"};
//		FSTRA2SuggestOracle oracle = new FSTRA2SuggestOracle(suggestions,",;");
		SuggestBox.DefaultSuggestionDisplay display = new SuggestBox.DefaultSuggestionDisplay();
		S = new SuggestBox(oracle,TB,display);
		S.setAutoSelectEnabled(false);		
		root.add(S);
		root.add(new HTML(".</br>.</br>.</br>.</br>.</br>.</br>.</br>.</br>"));
		TB.addFocusHandler(this);
		oracle.add("100 patrona");
	}

}
