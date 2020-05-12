package com.project.copypasteapi.Bean;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class CopyPasteBean {
	
	@Id
	private String uniqueCodeUrl = "";
	private String lastcontent;
	private String dateandTime;
	
	private String name;
	
	@ElementCollection
	private List<UserData> contentList = new ArrayList<UserData>();

	public String getUniqueCodeUrl() {
		return uniqueCodeUrl;
	}

	public void setUniqueCodeUrl(String uniqueCodeUrl) {
		this.uniqueCodeUrl = uniqueCodeUrl;
	}

	public String getLastcontent() {
		return lastcontent;
	}

	public void setLastcontent(String lastcontent) {
		this.lastcontent = lastcontent;
	}

	public String getDateandTime() {
		return dateandTime;
	}

	public void setDateandTime(String dateandTime) {
		this.dateandTime = dateandTime;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<UserData> getContentList() {
		return contentList;
	}

	public void setContentList(List<UserData> contentList) {
		this.contentList = contentList;
	}

	

	

}
