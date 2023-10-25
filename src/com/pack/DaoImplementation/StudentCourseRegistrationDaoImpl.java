package com.pack.DaoImplementation;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.pack.dao.StudentCourseRegistrationDao;
import com.pack.model.StudentCourseRegistration;
import com.pack.util.HibernateUtil;
import java.util.List;
import org.hibernate.query.Query;

public class StudentCourseRegistrationDaoImpl implements StudentCourseRegistrationDao {

	@Override
	public StudentCourseRegistration getById(int id) {
		Transaction transaction = null;
		StudentCourseRegistration registration = null;
	        Session session = HibernateUtil.getSessionFactory().openSession();

	        try {
	            // Start a transaction
	            transaction = session.beginTransaction();
	            // Get a student object
	            registration = session.get(StudentCourseRegistration.class, id);
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
	public void save(StudentCourseRegistration studentCourseRegistration) {
		 Transaction transaction = null;
	        Session session = HibernateUtil.getSessionFactory().openSession();

	        try {
	            // Start a transaction
	            transaction = session.beginTransaction();
	            // Save the Course object
	            session.save(studentCourseRegistration);
	            // Commit the transaction
	            transaction.commit();
	            System.out.println("studentCourseRegistratio successfully! Thank You.......");
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
	public List<StudentCourseRegistration> getAllByStudentRegistrationId(int studentRegistrationId) {
	    Transaction transaction = null;
	    List<StudentCourseRegistration> registrations = null;
	    Session session = HibernateUtil.getSessionFactory().openSession();

	    try {
	        // Start a transaction
	        transaction = session.beginTransaction();

	        // Create an HQL query to fetch registrations by studentRegistrationId
	        String hql = "FROM StudentCourseRegistration WHERE studentRegistration.id = :studentRegistrationId";
	        Query<StudentCourseRegistration> query = session.createQuery(hql, StudentCourseRegistration.class);
	        query.setParameter("studentRegistrationId", studentRegistrationId);
	        
	        // Execute the query
	        registrations = query.list();

	        // Commit the transaction
	        transaction.commit();
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
	    
	    return registrations;
	}

	@Override
	public void update(StudentCourseRegistration studentCourseRegistration) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean delete(int id) {
		Transaction transaction = null;
	    Session session = HibernateUtil.getSessionFactory().openSession();
	        try {
	            // Start a transaction
	            transaction = session.beginTransaction();
	            // Get the student to delete
	            StudentCourseRegistration student = session.get(StudentCourseRegistration.class, id);
	            if (student != null) {
	                session.delete(student);
	                System.out.println("StudentCourseRegistration is deleted");
	                transaction.commit();
	                return true;
	            }
	            System.out.println("StudentCourseRegistration not found");
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

}
