package TestMockitoImplementation;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;

import Mockito_Implementation.UsersDao;
import Mockito_Implementation.UserService;
import Mockito_Implementation.Users;

public class UserServiceTest {
	
	@Test
	public void testUserType() {
		//Create mock object
		UsersDao daomock = mock(UsersDao.class);
		
		//Create fake objects: it will work as row inside the table
		Users fakeObject1 = new Users();
		fakeObject1.setId(1);
		fakeObject1.setName("Allen");
		fakeObject1.setBalance(9000);
		//Now we will tell that what the Fake database should return when we give a value to it
		when(daomock.findById(1)).thenReturn(fakeObject1);
		
		//Creating another row in fake database
		Users fakeObject2 = new Users();
		fakeObject2.setId(2);
		fakeObject2.setName("Miller");
		fakeObject2.setBalance(15000);
		when(daomock.findById(2)).thenReturn(fakeObject2);
		
		UserService service = new UserService(daomock);
		String res = service.typeOfUser(1);
		
		assertEquals("New user", res); 
		
	}

}