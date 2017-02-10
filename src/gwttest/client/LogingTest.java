package gwttest.client;

import com.google.gwt.core.client.EntryPoint;

public class LogingTest implements EntryPoint {

	@Override
	public void onModuleLoad() {
		consoleLog("TEstLog");

	}
	private native void consoleLog(String message) /*-{
    console.log( message );
}-*/;

}
