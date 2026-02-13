package com.prac.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import Mockito_practice.UserService;
import Mockito_practice.User_Dao_Driver;

public class UserServiceTest {
	@Test
	public void testgetTypeOfCustomer(){
		User_Dao_Driver u = new  User_Dao_Driver(); //because service layer is using its reference
		UserService user = new UserService(u);
		String actualres = user.typeOfUser(101);
		assertEquals("New User",actualres);
	}
}
