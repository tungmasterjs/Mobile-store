package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Product;

/**
 * Servlet implementation class addProduct
 */
@WebServlet("/addProduct")
public class Bowcrud_add extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Bowcrud_add() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		HttpSession session = request.getSession();
		if(request.getParameter("logout")==null) {
			if(session.getAttribute("username")==null) {
				request.getRequestDispatcher("WEB-INF/jsp/admin/login.jsp").forward(request, response);
			}
			else {
				request.getRequestDispatcher("WEB-INF/jsp/admin/addProduct.jsp").forward(request, response);
			}
		}else {
			session.removeAttribute("username");
			request.getRequestDispatcher("WEB-INF/jsp/admin/login.jsp").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		
		Product pro = new Product();

		String name = request.getParameter("name");
		int price = Integer.parseInt(request.getParameter("price"));
		String image = request.getParameter("image");
		int unit = Integer.parseInt(request.getParameter("unit_in_stock"));
		String des = request.getParameter("des");
		String manu = request.getParameter("manu");
		String cate = request.getParameter("cate");
		int condi = Integer.parseInt(request.getParameter("condi"));
		
		pro.setName(name);
		pro.setPrice(price);
		pro.setImage(image);
		pro.setUnits_in_stock(unit);
		pro.setDes(des);
		pro.setManu(manu);
		pro.setCategory(cate);
		pro.setCondition(condi);
		
		pro.addProduct();
		
		request.getRequestDispatcher("WEB-INF/jsp/admin/addProduct.jsp").forward(request, response);
		
	}

}
