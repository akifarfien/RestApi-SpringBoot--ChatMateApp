package com.project.copypasteapi.Bean;

import javax.persistence.Embeddable;

@Embeddable
public class UserData {
	

	private String name;
	private String textmssg;
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTextmssg() {
		return textmssg;
	}
	public void setTextmssg(String textmssg) {
		this.textmssg = textmssg;
	}
	
	
	
	

}
