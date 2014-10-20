package reis.util;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

public class UtilMessage {

	public static void errorMessage(String message){
		FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, message,"");
		FacesContext.getCurrentInstance().addMessage(null, msg);
	}
	
	
	public static void infoMessage(String message){
		FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, message, "");
		FacesContext.getCurrentInstance().addMessage(null, msg);
	}
}
