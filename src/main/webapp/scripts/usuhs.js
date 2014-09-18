

/**
 * A javascript function that will load the body of another page within the current page. It's intended to be used
 * like this:
 * 
 * <bean id="ActionList" parent="PortalView">
 *   <property name="page">
 *	  <bean parent="Uif-Page"
 *		p:onDocumentReadyScript="loadBodyFrom(&apos;@{#ConfigProperties['application.url']}/kew/ActionList.do&apos;)">
 *	    <property name="cssClasses">
 *	      <list>
 *	        <value>container</value>
 *	      </list>
 *	    </property>
 *	  </bean>
 *   </property>
 *
 * </bean>
 *
 * This brings another page into the current page and adds a header and footer to it. This is mostly for cases when 
 * adding a header/footer to pages that normally are within an iframe.
 */
function loadBodyFrom(href) {
    jQuery.get(href, function(data) {
	var bodyData = data.substring(data.indexOf('<body'), data.indexOf('</body>') + '</body>'.length);
	
        var body = jQuery(jQuery.parseHTML(bodyData)[1]);
        
	if (body.attr('id') == 'Uif-Application') {
            jQuery('#Uif-PageContentWrapper').append(body);
	}
    });
}
