package com.project.copypasteapi.Bean;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class CopyPasteBean {
	
	@Id
	private String uniqueCodeUrl = "";
	private String lastcontent;
	private String dateandTime;
	
	@ElementCollection
	private List<String> contentList = new ArrayList<String>();

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

	public List<String> getContentList() {
		return contentList;
	}

	public void setContentList(List<String> contentList) {
		this.contentList = contentList;
	}
	

}
