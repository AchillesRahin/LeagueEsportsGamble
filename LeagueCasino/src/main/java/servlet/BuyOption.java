package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import leaguecasino.registration.RegistrationController;
import leaguecasino.registration.User;
import leaguecasino.trading.TradingController;

/**
 * Servlet implementation class BuyOption
 */
public class BuyOption extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BuyOption() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String optionIDstr = request.getParameter("optionID");
		String amountBet = request.getParameter("amountBet");
		String teamChosen = request.getParameter("teamChosen");
		if (!isValid(optionIDstr, amountBet, teamChosen)){
			response.sendRedirect("leagueplatform.jsp");
		}
		else{
			int optionID = Integer.valueOf(request.getParameter("optionID"));
			int teamID = Integer.valueOf(request.getParameter("teamChosen"));
			int amount = Integer.valueOf(request.getParameter("amountBet"));
			TradingController tc = new TradingController();
			String username = (String) request.getSession().getAttribute("username");
			RegistrationController rc = new RegistrationController();
			User user = rc.getUser(username);
			tc.buyOption(teamID, optionID, amount, user.getUserID());
			user = rc.getUser(username);
			request.getSession().setAttribute("money", user.getMoney());
			response.sendRedirect("leagueplatform.jsp");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	private boolean isValid(String optionID, String amountBet, String teamChosen){
		if (!optionID.matches("[0-9]*") || !amountBet.matches("[0-9]*") || !teamChosen.matches("[0-9*]")){
			return false;
		}
		return true;
	}

}
