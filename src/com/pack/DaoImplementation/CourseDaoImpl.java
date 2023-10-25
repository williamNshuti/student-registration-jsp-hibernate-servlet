package com.pack.DaoImplementation;

import java.util.List;

import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.pack.dao.CourseDao;
import com.pack.model.AcademicUnit;
import com.pack.model.CourseModel;
import com.pack.util.HibernateUtil;

public class CourseDaoImpl implements CourseDao {

	@Override
	public void createCourse(CourseModel course) {
		 Transaction transaction = null;
	        Session session = HibernateUtil.getSessionFactory().openSession();

	        try {
	            // Start a transaction
	            transaction = session.beginTransaction();
	            // Save the Course object
	            session.save(course);
	            // Commit the transaction
	            transaction.commit();
	            System.out.println("Course Insertion done successfully! Thank You.......");
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
	public CourseModel getCourseById(int id) {
		 Transaction transaction = null;
		 CourseModel student = null;
	        Session session = HibernateUtil.getSessionFactory().openSession();

	        try {
	            // Start a transaction
	            transaction = session.beginTransaction();
	            // Get a student object
	            student = session.get(CourseModel.class, id);
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
	public List<CourseModel> getAllCourses() {
		Transaction transaction = null;
        List<CourseModel> course = null;
        Session session = HibernateUtil.getSessionFactory().openSession();

        try {
            // Start a transaction
            transaction = session.beginTransaction();
            // Retrieve all student records
            course = session.createQuery("from CourseModel", CourseModel.class).getResultList();
            // Commit the transaction
            transaction.commit();
            System.out.println("Select Course done successfully! Thank You.......");
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
        return course;

	}

	@Override
	public void updateCourse(CourseModel course) {
		 Transaction transaction = null;
	        Session session = HibernateUtil.getSessionFactory().openSession();

	        try {
	            // Start a transaction
	            transaction = session.beginTransaction();
	            // Save or update the student object
	            session.saveOrUpdate(course);
	            // Commit the transaction
	            transaction.commit();
	            System.out.println("Update Course done successfully! Thank You.......");
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
	public boolean deleteCourse(int id) {
		Transaction transaction = null;
	    Session session = HibernateUtil.getSessionFactory().openSession();
	        try {
	            // Start a transaction
	            transaction = session.beginTransaction();
	            // Get the student to delete
	            CourseModel student = session.get(CourseModel.class, id);
	            if (student != null) {
	                session.delete(student);
	                System.out.println("Course is deleted");
	                transaction.commit();
	                return true;
	            }
	            System.out.println("Course not found");
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
	    public List<CourseModel> getCoursesByAcademicUnit(AcademicUnit academicUnit) {
	        Transaction transaction = null;
	        List<CourseModel> courses = null;
	        Session session = HibernateUtil.getSessionFactory().openSession();

	        try {
	            // Start a transaction
	            transaction = session.beginTransaction();

	            // Create a CriteriaBuilder and CriteriaQuery
	            CriteriaBuilder builder = session.getCriteriaBuilder();
	            CriteriaQuery<CourseModel> criteriaQuery = builder.createQuery(CourseModel.class);

	            // Define the root entity and join the AcademicUnit
	            Root<CourseModel> root = criteriaQuery.from(CourseModel.class);
	            Join<CourseModel, AcademicUnit> academicUnitJoin = root.join("academicUnit", JoinType.INNER);

	            // Add a predicate for filtering by academic unit
	            criteriaQuery.where(builder.equal(academicUnitJoin.get("id"), academicUnit.getId()));

	            // Execute the query and return the result as a list of courses
	            courses = session.createQuery(criteriaQuery).getResultList();

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

	        return courses;
	    }
}
