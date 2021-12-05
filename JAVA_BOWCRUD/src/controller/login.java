package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Admin;


@WebServlet("/login")
public class login extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public login() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("WEB-INF/jsp/admin/login.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Admin admin = new Admin();
		
		String username = request.getParameter("Username");
		String pass = request.getParameter("Password");
		if(username.isEmpty()||pass.isEmpty()) {
			request.setAttribute("ERROR", "Username/Password not empty!!!!");
			request.getRequestDispatcher("WEB-INF/jsp/admin/login.jsp").forward(request, response);
			return;
		}
		Admin user = admin.login(username, pass);
		if(user.getUsername()==null) {
			request.setAttribute("ERROR", "Username/Password not found!!!");
			request.getRequestDispatcher("WEB-INF/jsp/admin/login.jsp").forward(request, response);
			return;
		}
		if(username.equals(user.getUsername())&&pass.equals(user.getPassword())) {
			HttpSession session = request.getSession();
			session.setAttribute("username", username);
			response.sendRedirect(request.getContextPath()+"/addProduct");
		}
	}

}
