package com.rmsi.spatialvue.http;

import java.io.IOException;
import java.security.Principal;
import java.util.Set;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;
import org.springframework.security.web.savedrequest.DefaultSavedRequest;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;

public class CustomSuccessHandler extends SavedRequestAwareAuthenticationSuccessHandler {
	
	@Override
	public void onAuthenticationSuccess(final HttpServletRequest request,
            final HttpServletResponse response, final Authentication authentication)
            		throws IOException, ServletException {
		
		HttpSession session = request.getSession(true);
		 try {
			 User user = (User)authentication.getPrincipal();
             String principalName = user.getUsername();
             Set<String> roles = AuthorityUtils.authorityListToSet(user.getAuthorities());
			 
			 System.out.println("Authenticated user name is: " + principalName);
			 
			 if (roles.contains("ROLE_ADMIN")) {
		            //request.getSession().setAttribute("myVale", "myvalue");
		        	System.out.println("User Role is:  ROLE_ADMIN");
		        }
			 
			// String ctoken = (String) request.getSession().getAttribute(WebConstants.CSRF_TOKEN);
			 //DefaultSavedRequest defaultSavedRequest = (DefaultSavedRequest) request.getSession().getAttribute("SPRING_SECURITY_SAVED_REQUEST_KEY");
			// String requestUrl = defaultSavedRequest.getRequestURL() + "?" + defaultSavedRequest.getQueryString();
	        // requestUrl = UrlTool.addParamToURL(requestUrl, WebConstants.CSRF_TOKEN, ctoken, true);
			// requestUrl = UrlTool.addParamToURL(requestUrl, null, null, true);
			 
			 //System.out.println("Requested URL: " + requestUrl);
			
			 UserInfo userInfo = new UserInfo();
			 userInfo.setUsername(principalName);
			 session.setAttribute("user", userInfo);
			 
			 if(! userInfo.isAlreadyLoggedIn()){
				 getRedirectStrategy().sendRedirect(request, response, "/index");
			}else{
				 getRedirectStrategy().sendRedirect(request, response, "/login");
			}
	        
         } catch (Exception e) {
             logger.error("Error in getting User()", e);
         } 
		
	}
}
