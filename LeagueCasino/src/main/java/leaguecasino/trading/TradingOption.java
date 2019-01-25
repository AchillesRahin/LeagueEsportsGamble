package leaguecasino.trading;

public class TradingOption {

	private Integer LeagueOptionID;
	private String TeamOne;
	private Integer OnePoints;
	private String TeamTwo;
	private Integer TwoPoints;
	private String Status;
	
	public Integer getLeagueOptionID() {
		return LeagueOptionID;
	}
	public void setLeagueOptionID(int leagueOptionID) {
		LeagueOptionID = leagueOptionID;
	}
	public String getTeamOne() {
		return TeamOne;
	}
	public void setTeamOne(String teamOne) {
		TeamOne = teamOne;
	}
	public Integer getOnePoints() {
		return OnePoints;
	}
	public void setOnePoints(int onePoints) {
		OnePoints = onePoints;
	}
	public String getTeamTwo() {
		return TeamTwo;
	}
	public void setTeamTwo(String teamTwo) {
		TeamTwo = teamTwo;
	}
	public Integer getTwoPoints() {
		return TwoPoints;
	}
	public void setTwoPoints(int twoPoints) {
		TwoPoints = twoPoints;
	}
	public String getStatus() {
		return Status;
	}
	public void setStatus(String status) {
		Status = status;
	}
	
	
}
