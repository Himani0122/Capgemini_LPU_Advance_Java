package TestMockitoImplementation;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import Mockito_Implementation.UserService;
import Mockito_Implementation.Users;
import Mockito_Implementation.UsersDao;

@ExtendWith(MockitoExtension.class)  //This notation is used in industry
public class UserServiceTest {
	
	    @Mock
	    UsersDao daomock;  //Either we can do this or we can do do UserDao dao = mock(UserDao.class); But this annotation is used in industry
	    
	    
	    @InjectMocks
	    UserService service;  //Either we can create the variable where we will inject out mock data with @InjectMocks annotation
	    
	    @Test
	    public void testUserType() {
	        //Create mock object
	        //UserDao daomock = mock(UserDao.class);
	        
	        //Create fake objects: it will work as row inside the table
	        Users fakeObject1 = new Users();
	        fakeObject1.setId(1);
	        fakeObject1.setName("Allen");
	        fakeObject1.setBalance(9000);
	        //Now we will tell that what the Fake database should return when we give a value to it
	        when(daomock.findById(1)).thenReturn(fakeObject1);
	        
	        //Creating another row in fake database
	        Users fakeObject2 = new Users();
	        fakeObject2.setId(3);
	        fakeObject2.setName("Viller");
	        fakeObject2.setBalance(250000);
	        when(daomock.findById(3)).thenReturn(fakeObject2);
	        
	        //UserService service = new UserService(daomock);
	        String res1 = service.typeOfUser(1);
	        String res2 = service.typeOfUser(3);
	        
	       //assertEquals("New user", res1); 
	        assertEquals("Premium user", res2);
	}

}