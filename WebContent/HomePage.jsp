<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Home Page</title>
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">

    <style>
            .container-fluid {
            text-align: center;
            color: #fff;
            padding: 80px 100px;/
            height: 100vh; 
            width: 100%;
            overflow: hidden; 
        }

        .btn-container {
            margin-top: 30px;
        }

        .btn {
            margin: 10px;
            color: #fff;
            padding: 15px 30px;
            border: none;
            border-radius: 5px;
            text-transform: uppercase;
            letter-spacing: 1px;
            font-weight: bold;
            box-shadow: 0 4px 6px rgba(0, 0, 0, 0.1);
            transition: background-color 0.3s, transform 0.2s;
        }

        .section1 {
            background: linear-gradient(to bottom, #3498db, #6a89cc);
            height: 100%;
            width: 100%; /* Added to occupy full width */
        }

        .section2 {
            background: linear-gradient(to bottom, #e74c3c, #d64032);
            height: 100%;
            width: 100%; /* Added to occupy full width */
        }

        .section3 {
            background: linear-gradient(to bottom, #f39c12, #e28e0e);
            height: 100%;
            width: 100%;
        }

        .btn-primary {
            background: #007BFF;
        }

        .btn-primary:hover {
            background: #0056b3;
            transform: scale(1.05);
        }

        .btn-success {
            background: #28A745;
        }

        .btn-success:hover {
            background: #1d9236;
            transform: scale(1.05);
        }

        .btn-warning {
            background: #FFC107;
        }

        .btn-warning:hover {
            background: #d1a006;
            transform: scale(1.05);
        }

        .btn-info {
            background: #17A2B8;
        }

        .btn-info:hover {
            background: #128ca5;
            transform: scale(1.05);
        }

        .btn-danger {
            background: #DC3545;
        }

        .btn-danger:hover {
            background: #c22e3a;
            transform: scale(1.05);
        }

        h1 {
            font-size: 36px;
            font-weight: bold;
            text-transform: uppercase;
            letter-spacing: 2px;
        }
        
        .btn {
        margin: 10px;
        color: #fff;
        padding: 15px 30px;
        border: none;
        border-radius: 50%; /* Set border-radius to 50% */
        text-transform: uppercase;
        letter-spacing: 1px;
        font-weight: bold;
        box-shadow: 0 4px 6px rgba(0, 0, 0, 0.1);
        transition: background-color 0.3s, transform 0.2s;
    }
        
    </style>
</head>
<body>
    <div class="container-fluid section1">
        <h1>WELCOME TO AUCA PORTAL</h1>
        <hr>
        <div class="btn-container">
            <a href="AcademicUnitList" class="btn btn-primary">Academic Unit</a>
            <a href="CourseDefinitionList" class="btn btn-success">Course Definition</a>
        </div>
    </div>

    <div class="container-fluid section2">
        <div class="btn-container">
            <a href="SemesterList" class="btn btn-warning">Semester</a>
            <a href="StudentList" class="btn btn-info">Student</a>
             <a href="TeacherList" class="btn btn-warning">Teacher</a>
            
        </div>
    </div>

    <div class="container-fluid section3">
        <div class="btn-container">
            <a href="CourseList" class="btn btn-success">Course</a>
            <a href="RegisterList" class="btn btn-info">Student Registration</a>
            
        </div>
    </div>
</body>
</html>
