<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>

<div class="container">
<div class="row">
<c:if test="${not empty message}">

<div class="col-xs-12">
<div class="alert alert-success alert-dismissible">
<button type="button" class="close" data-dismiss="alert">&times;</button>
${message}
</div>
</div>
</c:if>
<div class="col-md-offset-2 col-md-8">
<div class="panel panel-primary">
<div class="panel-heading">
<h4>Manage Products</h4>
</div>
<div class="panel-body">
<!-- Form Elements -->

<sf:form class="form-horizontal" modelAttribute="product" action="${contextRoot}/manage/products" method="post" enctype="multipart/form-data">
<div class="form-group">
<label class="control-label col-md-4" for="name">Enter Product Name:</label>
<div class="col-md-8">

<sf:input type="text" path="name" id="name" placeholder="Product name" class="form-control"/>
<sf:errors path="name" cssClass="help-block" element="em"/>
<em class="help-block">Please enter product name</em>
</div>
</div>


<div class="form-group">
<label class="control-label col-md-4" for="brand">Enter Product Brand:</label>
<div class="col-md-8">

<sf:input type="text" path="brand" id="brand" placeholder="Product brand" class="form-control"/>
<sf:errors path="brand" cssClass="help-block" element="em"/>
<em class="help-block">Please enter product brand</em>
</div>
</div>

<div class="form-group">
<label class="control-label col-md-4" for="description">Product Description:</label>
<div class="col-md-8">
<sf:textarea class="form-control" path="description" id="description" rows="4"  placeholder="write a descritpion"/>
<sf:errors path="description" cssClass="help-block" element="em"/>
</div>
</div>

<div class="form-group">
<label class="control-label col-md-4" for="unitPrice">Enter Unit Price:</label>
<div class="col-md-8">

<sf:input type="text" path="unitPrice" id="unitPrice" placeholder="unit price in &#8377;" class="form-control"/>
<sf:errors path="unitPrice" cssClass="help-block" element="em"/>
</div>
</div>

<div class="form-group">
<label class="control-label col-md-4" for="quantity">Enter Quantity:</label>
<div class="col-md-8">

<sf:input type="number" path="quantity" id="quantity" placeholder="quantity available" class="form-control"/>

</div>
</div>

<div class="form-group">
<label class="control-label col-md-4" for="file">Upload Image:</label>
<div class="col-md-8">

<sf:input type="file" path="file" id="file" class="form-control"/>
<sf:errors path="file" cssClass="help-block" element="em"/>
</div>
</div>

<div class="form-group">
<label class="control-label col-md-4" for="categoryId">Select Category:</label>
<div class="col-md-8">
<sf:select path="categoryId" class="form-control" id="categoryId" items="${categories}" itemLabel="name" itemValue="id"/>
<c:if test="${product.id==0}">
<br>
<div class="text-right">
<button type="button" data-toggle="modal" data-target="#myCategoryModal" class="btn btn-warning btn-xs">Add Category</button>
</div>
</c:if>




<sf:hidden path="id"/>
<sf:hidden path="code"/>
<sf:hidden path="supplierId"/>
<sf:hidden path="active"/>
<sf:hidden path="purchases"/>
<sf:hidden path="views"/>
</div>
</div>

<div class="form-group">
<div class="col-md-offset-4 col-md-8">
<input type="submit" name="submit" id="submit" value="submit" class="btn btn-primary"/>

</div>
</div>



</sf:form>



</div>

</div>

</div>


</div>

<div class="row">

<div class="col-xs-12">
<h3>Admin Product Table</h3>
</div>

<div class="col-xs-12">
<div style="overflow:auto">
<table class="table table-striped table-bordered" id="adminProductsTable">
<thead>
<tr>
<th>Id</th>
<th>&#160;</th>
<th>Brand</th>
<th>Name</th>
<th>Quantity</th>
<th>Unit Price</th>
<th>Active</th>
<th>Edit</th>
</tr>
</thead>

</table>

</div>
</div>
</div>

<div class="modal fade" id="myCategoryModal" role="dialog" tabindex="-1">
<div class="modal-dialog" role="document">
<div class="modal-content">
<div class="modal-header">
<button type="button" class="close" data-dismiss="modal">
<span>&times;</span>
</button>
<h4 class="modal-title">Add New Category</h4>
</div>
<div class="modal-body">
<sf:form modelAttribute="category" id="categoryForm" action="${contextRoot}/manage/category" method="POST" class="form-horizontal">
<div class="form-group">
<label for="category_name" class="control-label col-md-4">Category Name:</label>
<div class="col-md-8">
<sf:input type="text" path="name" id="category_name" class="form-control"/>
</div>
</div>
<div class="form-group">
<label for="category_description" class="control-label col-md-4">Category Description:</label>
<div class="col-md-8">
<sf:textarea path="description" id="category_description" class="form-control"/>
</div>
</div>

<div class="form-group">
<div class="col-md-offset-4 col-md-8">
<input type="submit" value="Add Category" class="btn btn-primary">
</div>
</div>


</sf:form>
</div>

</div>

</div>
</div>
</div>