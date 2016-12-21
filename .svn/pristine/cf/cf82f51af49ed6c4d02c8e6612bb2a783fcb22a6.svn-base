<%@ page
	import="org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter"%>
<%@ page
	import="org.springframework.security.core.AuthenticationException"%>


<%@ page session="true"%> 

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
<title>RoW Login</title>
<link rel="stylesheet"
				href="<c:url value="./resources/styles/landing.css" />"
				type="text/css" media="screen, projection" />
				
				
				
				
				
				
				
				
				
				
				

</head>

<body onload='document.loginForm.j_username.focus();'>



<% 
String LOGIN_ERR = "";
String auth_fail_status = "";
String getURL=request.getQueryString();
String requestParam = request.getQueryString();
System.out.println("SpatialVue-auth querystring: " + requestParam);
if(requestParam == null){
	requestParam = "param=1";
}
if(requestParam.indexOf("login_error") == -1){
	String[] params = requestParam.split("&");
	for(int i=0; i<params.length; i++){
		System.out.println("request attributes: " + i + "is " + params[i]);
		String[] reqParam = params[i].split("=");
		System.out.println("request attribute: " + reqParam[0] + " " + reqParam[1]);
		session.setAttribute(reqParam[0], reqParam[1]);
	}
	//session.setAttribute("param", requestParam);
}
if(getURL != null){
	if(getURL.equalsIgnoreCase("login_error=1")){
		//out.println("<div class='auth-fail'>Credentials supplied are incorrect</div>");
		auth_fail_status = "Login credentials incorrect";
	}else if(getURL.equalsIgnoreCase("access_denied=1")){
		//out.println("<div class='auth-fail'>You are not authorized to access the application</div>");
		auth_fail_status = "Un-authorized access not allowed";
	}
}
    String urlLang = request.getQueryString();
    //System.out.println("Url lang: " + urlLang);
    String lang = null;
    if(urlLang != null){
    	int pos = urlLang.indexOf("=");
    	if(pos > -1){
			lang = urlLang.substring(++pos);
		}else{
			lang = "en";
		}
    }else{	
		lang = request.getHeader("accept-language");
		int pos = lang.indexOf(",");
		if(pos > -1){
			lang = lang.substring(0, pos);
		}else{
			lang = "en";
		}
    }
 %>
 
 <div id="header">
	<div class="widthheader">
		<div class="leftheader">
			<c:choose>
			  <c:when test="${lang=='cy'}">
					
               		<img src="<c:url value="resources/images/viewer/logo-text_welsch.png" />" />
					
               </c:when>
               <c:otherwise>
					
               		<img src="<c:url value="resources/images/viewer/logo-text.png" />" />
               </c:otherwise>
            </c:choose>
        </div>
	</div>
</div>
 
 
<div class="loginPannel">
<form id="loginForm" name="loginForm" action="j_spring_security_check"
		method="post">
	
	<div id="main">
		<div id="login-box">
         	<div class="form-shift">
     			<table align="center" width="95%">
      			<tr>
            		<td style="padding-left:5px;">
                		<H2 class="loginTitle"><span>Login</span></H2>
                	</td>
            	</tr>
                <tr class="loginrow">
                    <td id="login-box-name1">
					
					<div class="formElement">
						<div id="authfail_div" class="auth"> </div>
                        <div id="login" class="lbllogin">
						</div>
						<div id="login-box-field"><input class="form-login" id="usernameField" type="text" name="j_username"></input></div>
						<div id="helptxt" >
						</div>
						</div>
						
						
						
						
						
											<div class="formElement">
                        <div id="pwd" class="lbllogin">
						</div>
						<div id="login-box-field">
						 <input  class="form-login" id="passwordField" type="password" name="j_password" />
						</div>
						
						</div>
						
						
						 <input class="loginbutton" id="btnLogin" type="submit" value="Login/Mewngofnodi" />
						 
						 
						 <div>
						 <a href="./forgetPassword" id="forgot_pwd">Forgot password</a> | 
					     <a href="./register" id="register"></a>          
						 </div>	
                    </td>
                </tr>
               
            
            </table>
            </div>
           </div>
          </div>
</form>



</div>



<script language="javascript">			
		var auth_status = "<%=auth_fail_status%>";
		var language = "<%=lang%>";
		displayLanguageStrings(language);
		var authDiv = document.getElementById("authfail_div");
		if(auth_status.length > 0 && language.indexOf("cy")>-1){
			auth_status = "Cymwysterau anghywir Mewngofnodi";
		}
		authDiv.appendChild(document.createTextNode(auth_status));
		
		function displayLanguageStrings(lang){
			//alert(lang);
			var login = document.getElementById("login");
			var password = document.getElementById("pwd");
			var btn = document.getElementById("btnLogin");
			var register = document.getElementById("register");
			var helptxt = document.getElementById("helptxt");
			if(lang.indexOf("cy") > -1){
				login.appendChild(document.createTextNode("Mewngofnodi Id:"));
				password.appendChild(document.createTextNode("Cyfrinair:"));
				btn.value = "Mewngofnodi";
				register.appendChild(document.createTextNode("Cofrestru"));
				helptxt.appendChild(document.createTextNode("(example: name@email.com)"));
			}else if(lang.indexOf("en") > -1){
				login.appendChild(document.createTextNode("User Id:"));
				password.appendChild(document.createTextNode("Password:"));
				btn.value = "Login";
				register.appendChild(document.createTextNode("Register"));
				helptxt.appendChild(document.createTextNode("(example: name@email.com)"));
			}
		}
</script>


	

</body>

</html>