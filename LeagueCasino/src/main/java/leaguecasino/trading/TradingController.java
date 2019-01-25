package leaguecasino.trading;

import java.util.ArrayList;

import leaguecasino.database.DatabaseConnection;
import leaguecasino.registration.User;

public class TradingController {
	DatabaseConnection dbconn;
	
	public TradingController() {
		dbconn = new DatabaseConnection();
	}
	
	public ArrayList<TradingOption> getAllTradingOptions(){
		return dbconn.getAllTradingOptions();
	}
	
	public void addTradingOption(TradingOption to){
		dbconn.addTradingOption(to);
	}
	
	public boolean buyOption(int team, int tradingOptionID, int amount, int userID){
		User user = dbconn.getUser(userID);
		if (amount > user.getMoney()){
			return false;
		}
		dbconn.buyOption(team, tradingOptionID, amount, userID);
		int money = user.getMoney();
		money -= amount;
		user.setMoney(money);
		dbconn.updateUser(user);
		return true;
	}
	
	public String setWinner(int tradingOptionID, int winningTeam){
		TradingOption temp = dbconn.getTradingOption(tradingOptionID);
		if (temp.getStatus().equals("complete")){
			return "winner already set returning error";
		}
		dbconn.setWinner( tradingOptionID,  winningTeam);
		ArrayList<Integer> bets = dbconn.getBetIDs(tradingOptionID);
		for (int i = 0; i < bets.size(); i++){
			Bet bet = dbconn.getBet(bets.get(i));
			if (bet.getTeam() == winningTeam){
				bet.setStatus("won");
				TradingOption to = dbconn.getTradingOption(tradingOptionID);
				int onePoints = to.getOnePoints();
				int twoPoints = to.getTwoPoints();
				int amountBet = bet.getAmount();
				int earned = winningTeam == 1 ? amountBet * twoPoints / onePoints + amountBet : amountBet * onePoints / twoPoints + amountBet;
				User user = dbconn.getUser(bet.getUserID());
				int money = user.getMoney();
				bet.setProfitAndLoss(earned);
				dbconn.updateBet(bet);
				money += earned;
				user.setMoney(money);
				dbconn.updateUser(user);
			}
			else {
				bet.setStatus("lost");
				bet.setProfitAndLoss(bet.getAmount() * -1);
				dbconn.updateBet(bet);
			}
			
		}
		return "winner is set completed good";
	}
	
	public ArrayList<Bet> getAllBets(int userID, String status){
		return dbconn.getAllBets(userID, status);
	}
}
