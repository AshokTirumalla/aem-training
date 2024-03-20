package com.adobe.aem.guides.mysite.core.models;


import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


import javax.inject.Inject;


import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.Default;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.ChildResource;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


//@Model(adaptables =  Resource.class,
@Model(adaptables = SlingHttpServletRequest.class,
adapters = MultifieldComponent.class,
defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class MultifieldComponentImpl implements MultifieldComponent {
	
	private static final Logger LOG = LoggerFactory.getLogger(MultifieldComponentImpl.class);
	
	
	@Inject
	Resource booksinformation;
	
	
	@ChildResource
	Resource booksdetails;
	        
	//@Inject
	@ValueMapValue
	@Default(values = "Tirumalla")
	private String fname;
	
	//@Inject
	@ValueMapValue
	private String lname;
	
	//@Inject
	@ValueMapValue
	private String department;
	
	//@Inject
	@ValueMapValue
	private List<String> book;
	

   
	@Override
	public String getFirstName() {
		// TODO Auto-generated method stub
		LOG.info("Inside  getfirstname method", fname, " | ", lname);
		return fname;
	}

	@Override
	public String getLastName() {
		// TODO Auto-generated method stub
		return lname;
	}

	@Override
	public String getDepartment() {
		// TODO Auto-generated method stub
		return department;
	}

	@Override
	public List<String> getBook() {
		// TODO Auto-generated method stub
		
		if(book!=null) {
			LOG.info("Inside getbook method",book);
		return new ArrayList<String>(book);
		}else
		{
			LOG.info("Inside else",book);
			return Collections.emptyList();
		}
	}
	
	

	@Override
	public List<Map<String,String>> getBookDetails() {
		// TODO Auto-generated method stub
		List<Map<String, String>> mainMap = new ArrayList<Map<String,String>>();
		
		
		try {
		
		if(booksdetails !=null) {
			
			
			 for(Resource childResource : booksdetails.getChildren()) {
				 
				 Map<String,String> childMap= new HashMap<>();
				 childMap.put("bookname", childResource.getValueMap().get("bookname", String.class));
				 childMap.put("booksubject", childResource.getValueMap().get("booksubject", String.class));
				 childMap.put("publishyear", childResource.getValueMap().get("publishyear", String.class));
				 mainMap.add(childMap);
			 }
			
		}
		
		}catch(Exception e){
			
			LOG.info("Error in catch block");
		}
		
		
		return mainMap;
		
	}

	@Override
	public List<List<String>> getBookList() {
		// TODO Auto-generated method stub
		
		List<List<String>> mainList = new ArrayList<List<String>>();
		
		if(booksdetails !=null) {
			
			
			 for(Resource childResource : booksdetails.getChildren()) {
				 
				List<String> childList = new ArrayList<String>();
				childList.add(childResource.getValueMap().get("bookname", String.class));
				childList.add(childResource.getValueMap().get("booksubject", String.class));
				childList.add(childResource.getValueMap().get("publishyear", String.class));
				mainList.add(childList);
			 }
			
		}
		
		return mainList;
	}

	@Override
	public Resource getBooksInformation() {
		// TODO Auto-generated method stub
		return booksinformation;
	}
	
	
//	@Override
//	public List<Map<String, String>> getBookDetailsWithMap() {
//		// TODO Auto-generated method stub
//		LOG.info("Inside bookdeatilswithmap method");
//		List<Map<String, String>> bookDetailsMap = new ArrayList<>();
//		
//		Resource bookDetail = componentResource.getChild("booksdetailswithmap");
//		for(Resource bookinfo : bookDetail.getChildren()) {
//			Map<String,String> bookMap= new HashMap<>();
//			bookMap.put("bookname", bookinfo.getValueMap().get("bookname", String.class));
//			bookMap.put("booksubject", bookinfo.getValueMap().get("booksubject", String.class));
//			bookMap.put("publishyear", bookinfo.getValueMap().get("publishyear", String.class));
//			bookDetailsMap.add(bookMap);
//		}
//		
//		return bookDetailsMap;
//	}
	
	
	
	
	
	
	
	
	
	
	
	
	
//	@PostConstruct
//	public void init() {
//		LOG.info("Multifield executed");
//	}
//	

//	@Override
//	public Resource getBookDetails() {
//		// TODO Auto-generated method stub
//		LOG.info("Inside GET BOOKDETAILS METHOD", booksdetails);
//		return booksdetails;
//	}



	
	
}
