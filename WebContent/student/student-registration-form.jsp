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
				<c:if test="${registration != null}">
					<form action="CourseUpdate" method="post">
				</c:if>
				<c:if test="${registration == null}">
					<form action="RegistrationInsert" method="post">
				</c:if>

				<caption >
					<h2>
						<c:if test="${registration != null}">
            			Edit Course
            		</c:if>
						<c:if test="${registration == null}">
            			Register New Student
            		</c:if>
					</h2>
				
				
				</caption>
					 <hr>

				<c:if test="${registration != null}">
					<input type="hidden" name="id" value="<c:out value='${registration.id}' />" />
				</c:if>
				 <fieldset class="form-group">
                    <label>Student</label> <select class="form-control"
                        name="student"  >
                      <c:forEach items="${student}" var="stud">
                         <option value="${stud.id}">${stud.names}</option>
                      </c:forEach>
                    </select>
                </fieldset>
                
                 <fieldset class="form-group">
                    <label>Department</label> <select class="form-control"
                        name="department"  >
                         <c:forEach items="${departments}" var="department">
                         <option value="${department.id}">${department.name}</option>
                         </c:forEach>
                    </select>
                </fieldset>
                
                
                <fieldset class="form-group">
                    <label>Course Semester</label> <select class="form-control"
                        name="semester">
                         <c:forEach items="${semesters}" var="semester">
                         <option value="${semester.id}">${semester.name}</option>
                         </c:forEach>
                    </select>
                </fieldset>
                
               <fieldset class="form-group">
					<label>Registration Date</label> <input type="date"
						value="<c:out value='${registration.endDate}' />" class="form-control"
						name="date" required="required">
				</fieldset>

				<button type="submit" class="btn btn-success">Save</button>
				</form>
			</div>
		</div>
	</div>

</body>
</html>
