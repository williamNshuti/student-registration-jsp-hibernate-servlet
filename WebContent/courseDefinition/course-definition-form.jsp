<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>Auca Course Definition</title>

<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">

</head>

<style>
   .btn {
        margin: 10px;
        color: #fff;
        padding: 15px;
        border: none;
        border-radius: 50%; /* Set border-radius to 50% */
        text-transform: uppercase;
        letter-spacing: 1px;
        font-weight: bold;
        box-shadow: 0 4px 6px rgba(0, 0, 0, 0.1);
        transition: background-color 0.3s, transform 0.2s;
    }
</style>
<body>
	
	<div class="container col-md-5 mt-4">
		<div class="card">
			<div class="card-body">
				<c:if test="${definitions != null}">
					<form action="CourseDefinitionUpdate" method="post">
				</c:if>
				<c:if test="${definitions == null}">
					<form action="CourseDefinitionInsert" method="post">
				</c:if>

				<caption >
					<h2>
						<c:if test="${definitions != null}">
            			Edit Course Definition
            		</c:if>
						<c:if test="${definitions == null}">
            			Add Course Definition
            		</c:if>
					</h2>
				
				</caption>

				<c:if test="${definitions != null}">
					<input type="hidden" name="id" value="<c:out value='${definitions.id}' />" />
				</c:if>

				<fieldset class="form-group">
					<label>Code</label> <input type="text"
						value="<c:out value='${definitions.code}' />" class="form-control"
						name="code" required="required" >
				</fieldset>

				<fieldset class="form-group">
					<label> Name</label> <input type="text"
						value="<c:out value='${definitions.name}' />" class="form-control"
						name="name" minlength="5">
				</fieldset>
				
				<fieldset class="form-group">
					<label> Description</label> <input type="text"
						value="<c:out value='${definitions.description}' />" class="form-control"
						name="description" minlength="5">
				</fieldset>


				<button type="submit" class="btn btn-success">Save</button>
				</form>
			</div>
		</div>
	</div>

</body>
</html>
