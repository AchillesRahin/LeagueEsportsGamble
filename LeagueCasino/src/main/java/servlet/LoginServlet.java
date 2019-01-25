package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import leaguecasino.registration.RegistrationController;
import leaguecasino.registration.User;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String username = request.getParameter("username");
		String password = request.getParameter("pwd");
		RegistrationController rc = new RegistrationController();
		User user = rc.getUser(username);
		if (username.equals("gilgamesh")){
			if (password.equals("gilgamesh")){
				HttpSession session = request.getSession();
				session.setAttribute("username", "gilgamesh");
				response.sendRedirect("adminpage.jsp");
			}
		}
		else if (user.getUserID() == 0){
			HttpSession session = request.getSession();
			session.setAttribute("errorMessageLogin", "Username does not exist");
			response.sendRedirect("Login.jsp");
		}
		else if(!password.equals(user.getPassword()))
		{
			HttpSession session = request.getSession();
			session.setAttribute("errorMessageLogin", "Password is incorrect");
			response.sendRedirect("Login.jsp");
		}
		else{
			HttpSession session = request.getSession();
			session.setAttribute("user", user);
			session.setAttribute("username", username);
			session.setAttribute("money", user.getMoney());
			session.setAttribute("isUserLoggedIn", "loggedIn");
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

}
