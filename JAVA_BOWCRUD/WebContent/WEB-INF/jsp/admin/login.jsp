<jsp:include page="header.jsp"/>
<header>
		<div class="container">
			<h1>Mobile Store</h1>
		</div>
	</header>
	<article>
		<div class="container">
			<div class="d-flex justify-content-center">
				<div class="card formContainer">
					<div class="card-header">
						Please sign in
					</div>
					<form class="card-body" method="post" action="login">
						<div class="form-group">
							<input type="text" class="form-control" name="Username" placeholder="User name" value="">
						</div>
						<div class="form-group">
							<input type="password" class="form-control" name="Password" placeholder="Password">
						</div>
						<p class="text-danger">${ERROR}</p>
						<button type="submit" class="btn btn-success">Login</button>
					</form>
				</div>
			</div>
		</div>
	</article>