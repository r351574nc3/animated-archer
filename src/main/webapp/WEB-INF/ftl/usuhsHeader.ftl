<#macro usuhs_header element>

<#assign homeLink = "landing">
<#assign oldPortalLink = "/rice-apps/portal.do">
    <!-- Fixed navbar -->
    <#local adminUrl=element.templateOptions['adminUrl'] />
    <div class="navbar navbar-default navbar-fixed-top" role="navigation">
      <div class="container-fluid">
        <div class="navbar-header">
          <a class="navbar-brand usuhs-brand" style="padding: 0px 15px 15px 15px;" href="#"><img src="/rice-apps/images/logo.png" /></a>
        </div>
        <#if adminUrl?has_content>
        <div class="collapse navbar-collapse">
          <ul class="nav navbar-nav">
              <li><a href="${adminUrl}">Administration</a></li>
          </ul>
        </div>
        </#if>
      </div>
    </div>
</#macro>
