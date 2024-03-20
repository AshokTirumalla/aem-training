package com.adobe.aem.guides.mysite.core.models;

import javax.inject.Inject;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.Model;

@Model(adaptables = Resource.class)
public class BookDetailsModel {
	
	@Inject
	String bookname;
	
	@Inject
	String booksubject;
	
	@Inject
	String publishyear;
	
	public String getBookName() {
		return bookname;
	}
	public String getBookSubject() {
		return booksubject;
	}
	public String getPublishYear() {
		return publishyear;
	}
	

}
