<div class="container">
	<div class="row">
		<div class="col-md-3">
			<%@ include file="./shared/sidemenu.jsp"%>
		</div>

		<div class="col-md-9">
			<div class="row">
				<div class="col-lg-12">
					<c:if test="${userAllProductsClick == true}">
					<script>
					window.categoryId='';
					</script>
						<ol class="breadcrumb">
							<li><a href="${contextRoot}/home">Home</a></li>
							<li class="active">All Products</li>
						</ol>
					</c:if>

					<c:if test="${userCategoryProductsClick == true}">
					<script>
					window.categoryId='${category.id}';
					</script>
						<ol class="breadcrumb">
							<li><a href="${contextRoot}/home">Home</a></li>
							<li class="active">Category</li>
							<li class="active">${category.name}</li>
						</ol>
					</c:if>


				</div>
			</div>

			<div class="row">
				<div class="col-xs-12">
					<table class="table table-striped table-bordered" id="productListTable">
						<thead>
							<tr>
							    <th></th>
								<th>Name</th>
								<th>Brand</th>
								<th>Price</th>
								<th>Qty Available</th>
								<th></th>
							</tr>
						</thead>

					</table>

				</div>
			</div>
		</div>
	</div>

</div>