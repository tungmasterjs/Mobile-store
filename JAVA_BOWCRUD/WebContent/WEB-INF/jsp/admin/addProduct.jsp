<%@page import="model.Product" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"  %>
<jsp:include page="header.jsp"/>
<header>
		<div class="container">
			<h1>Products</h1>
			<p>Add products</p>
			<a href="/JAVA_BOWCRUD/addProduct?logout=1"><button class="LogOut btn btn-danger">Log Out</button></a>
		</div>
	</header>
	<article>
		<div class="container">
			<p class="AddNewProduct">Add new product<p>
			<hr>
			<div id="formContainer">
				<form action="addProduct" method="post" id="myForm">
					<table class="table table-borderless">
						<tr>
							<td class="tdText">Product Name</td>
							<td><input class="inputFull" type="text" name="name" id="name"></td>
						</tr>
						<tr>
							<td class="tdText">Unit Price</td>
							<td><input class="inputFull" type="text" name="price" id="price"></td>
						</tr>
						<tr>
							<td class="tdText">Units In Stock</td>
							<td><input class="inputFull" type="text" name="unit_in_stock" id="unit_in_stock"></td>
						</tr>
						<tr>
							<td class="tdText">Description</td>
							<td><textarea name="des" id="des"></textarea></td>
						</tr>
						<tr>
							<td class="tdText">Manufacturer</td>
							<td><input class="inputFull" type="text" name="manu" id="manu"></td>
						</tr>
						<tr>
							<td class="tdText">Category</td>
							<td><input class="inputFull" type="text" name="cate" id="cate"></td>
						</tr>
						<tr>
							<td class="tdText">Condition</td>
							<td><input type="radio" name="condi" value="0" checked> New <input type="radio" name="condi" value="1"> Old <input type="radio" name="condi" value="2"> Refurbished </td>
						</tr>
						<tr>
							<td class="tdText">Product Image File</td>
							<td><input class="inputFull" type="file" name="image" id="image"></td>
						</tr>
						<tr>
							<td></td>
							<td><span class="text-danger" id="Error"></span></td>
						</tr>
						<tr>
							<td class="tdText"></td>
							<td><button type="submit" class="btn btn-primary">Add Product</button></td>
						</tr>
					</table>
					  	
				</form>
			</div>
		</div>
	</article>
<jsp:include page="footer.jsp"/>