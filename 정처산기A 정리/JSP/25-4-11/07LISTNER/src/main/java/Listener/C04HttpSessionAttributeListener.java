package Listener;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;

@WebListener
public class C04HttpSessionAttributeListener implements HttpSessionAttributeListener
{

	@Override
	public void attributeAdded(HttpSessionBindingEvent se) {
		System.out.println("[LISTENER] C04HttpSessionAttributeListener Added");
	}

	@Override
	public void attributeRemoved(HttpSessionBindingEvent se) {
		
		System.out.println("[LISTENER] C04HttpSessionAttributeListener Removed");
	}

	@Override
	public void attributeReplaced(HttpSessionBindingEvent se) {
		
		System.out.println("[LISTENER] C04HttpSessionAttributeListener Replaced");
	}

	
	
}
