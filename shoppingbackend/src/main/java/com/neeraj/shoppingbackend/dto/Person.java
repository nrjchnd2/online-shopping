package com.neeraj.shoppingbackend.dto;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Person {
	@Id
	private int myId;

	public int getMyId() {
		return myId;
	}

	public void setMyId(int myId) {
		this.myId = myId;
	}

	public Person() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
