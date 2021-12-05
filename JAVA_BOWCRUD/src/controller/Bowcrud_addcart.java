package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Product;
import model.CartItem;
import model.item;

/**
 * Servlet implementation class cart
 */
@WebServlet("/cart")
public class Bowcrud_addcart extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Bowcrud_addcart() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String id = request.getParameter("id");
		CartItem cart = new CartItem();
		
		HttpSession session = request.getSession();
		if(session.getAttribute("cart")==null) {
			
			List<item> list = new ArrayList<item>();
			list.add(cart.addPro(id));
			session.setAttribute("cart", list);
			
		}
		else {
			List<item> list = (List<item>) session.getAttribute("cart");
			session.setAttribute("cart", cart.updateCart(id, list));
		}
		
		response.sendRedirect(request.getContextPath()+"/home");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
