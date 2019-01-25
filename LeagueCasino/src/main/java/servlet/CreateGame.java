package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import leaguecasino.trading.TradingController;
import leaguecasino.trading.TradingOption;

/**
 * Servlet implementation class CreateGame
 */
public class CreateGame extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateGame() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		TradingController tc = new TradingController();
		TradingOption to = new TradingOption();
		String teamOneName = request.getParameter("teamOneName");
		String teamTwoName = request.getParameter("teamTwoName");
		String teamOneOdds = request.getParameter("teamOneOdds");
		String teamTwoOdds = request.getParameter("teamTwoOdds");
		to.setTeamOne(teamOneName);
		to.setTeamTwo(teamTwoName);
		to.setOnePoints(Integer.valueOf(teamOneOdds));
		to.setTwoPoints(Integer.valueOf(teamTwoOdds));
		tc.addTradingOption(to);
		response.sendRedirect("adminpage.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
