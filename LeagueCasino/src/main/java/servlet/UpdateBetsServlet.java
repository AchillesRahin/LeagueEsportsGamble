package servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import leaguecasino.registration.RegistrationController;
import leaguecasino.registration.User;
import leaguecasino.trading.TradingController;
import leaguecasino.trading.TradingOption;

/**
 * Servlet implementation class UpdateBetsServlet
 */
public class UpdateBetsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateBetsServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		TradingController tc = new TradingController();
		RegistrationController rc = new RegistrationController();
		HttpSession session = request.getSession();
		String username = (String) session.getAttribute("username");
		User user = rc.getUser(username);
		int money = user.getMoney();
		session.setAttribute("money", money);
		session.setAttribute("currentBets", tc.getAllBets(user.getUserID(), "current"));
		session.setAttribute("pastBets", tc.getAllBets(user.getUserID(), "past"));
		response.sendRedirect("betoptions.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
