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
 * Servlet implementation class RegistrationServlet
 */
public class RegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegistrationServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		RegistrationController rc = new RegistrationController();
		User user = new User();
		String username = request.getParameter("username");
		String password = request.getParameter("pwd");
		String email = request.getParameter("email");
		String confirmpwd = request.getParameter("confirmpwd");
		user.setUsername(username);
		user.setPassword(password);
		user.setEmail(email);
		user.setMoney(100);
		if (!confirmpwd.equals(password))
		{
			HttpSession session = request.getSession();
			session.setAttribute("errorMessageRegister", "Password's do not match");
			response.sendRedirect("register.jsp");
		}
		else{
			boolean registerSuccess = rc.registerUser(user);
			if (registerSuccess)
			{
				response.sendRedirect("Login.jsp");
			}
			else{ 
				HttpSession session = request.getSession();
				session.setAttribute("errorMessageRegister", "Username already exists");
				response.sendRedirect("register.jsp");
			}
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
