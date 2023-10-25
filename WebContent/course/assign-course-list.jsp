<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet"
    href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
    integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
    crossorigin="anonymous">
<title>Assigned course List</title>
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

<div class="row">

    <div class="container">
        <h2 class="text-center mt-4 font-weight-bolder">Assigned Course List</h2>
        <hr>
        <div class="container text-left">

            <a href="<%=request.getContextPath()%>/AssignNew?id=${studentId}" class="btn btn-success">Assign Course</a>
            <a href="<%=request.getContextPath()%>/AssignList?id=${studentId}" class="btn btn-primary">Refresh Table</a>
             <a href="<%=request.getContextPath()%>/HomePage" class="btn btn-info">Home</a>
            

        </div>

        <br>

        <table class="table table-bordered">
            <thead>
                <tr>
                 <!--    <th>Id</th> -->
                    <th>Student </th>
                    <th>Course</th>
                     <th>Credits </th>
                     <!-- <th>Actions</th> -->
                </tr>
            </thead>
            <tbody>
                <c:forEach var="course" items="${listofcoursesTaken}">
                    <tr>
                        <%-- <td><c:out value="${course.id}" /></td> --%>
                        <td><c:out value="${course.studentRegistration.student.names}" /></td>
                        <td><c:out value="${course.course.courseDefinition.name}" /></td>
                         <td><c:out value="${course.course.credit}" /></td>
                        
                        
                        <!-- Add your actions here -->
                        <%-- <td>
                            <a href="courseDelete?id=<c:out value='${course.id}' />">Delete</a>
                        </td> --%>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </div>
</div>

</body>
</html>
