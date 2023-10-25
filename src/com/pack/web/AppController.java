package com.pack.web;

import java.io.IOException;
import java.time.LocalDate;

import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pack.DaoImplementation.AcademicUnitDaoImpl;
import com.pack.DaoImplementation.CourseDaoImpl;
import com.pack.DaoImplementation.CourseDefinitionDaoImpl;
import com.pack.DaoImplementation.SemesterDaoImpl;
import com.pack.DaoImplementation.StudentCourseRegistrationDaoImpl;
import com.pack.DaoImplementation.StudentDaoImpl;
import com.pack.DaoImplementation.StudentRegistrationDaoImpl;
import com.pack.DaoImplementation.TeacherDaoImpl;
import com.pack.dao.AcademicUnitDao;
import com.pack.dao.CourseDao;
import com.pack.dao.CourseDefinitionDao;
import com.pack.dao.SemesterDao;
import com.pack.dao.StudentCourseRegistrationDao;
import com.pack.dao.StudentDetailsDao;
import com.pack.dao.StudentRegistrationDao;
import com.pack.dao.TeacherDao;
import com.pack.model.AcademicUnit;
import com.pack.model.CourseDefinitionModel;
import com.pack.model.CourseModel;
import com.pack.model.SemesterModel;
import com.pack.model.StudentCourseRegistration;
import com.pack.model.StudentDetailsModel;
import com.pack.model.StudentRegistrationModel;
import com.pack.model.TeacherModel;


