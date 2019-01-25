package leaguecasino.registration;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import leaguecasino.database.DatabaseConnection;

public class RegistrationController {

	DatabaseConnection dbconn;
	
	public RegistrationController() {
		dbconn = new DatabaseConnection();
		
	}
	public User getUser(String username)
	{
		return dbconn.getUser(username);
	}
	
	public boolean registerUser(User user)
	{
		if (user.getUsername() == null){
			return false;
		}
		if (dbconn.getUser(user.getUsername()).getUserID() == 0)
		{
			dbconn.registerUser(user);
			return true;
		}
		else
		{
			return false;
		}
	}
	
	public List<User> getAllUsers(){
		return dbconn.getAllUsers();
	}
	
	public List<User> getHighScores(int num){
		List<User> userList = getAllUsers();
		Comparator<User> comparator = new Comparator<User>(){

			public int compare(User arg0, User arg1) {
				
				if (arg0.getMoney() > arg1.getMoney()){
					return -1;
				}
				else if (arg1.getMoney() > arg0.getMoney()){
					return 1;
				}
				else {
					return 0;
				}
			}
			
		};
		Collections.sort(userList, comparator);
		List<User> highScores = new ArrayList<User>();
		for (int i = 0; i < userList.size() && i < num; i++){
			highScores.add(userList.get(i));
		}
		return highScores;
	}
}
