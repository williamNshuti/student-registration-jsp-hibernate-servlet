package com.pack.DaoImplementation;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.pack.dao.StudentDetailsDao;
import com.pack.model.StudentDetailsModel;
import com.pack.util.HibernateUtil;

import java.util.List;

public class StudentDaoImpl implements StudentDetailsDao {

    public StudentDaoImpl() {
    }

    @Override
    public void insertStudent(StudentDetailsModel student) {
        Transaction transaction = null;
        Session session = HibernateUtil.getSessionFactory().openSession();

        try {
            // Start a transaction
            transaction = session.beginTransaction();
            // Save the student object
            session.save(student);
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
    public StudentDetailsModel selectStudent(int studentId) {
        Transaction transaction = null;
        StudentDetailsModel student = null;
        Session session = HibernateUtil.getSessionFactory().openSession();

        try {
            // Start a transaction
            transaction = session.beginTransaction();
            // Get a student object
            student = session.get(StudentDetailsModel.class, studentId);
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
    public List<StudentDetailsModel> selectAllStudents() {
        Transaction transaction = null;
        List<StudentDetailsModel> students = null;
        Session session = HibernateUtil.getSessionFactory().openSession();

        try {
            // Start a transaction
            transaction = session.beginTransaction();
            // Retrieve all student records
            students = session.createQuery("from StudentDetailsModel", StudentDetailsModel.class).getResultList();
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
    public boolean deleteStudent(int id) {
        Transaction transaction = null;
        Session session = HibernateUtil.getSessionFactory().openSession();

        try {
            // Start a transaction
            transaction = session.beginTransaction();
            // Get the student to delete
            StudentDetailsModel student = session.get(StudentDetailsModel.class, id);
            if (student != null) {
                session.delete(student);
                System.out.println("Student is deleted");
                transaction.commit();
                return true;
            }
            System.out.println("Student not found");
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
    public void updateStudent(StudentDetailsModel student) {
        Transaction transaction = null;
        Session session = HibernateUtil.getSessionFactory().openSession();

        try {
            // Start a transaction
            transaction = session.beginTransaction();
            // Save or update the student object
            session.saveOrUpdate(student);
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