@WebServlet("/")
public class AppController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private AcademicUnitDao AcademicUnitDao;
	private StudentDetailsDao studentDetailsModel;
	private SemesterDao semesterDao;
	private CourseDefinitionDao courseDefinitionDao;
	private TeacherDao teacherDao;
	private CourseDao courseDao;
	private StudentRegistrationDao studentRegistrationDao;
	private StudentCourseRegistrationDao studentCourseRegistrationDao;


	public void init() {
		AcademicUnitDao = new AcademicUnitDaoImpl();
		studentDetailsModel = new StudentDaoImpl();
		semesterDao = new SemesterDaoImpl();
		courseDefinitionDao = new CourseDefinitionDaoImpl();
		teacherDao = new TeacherDaoImpl();
		courseDao = new CourseDaoImpl();
		studentRegistrationDao = new StudentRegistrationDaoImpl();
		studentCourseRegistrationDao = new StudentCourseRegistrationDaoImpl();
;		

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getServletPath();

		try {
			switch (action) {
			
			//++++  New forms ++++++++
			case "/AcademicUnitNew":
				showNewFormAcademicUnit(request, response);
				break;
			case "/StudentNew":
				showNewFormStudent(request, response);
				break;
			case "/TeacherNew":
				showNewFormTeacher(request, response);
				break;
				
			case "/SemesterNew":
				showNewFormSemester(request, response);
				break;
				
			case "/CourseNew":
				showNewFormCourses(request, response);
				break;
				
			case "/RegisterNew":
				showNewFormRegistration(request, response);
				break;
				
			case "/AssignNew":
				showNewFormAssign(request, response);
				break;
				
			case "/CourseDefinitionNew":
				showNewFormCourseDefinition(request, response);
				break;
				
				
				//++++ INSERT ++++++++++++
			case "/AcademicUnitInsert":
				insertAcademicUnit(request, response);
				break;
			case "/StudentInsert":
				insertStudent(request, response);
				break;
			case "/TeacherInsert":
				insertTeacher(request, response);
				break;
				
			case "/SemesterInsert":
				insertSemester(request, response);
				break;
			case "/CourseInsert":
				insertCourse(request, response);
				break;
			case "/RegistrationInsert":
				RegisterStudent(request, response);
				break;
			case "/CourseAssign":
				AssignStudentCourse(request, response);
				break;
				
			case "/CourseDefinitionInsert":
				insertCourseDefinition(request, response);
				break;
				
				
				// ++++++ DELETEE ++++++++++
				
			case "/studentDelete":
				deleteStudent(request, response);
				break;
				
			case "/teacherDelete":
				deleteTeacher(request, response);
				break;
				
			case "/semesterDelete":
				deleteSemester(request, response);
				break;
			case "/courseDelete":
				deleteCourse(request, response);
				break;
			case "/registrationDelete":
				deleteRegistration(request, response);
				break;
				
			case "/courseDefinitionDelete":
				deleteCourseDefinition(request, response);
				break;
				
				
				
				
				
				// +++++++ EDIT FORM +++++++++++

			case "/studentEdit":
				showEditFormStudent(request, response);
				break;
			case "/teacherEdit":
				showEditFormTeacher(request, response);
				break;
				
			case "/semesterEdit":
				showEditFormSemester(request, response);
				break;
			case "/AcademicUnitEdit":
				showEditFormAcademicUnit(request, response);
				break;
				
			case "/courseDefinitionEdit":
				showEditFormCourseDefinition(request, response);
				break;
				
				
				//  ++++++ UPDATE ++++++++++
		
				
			case "/StudentUpdate":
				updateStudent(request, response);
				break;
				
			case "/TeacherUpdate":
				updateTeacher(request, response);
				break;
				
			case "/SemesterUpdate":
				updateSemester(request, response);
				break;
				
			case "/AcademicUnitUpdate":
				updateAcademicUnit(request, response);
				break;
				
			case "/CourseDefinitionUpdate":
				updateCourseDefinition(request, response);
				break;
				
				
				
				// ++++++++ THE LISTS ++++++++++++++
				
			case "/AcademicUnitList":
				listAcademicUnit(request, response);
				break;
				
			case "/StudentList":
				listStudentDetails(request, response);
				break;
				
			case "/TeacherList":
				listTeacher(request, response);
				break;
				
				
			case "/SemesterList":
				listSemesterDetails(request, response);
				break;
			case "/CourseList":
				listCourses(request, response);
				break;
				
			case "/CourseDefinitionList":
				listCourseDefinition(request, response);
				break;
			case "/RegisterList":
				listOfRegistrations(request, response);
				break;
			case "/AssignList":
				listOfAssignedCourses(request, response);
				break;
				
			case "/semesterStudents":
				listOfAllStudentInParticularSemester(request, response);
				break;
				
			case "/HomePage":
				HomePage(request, response);
				break;
				
				
				
				
				
			default:
//				listTodo(request, response);
                response.getWriter().write("Nothing found");
				break;
			}
		} catch (SQLException ex) {
			throw new ServletException(ex);
		}
	}

	
	
	private void HomePage(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("HomePage.jsp");
		dispatcher.forward(request, response);
	}
	
	
	// ACADEMIC UNIT ========++++++++++++++++++++
	
	private void listAcademicUnit(HttpServletRequest request, HttpServletResponse response)
	        throws SQLException, IOException, ServletException {
	    List<AcademicUnit> listAcademicUnit = AcademicUnitDao.selectAllAcademicUnit();

	    if (listAcademicUnit != null && !listAcademicUnit.isEmpty()) {
	       
	        request.setAttribute("listacademicunit", listAcademicUnit);
	    } else {
	        // If the list is empty or null, you can remove the attribute
	        request.removeAttribute("listacademicunit");
	    }

	    RequestDispatcher dispatcher = request.getRequestDispatcher("academicUnit/academic-unit-list.jsp");
	    dispatcher.forward(request, response);
	}


	private void showNewFormAcademicUnit(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("academicUnit/academic-unit-form.jsp");
		dispatcher.forward(request, response);
	}
	
	private void showEditFormAcademicUnit(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		AcademicUnit existingUnit = AcademicUnitDao.selectAcademicUnit(id);
		RequestDispatcher dispatcher = request.getRequestDispatcher("academicUnit/academic-unit-form.jsp");
		request.setAttribute("academic", existingUnit);
		dispatcher.forward(request, response);
	}
	
	private void insertAcademicUnit(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
		String code = request.getParameter("code");
		String name = request.getParameter("name");
		String unityTypeString = request.getParameter("unit");
        AcademicUnit.UnityType unityType = AcademicUnit.UnityType.valueOf(unityTypeString);
        
        Integer parentId = null; // Initialize parentId to null

        String parentIdString = request.getParameter("parent");
        if (parentIdString != null && !parentIdString.isEmpty()) {
            parentId = Integer.parseInt(parentIdString);
        }
        
        AcademicUnit parentUnit = null;
        if (parentId != null) {
            parentUnit = new AcademicUnit();
            parentUnit.setId(parentId);
        }
	
	    System.out.println("Code: " + code);
	    System.out.println("Name: " + name);
	    System.out.println("Unity Type: " + unityType);
	    System.out.println("Parent ID: " + parentId);
		AcademicUnit academicUnit = new AcademicUnit(code,name,unityType,parentUnit);
		AcademicUnitDao.insertAcademicUnit(academicUnit);;
		response.sendRedirect("AcademicUnitList");

	}
	
	private void updateAcademicUnit(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));

		String code = request.getParameter("code");
		String name = request.getParameter("name");
		String unityTypeString = request.getParameter("unit");
        AcademicUnit.UnityType unityType = AcademicUnit.UnityType.valueOf(unityTypeString);
		Integer parentId = Integer.parseInt(request.getParameter("parent"));
		
		 AcademicUnit parentUnit = null;
	        if (parentId != null) {
	            parentUnit = new AcademicUnit();
	            parentUnit.setId(parentId);
	        }
		
		AcademicUnit academicUnit = new AcademicUnit(code,name,unityType,parentUnit);
		AcademicUnitDao.updateAcademicUnit(academicUnit);
		response.sendRedirect("list");
	}
	
	
	private void deleteAcademicUnit(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		AcademicUnitDao.deleteAcademicUnit(id);
		response.sendRedirect("list");
	}
	
	
	
	
	//++++++++++++++++++++ STUDENT DETAILS +++++++++++++++++++++++++++++++
	
	
	private void insertStudent(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
		String reg = request.getParameter("reg");
		String names = request.getParameter("names");
		LocalDate DOB = LocalDate.parse(request.getParameter("dob"));

	
	    System.out.println("Reg_No: " + reg);
	    System.out.println("Name: " + names);
	    System.out.println("Date Of Birth: " + DOB);
	    StudentDetailsModel studentDetails = new StudentDetailsModel(0,reg,names,DOB);
	    studentDetailsModel.insertStudent(studentDetails);
		response.sendRedirect("StudentList");

	}
	
	private void listStudentDetails(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		List<StudentDetailsModel> listAcademicUnit = studentDetailsModel.selectAllStudents();
		
		 if (listAcademicUnit != null && !listAcademicUnit.isEmpty()) {
		       
		        request.setAttribute("listofstudents", listAcademicUnit);
		    } else {
		        // If the list is empty or null, you can remove the attribute
		        request.removeAttribute("listofstudents");
		    }

		RequestDispatcher dispatcher = request.getRequestDispatcher("student/student-list.jsp");
		dispatcher.forward(request, response);
	}
	
	
	private void showNewFormStudent(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("student/student-form.jsp");
		dispatcher.forward(request, response);
	}
	
	private void showEditFormStudent(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		StudentDetailsModel existingStudent = studentDetailsModel.selectStudent(id);
		RequestDispatcher dispatcher = request.getRequestDispatcher("student/student-form.jsp");
		request.setAttribute("students", existingStudent);
		dispatcher.forward(request, response);
	}
	
	private void updateStudent(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		String reg = request.getParameter("reg");
		String names = request.getParameter("names");
		LocalDate DOB = LocalDate.parse(request.getParameter("dob"));
		
		 StudentDetailsModel studentDetails = new StudentDetailsModel(id,reg,names,DOB);
		 studentDetailsModel.updateStudent(studentDetails);
		 response.sendRedirect("StudentList");
		
	}
	
	private void deleteStudent(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		studentDetailsModel.deleteStudent(id);
		 response.sendRedirect("StudentList");
	}
	
	
	// +++++++++++++++++++++++++     	SEMESTER DETAILS   +++++++++++++++++++++++++++++
	

	private void insertSemester(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
		String name = request.getParameter("names");
		LocalDate startDate = LocalDate.parse(request.getParameter("startDate"));
		LocalDate endDate = LocalDate.parse(request.getParameter("endDate"));

	    SemesterModel semesterDetails = new SemesterModel(0,name,startDate,endDate);
	    semesterDao.insertSemester(semesterDetails);
		response.sendRedirect("SemesterList");

	}
	
	private void listSemesterDetails(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		List<SemesterModel> listAcademicUnit = semesterDao.selectAllSemesters();
	    if (listAcademicUnit != null && !listAcademicUnit.isEmpty()) {
		       
	        request.setAttribute("listofsemesters", listAcademicUnit);
	    } else {
	        // If the list is empty or null, you can remove the attribute
	        request.removeAttribute("listofsemesters");
	    }
		RequestDispatcher dispatcher = request.getRequestDispatcher("semester/semester-list.jsp");
		dispatcher.forward(request, response);
	}
	
	
	private void showNewFormSemester(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("semester/semester-form.jsp");
		dispatcher.forward(request, response);
	}
	
	private void showEditFormSemester(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		SemesterModel existingStudent = semesterDao.selectSemester(id);
		RequestDispatcher dispatcher = request.getRequestDispatcher("semester/semester-form.jsp");
		request.setAttribute("semesters", existingStudent);
		dispatcher.forward(request, response);
	}
	
	private void updateSemester(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		String name = request.getParameter("names");
		LocalDate startDate = LocalDate.parse(request.getParameter("startDate"));
		LocalDate endDate = LocalDate.parse(request.getParameter("endDate"));
		
		SemesterModel studentDetails = new SemesterModel(id,name,startDate,endDate);
		semesterDao.updateSemester(studentDetails);
		 response.sendRedirect("SemesterList");
		
	}
	
	private void deleteSemester(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		semesterDao.deleteSemester(id);
		 response.sendRedirect("SemesterList");
	}
	
	
	
	//  ++++++++++  COURSE DEFINITION ++++++++++++++++++
	
	
	
	private void insertCourseDefinition(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
		String code = request.getParameter("code");
		String name = request.getParameter("name");
		String decription = request.getParameter("description");
		CourseDefinitionModel studentDetails = new CourseDefinitionModel(0,code,name,decription);
		courseDefinitionDao.insertCourseDefinition(studentDetails);
		response.sendRedirect("CourseDefinitionList");

	}
	
	private void listCourseDefinition(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		List<CourseDefinitionModel> listAcademicUnit = courseDefinitionDao.selectAllCourseDefinitions();
	    if (listAcademicUnit != null && !listAcademicUnit.isEmpty()) {
		       
	        request.setAttribute("listofcoursedefinition", listAcademicUnit);
	    } else {
	        // If the list is empty or null, you can remove the attribute
	        request.removeAttribute("listofcoursedefinition");
	    }
		RequestDispatcher dispatcher = request.getRequestDispatcher("courseDefinition/course-definition-list.jsp");
		dispatcher.forward(request, response);
	}
	
	
	private void showNewFormCourseDefinition(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("courseDefinition/course-definition-form.jsp");
		dispatcher.forward(request, response);
	}
	
	private void showEditFormCourseDefinition(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		CourseDefinitionModel existingStudent =courseDefinitionDao.selectCourseDefinition(id) ;
		RequestDispatcher dispatcher = request.getRequestDispatcher("courseDefinition/course-definition-form.jsp");
		request.setAttribute("definitions", existingStudent);
		dispatcher.forward(request, response);
	}
	
	private void updateCourseDefinition(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		String code = request.getParameter("code");
		String name = request.getParameter("name");
		String decription = request.getParameter("description");
		
		CourseDefinitionModel studentDetails = new CourseDefinitionModel(id,code,name,decription);
		courseDefinitionDao.updateCourseDefinition(studentDetails);
		 response.sendRedirect("CourseDefinitionList");
		
	}
	
	private void deleteCourseDefinition(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		courseDefinitionDao.deleteCourseDefinition(id);
		 response.sendRedirect("CourseDefinitionList");
	}
	
	
	
	// ++++++++++++++++++++++++ TEACHERSSSS +++++++++++++++++++++
	
	
	private void insertTeacher(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
		String code = request.getParameter("code");
		String name = request.getParameter("names");		
		String qualification = request.getParameter("qualification");
        TeacherModel.Qualification Qaulify = TeacherModel.Qualification.valueOf(qualification);
        
        TeacherModel studentDetails = new TeacherModel(0,code,name,Qaulify);
		teacherDao.insertTeacher(studentDetails);
		response.sendRedirect("TeacherList");

	}
	
	private void listTeacher(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		List<TeacherModel> listAcademicUnit = teacherDao.selectAllTeachers();	    
	    if (listAcademicUnit != null && !listAcademicUnit.isEmpty()) {
		       
	        request.setAttribute("listofteachers", listAcademicUnit);
	    } else {
	        // If the list is empty or null, you can remove the attribute
	        request.removeAttribute("listofteachers");
	    }
		RequestDispatcher dispatcher = request.getRequestDispatcher("teacher/teacher-list.jsp");
		dispatcher.forward(request, response);
	}
	
	
	private void showNewFormTeacher(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("teacher/teacher-form.jsp");
		dispatcher.forward(request, response);
	}
	
	private void showEditFormTeacher(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		TeacherModel existingStudent = teacherDao.selectTeacher(id);
		RequestDispatcher dispatcher = request.getRequestDispatcher("teacher/teacher-form.jsp");
		request.setAttribute("teachers", existingStudent);
		dispatcher.forward(request, response);
	}
	
	private void updateTeacher(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		String code = request.getParameter("code");
		String name = request.getParameter("names");		
		String qualification = request.getParameter("qualification");
        TeacherModel.Qualification Qaulify = TeacherModel.Qualification.valueOf(qualification);
		
        TeacherModel studentDetails = new TeacherModel(id,code,name,Qaulify);
        teacherDao.updateTeacher(studentDetails);
		 response.sendRedirect("TeacherList");
		
	}
	
	private void deleteTeacher(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		teacherDao.deleteTeacher(id);
		 response.sendRedirect("TeacherList");
	}
	
	
	
