package com.pack.DaoImplementation;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.pack.dao.TeacherDao;
import com.pack.model.SemesterModel;
import com.pack.model.TeacherModel;
import com.pack.util.HibernateUtil;

public class TeacherDaoImpl implements TeacherDao {

	@Override
	public void insertTeacher(TeacherModel teacher) {
		 Transaction transaction = null;
	        Session session = HibernateUtil.getSessionFactory().openSession();

	        try {
	            // Start a transaction
	            transaction = session.beginTransaction();
	            // Save the student object
	            session.save(teacher);
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
	public TeacherModel selectTeacher(int teacherId) {
		 Transaction transaction = null;
	        TeacherModel student = null;
	        Session session = HibernateUtil.getSessionFactory().openSession();

	        try {
	            // Start a transaction
	            transaction = session.beginTransaction();
	            // Get a student object
	            student = session.get(TeacherModel.class, teacherId);
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
	public List<TeacherModel> selectAllTeachers() {
		Transaction transaction = null;
        List<TeacherModel> students = null;
        Session session = HibernateUtil.getSessionFactory().openSession();

        try {
            // Start a transaction
            transaction = session.beginTransaction();
            // Retrieve all student records
            students = session.createQuery("from TeacherModel", TeacherModel.class).getResultList();
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
	public boolean deleteTeacher(int id) {
		 Transaction transaction = null;
	        Session session = HibernateUtil.getSessionFactory().openSession();

	        try {
	            // Start a transaction
	            transaction = session.beginTransaction();
	            // Get the student to delete
	            TeacherModel student = session.get(TeacherModel.class, id);
	            if (student != null) {
	                session.delete(student);
	                transaction.commit();
	                return true;
	            }
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
	public void updateTeacher(TeacherModel teacher) {
		 Transaction transaction = null;
	        Session session = HibernateUtil.getSessionFactory().openSession();

	        try {
	            // Start a transaction
	            transaction = session.beginTransaction();
	            // Save or update the student object
	            session.saveOrUpdate(teacher);
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
	    }
	}


