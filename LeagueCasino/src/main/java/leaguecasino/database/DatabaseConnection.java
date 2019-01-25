package leaguecasino.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import leaguecasino.registration.User;
import leaguecasino.trading.Bet;
import leaguecasino.trading.TradingOption;


public class DatabaseConnection {
	
	Connection conn;
	private static final Logger LOGGER = Logger.getLogger(DatabaseConnection.class.getName());
	private static String jdbcUrl;
	
	public DatabaseConnection(){
		String dbName = "leaguecasino";
	    String userName = "root";
	    String password = "password1";
	    String hostname = "localhost";
	    String port = "3306";
	    jdbcUrl = "jdbc:mysql://" + hostname + ":" + port + "/" + dbName + "?user=" + userName + "&password=" + password + "&useSSL=false";
	}

	public void registerUser(User user) {
		user.setUsername(user.getUsername().toLowerCase());
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e2) {
			System.out.println("driver missing");
			e2.printStackTrace();
		}
		try {
			conn = DriverManager.getConnection(jdbcUrl);
			String query = "INSERT INTO user_info (UserID, Username, Password, Email, Money) VALUES (null, ?, ?, ?, 100)";
			PreparedStatement preparedStmt = conn.prepareStatement(query);
			preparedStmt.setString(1, user.getUsername());
			preparedStmt.setString(2, user.getPassword());
			preparedStmt.setString(3, user.getEmail());
			
			preparedStmt.execute();
			LOGGER.info("registered username " + user.getUsername());
			
			conn.close();
		} catch (SQLException e) {
			if (conn != null)
			{
				try {
					conn.close();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
			e.printStackTrace();
		}
		
	}
	
	public List<User> getAllUsers(){
		List<User> userList = new ArrayList<User>();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e2) {
			System.out.println("driver missing");
			e2.printStackTrace();
		}
		
		try {
			conn = DriverManager.getConnection(jdbcUrl);
			Statement st = conn.createStatement();
			String query = "SELECT * FROM user_info";
			ResultSet rs = st.executeQuery(query);
			LOGGER.info("retrieving all user data");
			while (rs.next()){
				User current = new User();
				current.setUserID(rs.getInt("UserID"));
				current.setEmail(rs.getString("Email"));
				current.setMoney(rs.getInt("Money"));
				current.setUsername(rs.getString("Username"));
				current.setPassword(rs.getString("Password"));
				userList.add(current);
			}

			conn.close();
		} catch (SQLException e) {
			if (conn != null)
			{
				try {
					conn.close();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
			e.printStackTrace();
		}
		return userList;
	}
	
	public User getUser(String username) {
		User user = new User();
		username = username.toLowerCase();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e2) {
			System.out.println("driver missing");
			e2.printStackTrace();
		}
		try {
			conn = DriverManager.getConnection(jdbcUrl);
			Statement st = conn.createStatement();
			String query = "SELECT * FROM user_info WHERE Username = '" + username + "'";
			ResultSet rs = st.executeQuery(query);
			if (!rs.next())
			{
				user.setUserID(0);
				LOGGER.info("user does not exist");
			}
			else
			{
				do
				{
					user.setUserID(rs.getInt("UserID"));
					user.setEmail(rs.getString("Email"));
					user.setMoney(rs.getInt("Money"));
					user.setUsername(rs.getString("Username"));
					user.setPassword(rs.getString("Password"));
					user.setUserLoggedIn(rs.getBoolean("IsUserLoggedIn"));
				}while (rs.next());
			}

			conn.close();
		} catch (SQLException e) {
			if (conn != null)
			{
				try {
					conn.close();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
			e.printStackTrace();
		}
		return user;
	}

	public ArrayList<TradingOption> getAllTradingOptions() {
		
		ArrayList<TradingOption> tradingOptions = new ArrayList<TradingOption>();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e2) {
			System.out.println("driver missing");
			e2.printStackTrace();
		}
		try {
			conn = DriverManager.getConnection(jdbcUrl);
			Statement st = conn.createStatement();
			String query = "SELECT * FROM leagueoptions WHERE status='ongoing'";
			ResultSet rs = st.executeQuery(query);
			
			while (rs.next())
			{
				TradingOption to = new TradingOption();
				to.setLeagueOptionID(rs.getInt("LeagueOptionID"));
				to.setTeamOne(rs.getString("TeamOne"));
				to.setOnePoints(rs.getInt("OnePoints"));
				to.setTeamTwo(rs.getString("TeamTwo"));
				to.setTwoPoints(rs.getInt("TwoPoints"));
				tradingOptions.add(to);
			}

			conn.close();
		} catch (SQLException e) {
			if (conn != null)
			{
				try {
					conn.close();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
			e.printStackTrace();
		}
		return tradingOptions;
	}

	public void addTradingOption(TradingOption to) {
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e2) {
			System.out.println("driver missing");
			e2.printStackTrace();
		}
		try {
			conn = DriverManager.getConnection(jdbcUrl);
			String query = "INSERT INTO leagueoptions (LeagueOptionID, TeamOne, OnePoints, TeamTwo, TwoPoints, Status) VALUES (null, ?, ?, ?, ?, ?)";
			PreparedStatement preparedStmt = conn.prepareStatement(query);
			preparedStmt.setString(1, to.getTeamOne());
			preparedStmt.setInt(2, to.getOnePoints());
			preparedStmt.setString(3, to.getTeamTwo());
			preparedStmt.setInt(4, to.getTwoPoints());
			preparedStmt.setString(5, "ongoing");
			preparedStmt.execute();
			LOGGER.info("added tradingoption " + to.getLeagueOptionID() + " " + to.getTeamOne() + " " + to.getTeamTwo());
			
			conn.close();
		} catch (SQLException e) {
			if (conn != null)
			{
				try {
					conn.close();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
			e.printStackTrace();
		}
		
	}

	public void buyOption(int team, int tradingOptionID, int amount, int userID) {
		TradingOption to = getTradingOption(tradingOptionID);
		String myTeam;
		String opposingTeam;
		if (team == 1){
			myTeam = to.getTeamOne();
			opposingTeam = to.getTeamTwo();
		}
		else{
			myTeam = to.getTeamTwo();
			opposingTeam = to.getTeamOne();
		}
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e2) {
			System.out.println("driver missing");
			e2.printStackTrace();
		}
		try {
			conn = DriverManager.getConnection(jdbcUrl);
			String query = "INSERT INTO betoptions (BetOptionID, TradeOptionID, Team, Amount, DatePlaced, Status, UserID, MyTeam, OpposingTeam) VALUES (null, ?, ?, ?, ?, ?, ?, ?, ?)";
			PreparedStatement preparedStmt = conn.prepareStatement(query);
			preparedStmt.setInt(1, tradingOptionID);
			preparedStmt.setInt(2, team);
			preparedStmt.setInt(3, amount);
			preparedStmt.setString(4, "date");
			preparedStmt.setString(5, "ongoing");
			preparedStmt.setInt(6, userID);
			preparedStmt.setString(7, myTeam);
			preparedStmt.setString(8, opposingTeam);
			preparedStmt.execute();
			LOGGER.info("added betoptions " + tradingOptionID + " " + team + " " + amount);
			
			conn.close();
		} catch (SQLException e) {
			if (conn != null)
			{
				try {
					conn.close();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
			e.printStackTrace();
		}
		
	}

	public void setWinner(int tradingOptionID, int winningTeam) {
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e2) {
			System.out.println("driver missing");
			e2.printStackTrace();
		}
		try {
			conn = DriverManager.getConnection(jdbcUrl);
			String query = "UPDATE leagueoptions SET Status = 'complete', Winner = ? WHERE LeagueOptionID = ?";
			PreparedStatement preparedStmt = conn.prepareStatement(query);
			preparedStmt.setInt(1, winningTeam);
		    preparedStmt.setInt(2, tradingOptionID);
			preparedStmt.execute();

			conn.close();

			conn.close();
		} catch (SQLException e) {
			if (conn != null)
			{
				try {
					conn.close();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
			e.printStackTrace();
		}
		
	}

	public ArrayList<Integer> getBetIDs(int tradingOptionID) {
		ArrayList<Integer> bets = new ArrayList<Integer>();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e2) {
			System.out.println("driver missing");
			e2.printStackTrace();
		}
		try {
			conn = DriverManager.getConnection(jdbcUrl);
			Statement st = conn.createStatement();
			String query = "SELECT * FROM betoptions WHERE TradeOptionID = " + tradingOptionID;
			ResultSet rs = st.executeQuery(query);
			
			while (rs.next())
			{
				bets.add(rs.getInt("BetOptionID"));
			}

			conn.close();
		} catch (SQLException e) {
			if (conn != null)
			{
				try {
					conn.close();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
			e.printStackTrace();
		}
		return bets;
	}

	public Bet getBet(int betID) {
		Bet bet = new Bet();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e2) {
			System.out.println("driver missing");
			e2.printStackTrace();
		}
		try {
			conn = DriverManager.getConnection(jdbcUrl);
			Statement st = conn.createStatement();
			String query = "SELECT * FROM betoptions WHERE BetOptionID = " + betID;
			ResultSet rs = st.executeQuery(query);
			
			while (rs.next())
			{
				bet.setBetOptionID(rs.getInt("BetOptionID"));
				bet.setTradeOptionID(rs.getInt("TradeOptionID"));
				bet.setUserID(rs.getInt("UserID"));
				bet.setTeam(rs.getInt("Team"));
				bet.setAmount(rs.getInt("Amount"));
				bet.setDatePlaced(rs.getString("DatePlaced"));
				bet.setStatus(rs.getString("Status"));
				bet.setMyTeam(rs.getString("MyTeam"));
				bet.setOpposingTeam(rs.getString("OpposingTeam"));
				bet.setProfitAndLoss(rs.getInt("PandL"));
			}

			conn.close();
		} catch (SQLException e) {
			if (conn != null)
			{
				try {
					conn.close();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
			e.printStackTrace();
		}
		return bet;
	}

	public void updateBet(Bet bet) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e2) {
			System.out.println("driver missing");
			e2.printStackTrace();
		}
		try {
			conn = DriverManager.getConnection(jdbcUrl);
			String query = "UPDATE betoptions SET TradeOptionID = ?, UserID = ?, Team = ?, Amount = ?, DatePlaced = ?, Status = ?, MyTeam = ?, OpposingTeam = ?, PandL = ? WHERE BetOptionID = ?";
			PreparedStatement preparedStmt = conn.prepareStatement(query);
			preparedStmt.setInt(1, bet.getTradeOptionID());
		    preparedStmt.setInt(2, bet.getUserID());
		    preparedStmt.setInt(3, bet.getTeam());
		    preparedStmt.setInt(4, bet.getAmount());
		    preparedStmt.setString(5, bet.getDatePlaced());
		    preparedStmt.setString(6, bet.getStatus());
		    preparedStmt.setString(7, bet.getMyTeam());
		    preparedStmt.setString(8, bet.getOpposingTeam());
		    preparedStmt.setInt(9, bet.getProfitAndLoss());
		    preparedStmt.setInt(10, bet.getBetOptionID());
			preparedStmt.execute();

			conn.close();

		} catch (SQLException e) {
			if (conn != null)
			{
				try {
					conn.close();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
			e.printStackTrace();
		}
		
	}

	public TradingOption getTradingOption(int tradingOptionID) {
		TradingOption to = new TradingOption();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e2) {
			System.out.println("driver missing");
			e2.printStackTrace();
		}
		try {
			conn = DriverManager.getConnection(jdbcUrl);
			Statement st = conn.createStatement();
			String query = "SELECT * FROM leagueoptions WHERE LeagueOptionID = " + tradingOptionID;
			ResultSet rs = st.executeQuery(query);
			
			while (rs.next())
			{
				to.setLeagueOptionID(rs.getInt("LeagueOptionID"));
				to.setTeamOne(rs.getString("TeamOne"));
				to.setTeamTwo(rs.getString("TeamTwo"));
				to.setOnePoints(rs.getInt("OnePoints"));
				to.setTwoPoints(rs.getInt("TwoPoints"));
				to.setStatus(rs.getString("Status"));
			}

			conn.close();
		} catch (SQLException e) {
			if (conn != null)
			{
				try {
					conn.close();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
			e.printStackTrace();
		}
		return to;
	}

	public User getUser(int userID) {
		User user = new User();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e2) {
			System.out.println("driver missing");
			e2.printStackTrace();
		}
		try {
			conn = DriverManager.getConnection(jdbcUrl);
			Statement st = conn.createStatement();
			String query = "SELECT * FROM user_info WHERE UserID = " + userID;
			ResultSet rs = st.executeQuery(query);
			if (!rs.next())
			{
				user.setUserID(0);
				LOGGER.info("user does not exist");
			}
			else
			{
				do
				{
					user.setUserID(rs.getInt("UserID"));
					user.setEmail(rs.getString("Email"));
					user.setMoney(rs.getInt("Money"));
					user.setUsername(rs.getString("Username"));
					user.setPassword(rs.getString("Password"));
					user.setUserLoggedIn(rs.getBoolean("IsUserLoggedIn"));
				}while (rs.next());
			}

			conn.close();
		} catch (SQLException e) {
			if (conn != null)
			{
				try {
					conn.close();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
			e.printStackTrace();
		}
		return user;
	}

	public void updateUser(User user) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e2) {
			System.out.println("driver missing");
			e2.printStackTrace();
		}
		try {
			conn = DriverManager.getConnection(jdbcUrl);
			String query = "UPDATE user_info SET Username = ?, Password = ?, Money = ?, Email = ?, IsUserLoggedIn = ? WHERE UserID = ?";
			PreparedStatement preparedStmt = conn.prepareStatement(query);
			preparedStmt.setString(1, user.getUsername());
			preparedStmt.setString(2, user.getPassword());
			preparedStmt.setInt(3, user.getMoney());
			preparedStmt.setString(4, user.getEmail());
			preparedStmt.setBoolean(5, user.getIsUserLoggedIn());
			preparedStmt.setInt(6, user.getUserID());
			preparedStmt.execute();

			conn.close();

			conn.close();
		} catch (SQLException e) {
			if (conn != null)
			{
				try {
					conn.close();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
			e.printStackTrace();
		}
		
	}

	public ArrayList<Bet> getAllBets(int userID, String status) {
		ArrayList<Bet> allBets = new ArrayList<Bet>();
	
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e2) {
			System.out.println("driver missing");
			e2.printStackTrace();
		}
		try {
			conn = DriverManager.getConnection(jdbcUrl);
			Statement st = conn.createStatement();
			String query;
			if (status.equals("past"))
			{
				query = "SELECT * FROM betoptions WHERE UserID = " + userID + " AND ( status = 'won' OR status = 'lost' )";
			}
			else{
				query = "SELECT * FROM betoptions WHERE UserID = " + userID + " AND status = 'ongoing'";
			}
			ResultSet rs = st.executeQuery(query);
			
			while (rs.next()){
				Bet bet = new Bet();
				bet.setAmount(rs.getInt("Amount"));
				bet.setBetOptionID(rs.getInt("BetOptionID"));
				bet.setTradeOptionID(rs.getInt("TradeOptionID"));
				bet.setUserID(userID);
				bet.setTeam(rs.getInt("Team"));
				bet.setDatePlaced(rs.getString("DatePlaced"));
				bet.setStatus(rs.getString("Status"));
				bet.setMyTeam(rs.getString("MyTeam"));
				bet.setOpposingTeam(rs.getString("OpposingTeam"));
				bet.setProfitAndLoss(rs.getInt("PandL"));
				allBets.add(bet);
			}

			conn.close();
		} catch (SQLException e) {
			if (conn != null)
			{
				try {
					conn.close();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
			e.printStackTrace();
		}
		
		return allBets;
		
	}
}
