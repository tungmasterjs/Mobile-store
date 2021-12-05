<%@page import="model.Product"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"  %>
<jsp:include page = "header.jsp"/>
<article>
	<div class="container">
		<div class="row">
			<div class="col-xl-5">
				<img class="imgProductDetail" src="${pageContext.request.contextPath}/resouce/image/${PRODUCT.getImage()}">
			</div>
			<div class="col-xl-7">
				<div class="textProductDetail">
					<h3>${PRODUCT.getName()}</h3>
					<p>${PRODUCT.getDes()}</p>
					<p><b>Item code: </b> <span class="btn btn-warning" style="color:white">${PRODUCT.getItem_code()}</span></p>
					<p><b>Manufacturer: </b>${PRODUCT.getManu()}</p>
					<p><b>Category: </b>${PRODUCT.getCategory()}</p>
					<p><b>Avaible units stock: </b> ${PRODUCT.getUnits_in_stock()}</p>
					<a href="/JAVA_BOWCRUD/home" class="btn btn-success"><i class="fas fa-arrow-circle-left"></i> Back</a>
					<a href="/http://localhost:8080/JAVA_BOWCRUD//cart?id=${PRODUCT.getItem_code()}"class="btn btn-warning" style="color:white"><i class="fa fa-shopping-cart"></i> Order Now</a>
					</div>
				</div>
			</div>
		</div>
	</article>
</body>
</html>