/**
 * 
 */
package com.tsmc.ecp.model;

/**
 *
 */
public class User {


    private Integer id;
    private String name;
    
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	/**
	 * 
	 */
	public User(int i, String string) {
		this.id = i; 
		this.name = string;
	}


}
