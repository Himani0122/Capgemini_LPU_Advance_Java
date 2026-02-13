package Mockito_practice;

public class UserService {
	User_Dao_Driver u;
	public UserService(User_Dao_Driver u){
		this.u=u;
	}
	public String typeOfUser(int id) {
		User_Dao user = u.findById(id);
		if(user.getBalance()>0 && user.getBalance()<=30000) {
			return "New User";
		}else if(user.getBalance()>30000 && user.getBalance()<=50000) {
			return "Regular User";
		}else {
			return "Premium User";
		}
	}
}
