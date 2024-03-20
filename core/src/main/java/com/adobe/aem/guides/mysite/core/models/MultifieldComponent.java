package com.adobe.aem.guides.mysite.core.models;

import java.util.List;
import java.util.Map;

import org.apache.sling.api.resource.Resource;

public interface MultifieldComponent {

	String getFirstName();
	String getLastName();
	String getDepartment();
	List<String> getBook();
	List<Map<String, String>> getBookDetails();
	List<List<String>> getBookList();
	
	Resource getBooksInformation();
	//List<Map<String, String>> getBookDetailsWithMap();
	
	
}
