package com.pack.DaoImplementation;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.pack.dao.CourseDefinitionDao;
import com.pack.model.CourseDefinitionModel;
import com.pack.model.SemesterModel;
import com.pack.util.HibernateUtil;

public class CourseDefinitionDaoImpl implements CourseDefinitionDao {
	
  public CourseDefinitionDaoImpl() {
	  
  }
	@Override
	public void insertCourseDefinition(CourseDefinitionModel courseDefinition) {
		 
		
		Transaction transaction = null;
        Session session = HibernateUtil.getSessionFactory().openSession();

        try {
            // Start a transaction
            transaction = session.beginTransaction();
            // Save the student object
            session.save(courseDefinition);
            // Commit the transaction
            transaction.commit();
            System.out.println("Insertion done successfully! Thank You.......");
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
	public CourseDefinitionModel selectCourseDefinition(int courseDefinitionId) {
		 Transaction transaction = null;
		 CourseDefinitionModel student = null;
	        Session session = HibernateUtil.getSessionFactory().openSession();

	        try {
	            // Start a transaction
	            transaction = session.beginTransaction();
	            // Get a student object
	            student = session.get(CourseDefinitionModel.class, courseDefinitionId);
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
	        return student;
	}

	@Override
	public List<CourseDefinitionModel> selectAllCourseDefinitions() {
		Transaction transaction = null;
        List<CourseDefinitionModel> students = null;
        Session session = HibernateUtil.getSessionFactory().openSession();

        try {
            // Start a transaction
            transaction = session.beginTransaction();
            // Retrieve all student records
            students = session.createQuery("from CourseDefinitionModel", CourseDefinitionModel.class).getResultList();
            // Commit the transaction
            transaction.commit();
            System.out.println("Select done successfully! Thank You.......");
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
        return students;
	}

	@Override
	public boolean deleteCourseDefinition(int id) {
		
		Transaction transaction = null;
        Session session = HibernateUtil.getSessionFactory().openSession();

        try {
            // Start a transaction
            transaction = session.beginTransaction();
            // Get the student to delete
            CourseDefinitionModel student = session.get(CourseDefinitionModel.class, id);
            if (student != null) {
                session.delete(student);
                System.out.println("Semester is deleted");
                transaction.commit();
                return true;
            }
            System.out.println("Semester not found");
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
	public void updateCourseDefinition(CourseDefinitionModel courseDefinition) {
		 Transaction transaction = null;
	        Session session = HibernateUtil.getSessionFactory().openSession();

	        try {
	            // Start a transaction
	            transaction = session.beginTransaction();
	            // Save or update the student object
	            session.saveOrUpdate(courseDefinition);
	            // Commit the transaction
	            transaction.commit();
	            System.out.println("Update done successfully! Thank You.......");
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
	}


