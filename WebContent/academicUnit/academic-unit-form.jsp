<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>Academic Unit Form</title>

    <link rel="stylesheet"
        href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
        integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
        crossorigin="anonymous">

    <script type="text/javascript">
        function toggleParentField() {
            var academicUnitType = document.getElementById("unit").value;
            var academicUnitParentField = document.getElementById("academicUnitParentField");
            
            if (academicUnitType === "PROGRAMME") {
                academicUnitParentField.style.display = "none";
            } else {
                academicUnitParentField.style.display = "block";
            }
        }
        
        window.onload = toggleParentField;

    </script>
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
                <c:if test="${academic != null}">
                    <form action="AcademicUnitUpdate" method="post">
                </c:if>
                <c:if test="${academic == null}">
                    <form action="AcademicUnitInsert" method="post">
                </c:if>

                <caption>
                    <h2>
                        <c:if test="${academic != null}">
                            Edit Academic Unit
                        </c:if>
                        <c:if test="${academic == null}">
                            Add New Academic Unit
                        </c:if>
                    </h2>
                </caption>

                <fieldset class="form-group">
                    <label>Academic Unit Code</label> <input type="text"
                        value="<c:out value='${academic.code}' />" class="form-control"
                        name="code" required="required" >
                </fieldset>

                <fieldset class="form-group">
                    <label>Academic Unit Name</label> <input type="text"
                        value="<c:out value='${academic.name}' />" class="form-control"
                        name="name" minlength="5">
                </fieldset>

                <fieldset class="form-group">
                    <label>Academic Unit Type</label> <select class="form-control"
                        name="unit" id="unit" onchange="toggleParentField()">
                        <option value="PROGRAMME" selected >PROGRAMME</option>
                        <option value="FACULTY" >FACULTY</option>
                        <option value="DEPARTMENT">DEPARTMENT</option>
                    </select>
                </fieldset>
                
                
                 <fieldset class="form-group" id="academicUnitParentField">
                    <label>Parent</label> <input type="text"
                        value="<c:out value='${academic.parent}' />" class="form-control"
                        name="parent">
                </fieldset>

               

                <button type="submit" class="btn btn-success">Save</button>
                </form>
            </div>
        </div>
    </div>
</body>
</html>
