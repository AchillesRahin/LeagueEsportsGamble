package leaguecasino.trading;

public class Bet {
	
	private int BetOptionID;
	private int TradeOptionID;
	private int UserID;
	private int Team;
	private int Amount;
	private String DatePlaced;
	private String Status;
	private String myTeam;
	private String opposingTeam;
	private int profitAndLoss;
	
	public int getBetOptionID() {
		return BetOptionID;
	}
	public void setBetOptionID(int betOptionID) {
		BetOptionID = betOptionID;
	}
	public int getTradeOptionID() {
		return TradeOptionID;
	}
	public void setTradeOptionID(int tradeOptionID) {
		TradeOptionID = tradeOptionID;
	}
	public int getUserID() {
		return UserID;
	}
	public void setUserID(int userID) {
		UserID = userID;
	}
	public int getTeam() {
		return Team;
	}
	public void setTeam(int team) {
		Team = team;
	}
	public int getAmount() {
		return Amount;
	}
	public void setAmount(int amount) {
		Amount = amount;
	}
	public String getDatePlaced() {
		return DatePlaced;
	}
	public void setDatePlaced(String datePlaced) {
		DatePlaced = datePlaced;
	}
	public String getStatus() {
		return Status;
	}
	public void setStatus(String status) {
		Status = status;
	}
	public String getMyTeam() {
		return myTeam;
	}
	public void setMyTeam(String myTeam) {
		this.myTeam = myTeam;
	}
	public String getOpposingTeam() {
		return opposingTeam;
	}
	public void setOpposingTeam(String opposingTeam) {
		this.opposingTeam = opposingTeam;
	}
	public int getProfitAndLoss() {
		return profitAndLoss;
	}
	public void setProfitAndLoss(int profitAndLoss) {
		this.profitAndLoss = profitAndLoss;
	}
	
	
	

	
}
