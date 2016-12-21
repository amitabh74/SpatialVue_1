package com.rmsi.spatialvue.http;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionBindingListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;



public class UserInfo implements HttpSessionBindingListener {
	// All logins.
	private static Map<UserInfo, HttpSession> logins = new HashMap<UserInfo, HttpSession>();

    // Normal properties.
    private String username;
    private boolean unbind;
    private boolean alreadyLoggedIn;
    
    
    public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
	
	 public boolean isAlreadyLoggedIn() {
			return alreadyLoggedIn;
	}
	    
	public boolean isUnbind() {
		return unbind;
	}

	public void setUnbind(boolean unbind) {
		this.unbind = unbind;
	}


	@Override
    public boolean equals(Object other) {
        return (other instanceof UserInfo) && (username != null) ? username.equals(((UserInfo) other).username) : (other == this);
    }

    @Override
    public int hashCode() {
        return (username != null) ? (this.getClass().hashCode() + username.hashCode()) : super.hashCode();
    }

    @Override
    public void valueBound(HttpSessionBindingEvent event) {
    	
    	 HttpSession oldSession = logins.get(this);
    	    if (oldSession != null) {
    	    	 System.out.println("Session Id: " + oldSession.getId());
    	    	 alreadyLoggedIn = true;
    	    } else {
    	    	 System.out.println("New Session");
    	    	 alreadyLoggedIn = false;
    	      logins.put(this, event.getSession());
    	    }
    	
    }

    @Override
    public void valueUnbound(HttpSessionBindingEvent event) {
    	
    	if(unbind){
		    System.out.println("unbounding .........");
		    logins.remove(this);
    	}
    	
    }
    
}
