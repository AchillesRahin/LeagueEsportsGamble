package Platform;

import java.util.ArrayList;
import java.util.List;

import leaguecasino.registration.RegistrationController;
import leaguecasino.registration.User;
import leaguecasino.trading.Bet;
import leaguecasino.trading.TradingController;
import leaguecasino.trading.TradingOption;

public class PlatformTester {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TradingController tc = new TradingController();
		TradingOption to = new TradingOption();
		//tc.buyOption(1, 1, 20, 1);
		RegistrationController rc = new RegistrationController();
		List<User> test = rc.getHighScores(3);
		for (User user : test){
			System.out.println(user.getUsername());
		}
		//ArrayList<Bet> test = tc.getAllBets(3, "completed");
		//System.out.println(test.get(0).getBetOptionID());
	}

}