//  +++++++++++++++ COURSESSSSS ++++++++++++++
	
	private void listCourses(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		List<CourseModel> listAcademicUnit = courseDao.getAllCourses();	    
	    if (listAcademicUnit != null && !listAcademicUnit.isEmpty()) {
		       
	        request.setAttribute("listofcourses", listAcademicUnit);
	    } else {
	        // If the list is empty or null, you can remove the attribute
	        request.removeAttribute("listofcourses");
	    }
		RequestDispatcher dispatcher = request.getRequestDispatcher("course/course-list.jsp");
		dispatcher.forward(request, response);
	}
	
	

	private void showNewFormCourses(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		List<CourseDefinitionModel> listCourseDef = courseDefinitionDao.selectAllCourseDefinitions();
	    if (listCourseDef != null && !listCourseDef.isEmpty()) {
		       
	        request.setAttribute("courseDef", listCourseDef);
	    } else {
	        request.removeAttribute("courseDef");
	    }
	    List<AcademicUnit> departments = AcademicUnitDao.selectAcademicUnitsByType(AcademicUnit.UnityType.DEPARTMENT);
	    if (departments != null && !departments.isEmpty()) {
	       
	        request.setAttribute("departments", departments);
	    } else {
	        // If the list is empty or null, you can remove the attribute
	        request.removeAttribute("departments");
	    }
	    
	    List<TeacherModel> listTeacher = teacherDao.selectAllTeachers();	    
	    if (listTeacher != null && !listTeacher.isEmpty()) {
		       
	        request.setAttribute("teachers", listTeacher);
	    } else {
	        // If the list is empty or null, you can remove the attribute
	        request.removeAttribute("teachers");
	    }
	    
	    List<SemesterModel> listSemesters = semesterDao.selectAllSemesters();
	    if (listSemesters != null && !listSemesters.isEmpty()) {
		       
	        request.setAttribute("semesters", listSemesters);
	    } else {
	        // If the list is empty or null, you can remove the attribute
	        request.removeAttribute("semesters");
	    }
		RequestDispatcher dispatcher = request.getRequestDispatcher("course/course-form.jsp");
		dispatcher.forward(request, response);
	}
	
	private void insertCourse(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
		int code = Integer.parseInt(request.getParameter("code"));
		int unitId = Integer.parseInt(request.getParameter("unit"));
		int teacherId = Integer.parseInt(request.getParameter("teacher"));
		int semesterId = Integer.parseInt(request.getParameter("semester"));
		int credit = Integer.parseInt(request.getParameter("credit"));

		

	    System.out.println("code: " + code);
	    System.out.println("unit Id: " + unitId);
	    System.out.println("teacher Id: " + teacherId);
	    System.out.println("semester Id: " + semesterId);

		// Fetch related entities from the database
		CourseDefinitionModel courseDefinition = courseDefinitionDao.selectCourseDefinition(code);
		AcademicUnit academicUnit = AcademicUnitDao.selectAcademicUnit(unitId);
		TeacherModel teacher = teacherDao.selectTeacher(teacherId);
		SemesterModel semester = semesterDao.selectSemester(semesterId);

		// Create a CourseModel object and set related entities
		CourseModel courseDetails = new CourseModel();
		courseDetails.setCourseDefinition(courseDefinition);
		courseDetails.setAcademicUnit(academicUnit);
		courseDetails.setTeacher(teacher);
		courseDetails.setSemester(semester);
	    courseDetails.setCredit(credit);

		// Now, you can create the Course
		courseDao.createCourse(courseDetails);
	    response.sendRedirect("CourseList");

	}
	
	private void deleteCourse(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		courseDao.deleteCourse(id);
		 response.sendRedirect("CourseList");
	}
	
	
	
	//   ++++++++++++ STUDENT REGISTRATION +++++++++++++++++++++
	
	private void showNewFormRegistration(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		List<StudentDetailsModel> students = studentDetailsModel.selectAllStudents();
		
		 if (students != null && !students.isEmpty()) {
		       
		        request.setAttribute("student", students);
		    } else {
		        // If the list is empty or null, you can remove the attribute
		        request.removeAttribute("student");
		    }
		 
		 
		 List<AcademicUnit> departments = AcademicUnitDao.selectAcademicUnitsByType(AcademicUnit.UnityType.DEPARTMENT);
		    if (departments != null && !departments.isEmpty()) {
		       
		        request.setAttribute("departments", departments);
		    } else {
		        // If the list is empty or null, you can remove the attribute
		        request.removeAttribute("departments");
		    }
	    
	    List<SemesterModel> listSemesters = semesterDao.selectAllSemesters();
	    if (listSemesters != null && !listSemesters.isEmpty()) {
		       
	        request.setAttribute("semesters", listSemesters);
	    } else {
	        request.removeAttribute("semesters");
	    }
		RequestDispatcher dispatcher = request.getRequestDispatcher("student/student-registration-form.jsp");
		dispatcher.forward(request, response);
	}
	
	private void RegisterStudent(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
	    int studentId = Integer.parseInt(request.getParameter("student"));
	    int departmentId = Integer.parseInt(request.getParameter("department"));
	    int semesterId = Integer.parseInt(request.getParameter("semester"));
	    LocalDate date = LocalDate.parse(request.getParameter("date"));

	    try {
	        // Fetch related entities from the database
	        StudentDetailsModel students = studentDetailsModel.selectStudent(studentId);
	        AcademicUnit department = AcademicUnitDao.selectAcademicUnit(departmentId);
	        SemesterModel semester = semesterDao.selectSemester(semesterId);

	        // Check if any of the entities are null
	        if (students == null || department == null || semester == null) {
	            // Handle the case where one of the entities is not found
	            response.sendRedirect("ErrorPage"); // Redirect to an error page
	            return;
	        }

	        // Create a CourseModel object and set related entities
	        StudentRegistrationModel RegistrationDetails = new StudentRegistrationModel();
	        RegistrationDetails.setStudent(students);
	        RegistrationDetails.setAcademicUnit(department);
	        RegistrationDetails.setSemester(semester);
	        RegistrationDetails.setRegistrationDate(date);

	        // Now, you can create the registration
	        studentRegistrationDao.save(RegistrationDetails);
	        response.sendRedirect("RegisterList");
	    } catch (Exception e) {
	        e.printStackTrace(); // Log the exception
	        response.sendRedirect("ErrorPage"); // Redirect to an error page
	    }
	}
	
	private void listOfRegistrations(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		List<StudentRegistrationModel> registrations = studentRegistrationDao.getAll();
	    if (registrations != null && !registrations.isEmpty()) {
		       
	        request.setAttribute("listofregisters", registrations);
	    } else {
	        request.removeAttribute("listofregisters");
	    }
		RequestDispatcher dispatcher = request.getRequestDispatcher("student/student-registration-list.jsp");
		dispatcher.forward(request, response);
	}
	
	private void deleteRegistration(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		studentRegistrationDao.delete(id);
		 response.sendRedirect("RegisterList");
	}
	

	
	// ++++++++++++++   ASSIGN COURSE HERE ++++++++++++++++
	
	private void showNewFormAssign(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    int id = Integer.parseInt(request.getParameter("id"));
	    System.out.println("ID ID : " + id);

	    StudentRegistrationModel student = studentRegistrationDao.getById(id);

	    if (student != null) {
	        request.setAttribute("student", student);

	        // Retrieve the academic unit associated with the student
	        AcademicUnit academicUnit = student.getAcademicUnit();

	        if (academicUnit != null) {
	            // Get courses for the academic unit
	            List<CourseModel> courses = courseDao.getCoursesByAcademicUnit(academicUnit);
	            if (courses != null && !courses.isEmpty()) {
	                request.setAttribute("courses", courses);
	            } else {
	                // If the list is empty or null, you can remove the attribute
	                request.removeAttribute("courses");
	            }
	        }
	    } else {
	        // If the student is not found, you can remove the attribute
	        request.removeAttribute("student");
	    }
	    
        request.setAttribute("studentId", id);

	    RequestDispatcher dispatcher = request.getRequestDispatcher("course/assign-course-form.jsp");
	    dispatcher.forward(request, response);
	}

	
	private void listOfAssignedCourses(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		
	    int id = Integer.parseInt(request.getParameter("id"));
	    List<StudentCourseRegistration> coursesTaken = studentCourseRegistrationDao.getAllByStudentRegistrationId(id);
	    if (coursesTaken != null && !coursesTaken.isEmpty()) {
		       
	        request.setAttribute("listofcoursesTaken", coursesTaken);
	    } else {
	        request.removeAttribute("listofcoursesTaken");
	    }
        request.setAttribute("studentId", id);
		RequestDispatcher dispatcher = request.getRequestDispatcher("course/assign-course-list.jsp");
		dispatcher.forward(request, response);
	}
	
	private void AssignStudentCourse(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
	    int studentId = Integer.parseInt(request.getParameter("id"));
	    int courseId = Integer.parseInt(request.getParameter("code"));

	    try {
	        // Fetch related entities from the database
	    	CourseModel courses = courseDao.getCourseById(courseId);
	    	StudentRegistrationModel students = studentRegistrationDao.getById(studentId);



	        // Check if any of the entities are null
	        if (students == null || courses == null) {
	            // Handle the case where one of the entities is not found
	            response.sendRedirect("ErrorPage"); // Redirect to an error page
	            return;
	        }

	        // Create a CourseModel object and set related entities
	        StudentCourseRegistration AssignDetails = new StudentCourseRegistration();
	        AssignDetails.setCourse(courses);
	        AssignDetails.setStudentRegistration(students);
	      

	        // Now, you can create the registration
	        studentCourseRegistrationDao.save(AssignDetails);
	        
	        StudentRegistrationModel studentRegistration = studentRegistrationDao.getById(studentId);
	        studentRegistration.setTotalCredits(studentRegistration.getTotalCredits() + courses.getCredit());
	        studentRegistrationDao.update(studentRegistration);

//	        studentRegistrationDao.update(studentRegistration);
	        response.sendRedirect("AssignList?id=" + studentId);

	    } catch (Exception e) {
	        e.printStackTrace(); // Log the exception
	        response.sendRedirect("ErrorPage"); // Redirect to an error page
	    }
	}
	
	
	
	// ++++++++++++ REPORTS ++++++++++++++++++++
	
	
	private void listOfAllStudentInParticularSemester(HttpServletRequest request, HttpServletResponse response)
		    throws SQLException, IOException, ServletException {
		    
		    int id = Integer.parseInt(request.getParameter("id"));

		    // Assuming you have a SemesterDao instance called semesterDao
		    SemesterModel semester = semesterDao.selectSemester(id);

		    if (semester != null) {
		        List<StudentRegistrationModel> studentsInSemester = semesterDao.getStudentsRegisteredInSemester(semester);

		        // Iterate through the list and print student information
		        for (StudentRegistrationModel studentRegistration : studentsInSemester) {
		            System.out.println("Student Name: " + studentRegistration.getStudent().getNames());
		            System.out.println("Registration Date: " + studentRegistration.getRegistrationDate());
		            System.out.println("Other Student Information...");

		            // You can also use logger instead of System.out.println for better logging
		        }

		        request.setAttribute("studentsInSemester", studentsInSemester);
		    }

		    RequestDispatcher dispatcher = request.getRequestDispatcher("semester/semester-report.jsp");
		    dispatcher.forward(request, response);
		}

	
	
	

}
