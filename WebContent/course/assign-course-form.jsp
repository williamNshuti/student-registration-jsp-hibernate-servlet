<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>Auca Courses</title>

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
				<c:if test="${course != null}">
					<form action="CourseUpdate" method="post">
				</c:if>
				<c:if test="${course == null}">
					<form action="CourseAssign?id=${studentId}" method="post">
				</c:if>

				<caption >
					<h2>
						<c:if test="${course != null}">
            			Edit Course
            		</c:if>
						<c:if test="${course == null}">
            			Assign Course
            		</c:if>
					</h2>
				
				</caption>
				<hr>

				 <fieldset class="form-group">
                    <label>Course</label> <select class="form-control"
                        name="code"  >
                      <c:forEach items="${courses}" var="course">
                         <option value="${course.id}">${course.courseDefinition.name}</option>
                      </c:forEach>
                    </select>
                </fieldset>
                
				<button type="submit" class="btn btn-success">Save</button>
				</form>
			</div>
		</div>
	</div>

</body>
</html>
