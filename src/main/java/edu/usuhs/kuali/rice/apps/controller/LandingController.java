package edu.usuhs.kuali.rice.apps.controller;

import edu.usuhs.kuali.rice.apps.form.PortalForm;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.text.SimpleDateFormat;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.kuali.rice.krad.service.KRADServiceLocatorWeb;
import org.kuali.rice.krad.web.controller.UifControllerBase;
import org.kuali.rice.krad.web.form.UifFormBase;
import org.kuali.rice.krad.util.GlobalVariables;
import org.kuali.rice.kim.api.role.RoleService;
import org.kuali.rice.kim.api.services.KimApiServiceLocator;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import edu.usuhs.kuali.rice.apps.form.PortalForm;

@Controller
@RequestMapping("/portal")
public class LandingController extends UifControllerBase {

    private static final String DEFAULT_VIEW_ID = "Landing";
    
    @Override
    protected UifFormBase createInitialForm(HttpServletRequest request) {
        return new PortalForm();
    }

    protected Date getNextBusinessDay() {
        return new GregorianCalendar() {{
            add(Calendar.HOUR, 24); // Add 24 hours from now
        }}.getTime();
    }

    protected RoleService getRoleService() {
        return KimApiServiceLocator.getRoleService();
    }
    
    @RequestMapping("/home")
    public ModelAndView home(@ModelAttribute("KualiForm") PortalForm form, 
                             BindingResult result,
                             HttpServletRequest request, 
                             HttpServletResponse response) {             
        
        System.out.println(form.getClass());
        final String currentUser = GlobalVariables.getUserSession().getPrincipalId();
        final String adminRole = getRoleService().getRoleByNamespaceCodeAndName("KR-SYS", "Technical Administrator").getId();
        final List<String> adminRoles = new ArrayList<String>();
        adminRoles.add(adminRole);

        form.setTomorrowFormatted(new SimpleDateFormat("MM/dd/yyyy").format(getNextBusinessDay()));
        form.setUserIsAdmin(getRoleService().principalHasRole(currentUser, adminRoles, new HashMap<String,String>())); 

        form.setViewId(DEFAULT_VIEW_ID);
        form.setView(KRADServiceLocatorWeb.getViewService().getViewById(DEFAULT_VIEW_ID));
        form.setMethodToCall("start");
        System.out.println("Calling start");
        return start(form, result, request, response);
    }
}
