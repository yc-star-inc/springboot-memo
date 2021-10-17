package com.tsmc.ecp.controller;

import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith (SpringRunner.class)
@SpringBootTest
public class TimeComparisonTest {

	
	public void TimeComparison( ) {
		
		List<User> users = getAllTestUsers();
		
		List<User> sortedUsers = users.stream()
				  .sorted(Comparator.comparing(User::getCreatedOn).reversed())
				  .collect(Collectors.toList());
	}
	
	
	
	/// https://www.codebyamir.com/blog/sort-list-of-objects-by-field-java
	
	private List<User> getAllTestUsers() {
		// TODO Auto-generated method stub
		return null;
	}



	public class User {
		  private long id;
		  private String email;
		  private Date createdOn;
		    
		  // other getters and setters omitted
		  
		  public Date getCreatedOn() {
		    return createdOn;
		  }
		  
		  public void setCreatedOn(Date createdOn) {
		    this.createdOn = createdOn;
		  }
		}
	
	
}
