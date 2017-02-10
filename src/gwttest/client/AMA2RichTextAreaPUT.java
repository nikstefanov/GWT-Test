/** 
 * 
 */
package gwttest.client;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.sample.showcase.client.content.text.RichTextToolbar;
import com.google.gwt.user.client.ui.DecoratedPopupPanel;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.PushButton;
import com.google.gwt.user.client.ui.RichTextArea;

/**
 * @author Nikolay
 *
 */
public class AMA2RichTextAreaPUT extends RichTextArea{

	/* (non-Javadoc)
	 * @see com.google.gwt.event.dom.client.ClickHandler#onClick(com.google.gwt.event.dom.client.ClickEvent)
	 */	
	private static final DecoratedPopupPanel dpp;
	private static final RichTextToolbar rtt;
	private static final EventHandler handler;
	private static final int height;//78
	private static final int width;//510
	private static final HorizontalPanel hp;
	private static final PushButton pbutton;
	private static final ButtonClickHandler bch;
	
	public AMA2RichTextAreaPUT(){
		this.addClickHandler(handler);
	}
	
	static {
		dpp = new DecoratedPopupPanel();
		rtt = new RichTextToolbar();
		handler = new EventHandler();
		bch = new ButtonClickHandler();
		pbutton = new PushButton("x",bch);
		hp = new HorizontalPanel();
		hp.add(rtt);hp.add(pbutton);
		dpp.setWidget(hp);
		dpp.setAutoHideEnabled(true);
		height = 78;//dpp.getOffsetHeight();
		width = 510;//dpp.getOffsetWidth();		
	}
	
	private static class EventHandler implements ClickHandler {
		private RichTextArea rta = null;
		private int PPleftPos = 0,PPtopPos = 0;
		@Override
		public void onClick(ClickEvent clEvent){
//			RichTextAreaPUT.dpp.hide();
			rta = (RichTextArea)clEvent.getSource();
			AMA2RichTextAreaPUT.rtt.setRichTextArea(rta);		
			
			PPleftPos = rta.getAbsoluteLeft() + (rta.getOffsetWidth() -  AMA2RichTextAreaPUT.width)/2;
			PPleftPos = (PPleftPos<0)?0:PPleftPos;
			
			PPtopPos = rta.getAbsoluteTop() -  AMA2RichTextAreaPUT.height;
			PPtopPos = (PPtopPos<0)?rta.getAbsoluteTop() + rta.getOffsetHeight():PPtopPos;
			
			AMA2RichTextAreaPUT.dpp.setPopupPosition(PPleftPos, PPtopPos);			
			AMA2RichTextAreaPUT.dpp.show();
//			System.out.println("Height: "+RichTextAreaPUT.dpp.getOffsetHeight());
//			System.out.println("Width: "+RichTextAreaPUT.dpp.getOffsetWidth());
		}
	}
	
	private static class ButtonClickHandler implements ClickHandler {
		@Override
		public void onClick(ClickEvent clEvent){
//			System.out.println(clEvent.getSource().toString());
			AMA2RichTextAreaPUT.dpp.hide();
		}
	}
	/*
	@Override
	public String getValueString() {
		return this.getHTML();
		
	}

	@Override
	public int getSubWidgets() {		
		return 1;
	}

	@Override
	public void setValueString(String val) {
		this.setHTML(val);
		
	}
	
	@Override
	public boolean setValueContinual(StringBuilder sb) {
		int index = sb.indexOf(AMA2Widget.delimiter+"");
		if (index == - 1) return false;
		this.setHTML(sb.substring(0, index));
		sb.delete(0, index+1);
		return true;
	}
	
	@Override
	public void getValueContinual(StringBuilder sb) {
		sb.append(this.getHTML()).append(AMA2Widget.delimiter);
		
	}

	@Override
	public boolean validate() {
		// TODO Auto-generated method stub
		return true;
	}
	*/
}
