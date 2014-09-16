<#--

    Copyright 2005-2014 The Kuali Foundation

    Licensed under the Educational Community License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

    http://www.opensource.org/licenses/ecl2.php

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.

-->
<#macro uif_card element>

    <#if element.labelText?has_content>
        <#local label="${element.labelText}"/>
        <#local url="${element.url}"/>
        <#local description="${element.description}"/>
        <#local button="${element.buttonText}"/>

        <div class="col-lg-4">
           <h2>${label}</h2>

          <p>
            <a class="btn btn-primary" href="${url}" role="button">${button} <span class="glyphicon glyphicon-chevron-right" /></a>
          </p>
        </div>
    </#if>
</#macro>
