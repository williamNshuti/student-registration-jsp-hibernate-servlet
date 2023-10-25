package com.pack.DaoImplementation;

import java.sql.SQLException;
import org.hibernate.query.Query;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.pack.dao.AcademicUnitDao;
import com.pack.model.AcademicUnit;
import com.pack.model.AcademicUnit.UnityType;
import com.pack.util.HibernateUtil;

public class AcademicUnitDaoImpl implements AcademicUnitDao {
	
	public AcademicUnitDaoImpl() {
	
	}

	@Override
	public void insertAcademicUnit(AcademicUnit academic) throws SQLException {
	    Transaction transaction = null;
	    Session session = HibernateUtil.getSessionFactory().openSession();
	    
	    try {
	        // Start a transaction
	        transaction = session.beginTransaction();
	        // Save the Academic Unit object
	        session.save(academic);
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
	public AcademicUnit selectAcademicUnit(int academicUnitId) {
		Transaction transaction = null;
		AcademicUnit academicunit = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			// start a transaction
			transaction = session.beginTransaction();
			// get an academic unit object
			academicunit = session.get(AcademicUnit.class, academicUnitId);
			// commit transaction
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
		return academicunit;
	}

	@Override
	public List<AcademicUnit> selectAllAcademicUnit() {
	    Transaction transaction = null;
	    List<AcademicUnit> academic = null;
	    Session session = HibernateUtil.getSessionFactory().openSession(); // Open the session outside of the try block

	    try {
	        // Start a transaction
	        transaction = session.beginTransaction();
	        // Retrieve all academic units
	        academic = session.createQuery("from AcademicUnit", AcademicUnit.class).getResultList();
	        // Commit the transaction
	        transaction.commit();
	        

	    } catch (Exception e) {
	        if (transaction != null) {
	            transaction.rollback();
	        }
	        e.printStackTrace();
	    } finally {
	        if (session != null && session.isOpen()) {
	            session.close(); // Close the session in the finally block if it's open
	        }
	    }
	    return academic;
	}


	@Override
	public boolean deleteAcademicUnit(int id) throws SQLException {
		Transaction transaction = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			// start a transaction
			transaction = session.beginTransaction();

			AcademicUnit academic = session.get(AcademicUnit.class, id);
			if (academic != null) {
				session.delete(academic);
				System.out.println("Academic Unit is deleted");
				return true;
			}
			// commit transaction
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public void updateAcademicUnit(AcademicUnit academic) throws SQLException {
		Transaction transaction = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			// start a transaction
			transaction = session.beginTransaction();
			// save the student object
			session.saveOrUpdate(academic);
			// commit transaction
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}

		
	}
	
	public List<AcademicUnit> selectAcademicUnitsByType(UnityType unityType) {
	    Transaction transaction = null;
	    List<AcademicUnit> academicUnits = null;
	    Session session = HibernateUtil.getSessionFactory().openSession();

	    try {
	        // Start a transaction
	        transaction = session.beginTransaction();

	        // Create an HQL query to select academic units by unity_type
	        Query<AcademicUnit> query = session.createQuery("from AcademicUnit where unityType = :unityType", AcademicUnit.class);
	        query.setParameter("unityType", unityType);

	        // Execute the query and get the results
	        academicUnits = query.getResultList();

	        // Commit the transaction
	        transaction.commit();
	    } catch (Exception e) {
	        if (transaction != null) {
	            transaction.rollback();
	        }
	        e.printStackTrace();
	    } finally {
	        if (session != null && session.isOpen()) {
	            session.close();
	        }
	    }
	    return academicUnits;
	}

}
