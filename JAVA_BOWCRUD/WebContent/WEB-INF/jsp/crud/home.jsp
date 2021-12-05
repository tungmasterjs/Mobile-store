<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"  %>
<jsp:include page = "header.jsp"/>

	<article>
		<div class="container">
			<div class="row">
				<c:forEach items="${listProduct}" var="list">
					<div class="col-xl-3 col-lg-03 col-md-6 col-sm-12">
					<div class="border rounded productBox">
						<h4>${list.getName()}</h4>
						<img class="imgProduct" src="${pageContext.request.contextPath}/resouce/image/${list.getImage()}">
						<p>${list.getDes()}</p>
						<p>${list.getPrice()} USD</p>
						<p>${list.getUnits_in_stock()} units in stock</p>
						<a href="productDetail?item_code=${list.getItem_code()}" class="btn btn-primary"><i class="fas fa-info-circle"></i> Details</a>
						<a href="cart?id=${list.getItem_code()}" class="btn btn-warning" style="color:white"><i class="fa fa-shopping-cart"></i> Order Now</a>
					</div>
				</div>
				</c:forEach>
			</div>
		</div>
	</article>
</body>
</html>