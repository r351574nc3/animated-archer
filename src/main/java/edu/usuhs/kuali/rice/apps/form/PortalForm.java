package edu.usuhs.kuali.rice.apps.form;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.kuali.rice.krad.web.form.UifFormBase;

public class PortalForm extends UifFormBase {
    private static final long serialVersionUID = -2439489169870273604L;

    protected String tomorrowFormatted;

    public String getTomorrowFormatted() {
	return this.tomorrowFormatted;
    }

    public void setTomorrowFormatted(final String tomorrowFormatted) {
	this.tomorrowFormatted = tomorrowFormatted;
    }
}
