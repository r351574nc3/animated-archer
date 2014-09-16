/**
 * Copyright 2005-2014 The Kuali Foundation
 *
 * Licensed under the Educational Community License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.opensource.org/licenses/ecl2.php
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package edu.usuhs.kuali.rice.apps.card;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.kuali.rice.krad.datadictionary.parse.BeanTag;
import org.kuali.rice.krad.datadictionary.parse.BeanTagAttribute;
import org.kuali.rice.krad.datadictionary.validator.ValidationTrace;
import org.kuali.rice.krad.datadictionary.validator.Validator;
import org.kuali.rice.krad.service.KRADServiceLocatorWeb;
import org.kuali.rice.krad.uif.UifConstants;
import org.kuali.rice.krad.uif.component.Component;
import org.kuali.rice.krad.util.KRADConstants;
import org.kuali.rice.krad.uif.element.ContentElementBase;

/**
 *
 * @author Kuali Rice Team (rice.collab@kuali.org)
 */
@BeanTag(name = "card-bean", parent = "Uif-Card")
public class Card extends ContentElementBase {
    private static final long serialVersionUID = -6491546893195180115L;

    protected String labelText;
    protected String url;
    protected String buttonText;
    protected String description;

    public Card() {
	super.setRender(true);
    }

    public void setLabelText(final String labelText) {
	this.labelText = labelText;
    }

    public String getLabelText() {
	return labelText;
    }

    public void setUrl(final String url) {
	this.url = url;
    }
    
    public String getDescription() {
	return description;
    }
    public void setDescription(final String description) {
	this.description = description;
    }
    
    public String getUrl() {
	return url;
    }
    public void setButtonText(final String buttonText) {
	this.buttonText = buttonText;
    }
    
    public String getButtonText() {
	return buttonText;
    }
}
