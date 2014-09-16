package edu.usuhs.kuali.rice.apps.controller;

import edu.usuhs.kuali.rice.apps.form.PortalForm;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.text.SimpleDateFormat;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.kuali.rice.krad.service.KRADServiceLocatorWeb;
import org.kuali.rice.krad.web.controller.UifControllerBase;
import org.kuali.rice.krad.web.form.UifFormBase;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/portal")
public class LandingController extends UifControllerBase {

    private static final String DEFAULT_VIEW_ID = "Landing";
    
    @Override
    protected UifFormBase createInitialForm(HttpServletRequest request) {
	return new UifFormBase();
    }

    protected Date getNextBusinessDay() {
	return new GregorianCalendar() {{
	    add(Calendar.HOUR, 24); // Add 24 hours from now
	}}.getTime();
    }
    
    @RequestMapping("/home")
    public ModelAndView home(@ModelAttribute("KualiForm") UifFormBase form, 
			     BindingResult result,
			     HttpServletRequest request, 
			     HttpServletResponse response) {             
	
	System.out.println(form.getClass());
	if (form instanceof PortalForm) {
	    final PortalForm portalForm = (PortalForm) form;
	    portalForm.setTomorrowFormatted(new SimpleDateFormat("MM/dd/yyyy").format(getNextBusinessDay()));
	}

	form.setViewId(DEFAULT_VIEW_ID);
	form.setView(KRADServiceLocatorWeb.getViewService().getViewById(DEFAULT_VIEW_ID));
	form.setMethodToCall("start");
	System.out.println("Calling start");
	return start(form, result, request, response);
    }
}
