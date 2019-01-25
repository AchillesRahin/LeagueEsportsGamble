package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import leaguecasino.registration.RegistrationController;
import leaguecasino.registration.User;

/**
 * Servlet implementation class UpdateHighscores
 */
public class UpdateHighscores extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateHighscores() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RegistrationController rc = new RegistrationController();
		List<User> highscores = rc.getHighScores(2);
		HttpSession session = request.getSession();
		String username = (String) session.getAttribute("username");
		User user = rc.getUser(username);
		int money = user.getMoney();
		session.setAttribute("money", money);
		session.setAttribute("currentHighscores", highscores);
		response.sendRedirect("highscores.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
