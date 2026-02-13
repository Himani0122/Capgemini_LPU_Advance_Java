package Mockito_Implementation;

public class UserService {
	
	private UsersDao dao;
	
	public UserService(UsersDao dao) {
		this.dao=dao;
	}
	
	public String typeOfUser(int id) {
		Users user = dao.findById(id);
		
		if(user.getBalance()>0 && user.getBalance()<=10000) {
			return "New user";
		}
		
		else if(user.getBalance()>10000 && user.getBalance()<=50000) {
			return "Regular user";
		}
		else {
			return "Premium user";
		}
	}

}