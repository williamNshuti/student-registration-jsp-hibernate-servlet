<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>Auca Teachers</title>

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
				<c:if test="${teachers != null}">
					<form action="TeacherUpdate" method="post">
				</c:if>
				<c:if test="${teachers == null}">
					<form action="TeacherInsert" method="post">
				</c:if>

				<caption >
					<h2>
						<c:if test="${teachers != null}">
            			Edit Teacher
            		</c:if>
						<c:if test="${teachers == null}">
            			Add New Teacher
            		</c:if>
					</h2>
				
				</caption>

				<c:if test="${teachers != null}">
					<input type="hidden" name="id" value="<c:out value='${teachers.id}' />" />
				</c:if>

				<fieldset class="form-group">
					<label>Teacher Code</label> <input type="text"
						value="<c:out value='${teachers.code}' />" class="form-control"
						name="code" required="required" >
				</fieldset>

				<fieldset class="form-group">
					<label>Teacher Full Names</label> <input type="text"
						value="<c:out value='${teachers.fullname}' />" class="form-control"
						name="names">
				</fieldset>


				 <fieldset class="form-group">
                    <label>Teacher Qualifications</label> <select class="form-control"
                        name="qualification" >
                        <option value="MASTERS" selected >MASTERS</option>
                        <option value="PHD" >PHD</option>
                        <option value="PROFESSOR">PROFESSOR</option>
                    </select>
                </fieldset>

				<button type="submit" class="btn btn-success">Save</button>
				</form>
			</div>
		</div>
	</div>

</body>
</html>
