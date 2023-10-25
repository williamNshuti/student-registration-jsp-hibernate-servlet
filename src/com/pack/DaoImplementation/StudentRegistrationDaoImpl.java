package com.pack.DaoImplementation;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.pack.dao.StudentRegistrationDao;
import com.pack.model.AcademicUnit;
import com.pack.model.CourseModel;
import com.pack.model.SemesterModel;
import com.pack.model.StudentDetailsModel;
import com.pack.model.StudentRegistrationModel;
import com.pack.util.HibernateUtil;

public class StudentRegistrationDaoImpl implements StudentRegistrationDao {

	@Override
	public void save(StudentRegistrationModel studentRegistration) {
		 Transaction transaction = null;
	        Session session = HibernateUtil.getSessionFactory().openSession();

	        try {
	            // Start a transaction
	            transaction = session.beginTransaction();
	            // Save the Course object
	            session.save(studentRegistration);
	            // Commit the transaction
	            transaction.commit();
	            System.out.println("Student Registered successfully! Thank You.......");
	        } catch (Exception e) {
	            if (transaction != null) {
	                transaction.rollback();
	            }
	            e.printStackTrace();
	        } finally {
	            if (session != null) {
	                session.close(); // Close the session in the finally block
	            }
	        }
	            
	}
	            

	@Override
	public StudentRegistrationModel getById(int id) {
		Transaction transaction = null;
		StudentRegistrationModel registration = null;
	        Session session = HibernateUtil.getSessionFactory().openSession();

	        try {
	            // Start a transaction
	            transaction = session.beginTransaction();
	            // Get a student object
	            registration = session.get(StudentRegistrationModel.class, id);
	            // Commit the transaction
	            transaction.commit();
	        } catch (Exception e) {
	            if (transaction != null) {
	                transaction.rollback();
	            }
	            e.printStackTrace();
	        } finally {
	            if (session != null) {
	                session.close(); // Close the session in the finally block
	            }
	        }
	        
	        return registration;
	}

	@Override
	public List<StudentRegistrationModel> getAll() {
		Transaction transaction = null;
        List<StudentRegistrationModel> regist = null;
        Session session = HibernateUtil.getSessionFactory().openSession();

        try {
            // Start a transaction
            transaction = session.beginTransaction();
            // Retrieve all student records
            regist = session.createQuery("from StudentRegistrationModel", StudentRegistrationModel.class).getResultList();
            // Commit the transaction
            transaction.commit();
            System.out.println("Select registration done successfully! Thank You.......");
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            if (session != null) {
                session.close(); // Close the session in the finally block
            }
        }
        return regist;

	}

	
	@Override
    public void update(StudentRegistrationModel studentRegistration) {
        Transaction transaction = null;
        Session session = HibernateUtil.getSessionFactory().openSession();

        try {
            // Start a transaction
            transaction = session.beginTransaction();
            // Update the student registration
            session.update(studentRegistration);
            // Commit the transaction
            transaction.commit();
            System.out.println("Student Registration updated successfully! Thank You.......");
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

	@Override
	public boolean delete(int id) {
		Transaction transaction = null;
	    Session session = HibernateUtil.getSessionFactory().openSession();
	        try {
	            // Start a transaction
	            transaction = session.beginTransaction();
	            // Get the student to delete
	            StudentRegistrationModel student = session.get(StudentRegistrationModel.class, id);
	            if (student != null) {
	                session.delete(student);
	                System.out.println("Registration is deleted");
	                transaction.commit();
	                return true;
	            }
	            System.out.println("Registration not found");
	            transaction.commit();
	            return false;
	        } catch (Exception e) {
	            if (transaction != null) {
	                transaction.rollback();
	            }
	            e.printStackTrace();
	            return false;
	        } finally {
	            if (session != null) {
	                session.close(); // Close the session in the finally block
	            }
	        }

	}
	
	 @Override
	    public List<StudentDetailsModel> getStudentsByDepartmentAndSemester(AcademicUnit department, SemesterModel semester) {
	        Transaction transaction = null;
	        List<StudentDetailsModel> students = new ArrayList<>();
	        Session session = HibernateUtil.getSessionFactory().openSession();

	        try {
	            // Start a transaction
	            transaction = session.beginTransaction();

	            // Use an HQL query to fetch students by department and semester
	            String hql = "SELECT sr.student FROM StudentRegistrationModel sr " +
	                         "WHERE sr.academicUnit = :department " +
	                         "AND sr.semester = :semester";

	            students = session.createQuery(hql, StudentDetailsModel.class)
	                .setParameter("department", department)
	                .setParameter("semester", semester)
	                .getResultList();

	            // Commit the transaction
	            transaction.commit();
	            System.out.println("Students by department and semester retrieved successfully! Thank You.......");
	        } catch (Exception e) {
	            if (transaction != null) {
	                transaction.rollback();
	            }
	            e.printStackTrace();
	        } finally {
	            if (session != null) {
	                session.close();
	            }
	        }

	        return students;
	    }

}
