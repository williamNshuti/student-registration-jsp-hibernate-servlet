package com.pack.DaoImplementation;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.pack.dao.SemesterDao;
import com.pack.model.SemesterModel;
import com.pack.model.StudentRegistrationModel;
import com.pack.util.HibernateUtil;

public class SemesterDaoImpl implements SemesterDao {
	
	 public SemesterDaoImpl() {
	    }

	@Override
	public void insertSemester(SemesterModel semester) {
		 Transaction transaction = null;
	        Session session = HibernateUtil.getSessionFactory().openSession();

	        try {
	            // Start a transaction
	            transaction = session.beginTransaction();
	            // Save the student object
	            session.save(semester);
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
	public SemesterModel selectSemester(int semesterId) {
		 Transaction transaction = null;
	        SemesterModel student = null;
	        Session session = HibernateUtil.getSessionFactory().openSession();

	        try {
	            // Start a transaction
	            transaction = session.beginTransaction();
	            // Get a student object
	            student = session.get(SemesterModel.class, semesterId);
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
	public List<SemesterModel> selectAllSemesters() {
		Transaction transaction = null;
        List<SemesterModel> students = null;
        Session session = HibernateUtil.getSessionFactory().openSession();

        try {
            // Start a transaction
            transaction = session.beginTransaction();
            // Retrieve all student records
            students = session.createQuery("from SemesterModel", SemesterModel.class).getResultList();
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
	public boolean deleteSemester(int id) {
		 Transaction transaction = null;
	       Session session = HibernateUtil.getSessionFactory().openSession();

	        try {
	            // Start a transaction
	            transaction = session.beginTransaction();
	            // Get the student to delete
	            SemesterModel student = session.get(SemesterModel.class, id);
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
	public void updateSemester(SemesterModel semester) {
		 Transaction transaction = null;
	        Session session = HibernateUtil.getSessionFactory().openSession();

	        try {
	            // Start a transaction
	            transaction = session.beginTransaction();
	            // Save or update the student object
	            session.saveOrUpdate(semester);
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
	
	
	
	 @Override
	    public List<StudentRegistrationModel> getStudentsRegisteredInSemester(SemesterModel semester) {
	        Transaction transaction = null;
	        List<StudentRegistrationModel> studentRegistrations = null;
	        Session session = HibernateUtil.getSessionFactory().openSession();

	        try {
	            transaction = session.beginTransaction();
	            studentRegistrations = session.createQuery("FROM StudentRegistrationModel WHERE semester = :semester", StudentRegistrationModel.class)
	                    .setParameter("semester", semester)
	                    .getResultList();
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

	        return studentRegistrations;
	    }
		
	}




