<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"  %>
<%@page import="java.util.List"%>
<%@page import="model.item" %>
<jsp:include page="../admin/header.jsp"/>
<header>
		<div class="container">
			<h1>Cart</h1>
		</div>
</header>
<%	
				int total = 0;
				if(session.getAttribute("cart")!=null){
				List<item> list = (List<item>) session.getAttribute("cart");
				
				for(item itemPro:list){
					total+=itemPro.getPrice()*itemPro.getQty();
				}
			}%>
	<article>
		<div class="container">
			<a href="deleteCart?delete=2" class="btn btn-danger"><i class="fas fa-times-circle"></i> Clear Cart</a>
			<a href="#" class="float-right btn btn-success"><i class="fas fa-times-circle"></i> Check out</a>
			<table class="table table-hover">
				<thead>
					<tr>
						<th>Product</th>
						<th>Quantity</th>
						<th>Unit price</th>
						<th>Price</th>
						<th>Action</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${cart}" var="item">
					<tr>
						<td>${item.getPro().getName()}</td>
						<td>${item.getQty()}</td>
						<td>${item.getPro().getPrice()}</td>
						<td>${item.getPro().getPrice()}</td>
						<td><a href="deleteCart?delete=1&id=${item.getId()}" class="btn btn-danger"><i class="fas fa-times"></i> Remove</a></td><!-- <i class="fas fa-times-circle"></i> -->
					</tr>
					</c:forEach>
				</tbody>
				<tfoot>
					<tr>
						<td></td>
						<td></td>
						<th>Grand Total</th>
						<td><%=total%></td>
						<td></td>
					</tr>
				</tfoot>
			</table>
			<a href="/JAVA_BOWCRUD/home" class="btn btn-success"><i class="fas fa-arrow-circle-left"></i> Continue shopping</a>
		</div>
		
	</article>
</body>
</html>