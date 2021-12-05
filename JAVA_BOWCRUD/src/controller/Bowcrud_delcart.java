package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.CartItem;
import model.item;


@WebServlet("/deleteCart")
public class Bowcrud_delcart extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public Bowcrud_delcart() {
        super();

    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


		item item = new item();
		HttpSession session = request.getSession();
		List<item> list =(List<item>) session.getAttribute("cart");
		
		String id = request.getParameter("id");
			int delete = Integer.parseInt(request.getParameter("delete"));
			if(delete==1) {
				for(item itemPro:list) {
					if(itemPro.getId().equalsIgnoreCase(id)) {			
						item = itemPro;
					}
				}
				list.remove(item);
				response.sendRedirect(request.getContextPath()+"/cartPage");
			}else {
				session.removeAttribute("cart");
				response.sendRedirect(request.getContextPath()+"/cartPage");
			}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
