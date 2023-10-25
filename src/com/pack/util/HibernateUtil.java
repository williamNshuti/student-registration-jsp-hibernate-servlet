package com.pack.util;

import java.util.Properties;


import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;

import com.pack.model.AcademicUnit;
import com.pack.model.CourseDefinitionModel;
import com.pack.model.CourseModel;
import com.pack.model.SemesterModel;
import com.pack.model.StudentCourseRegistration;
import com.pack.model.StudentDetailsModel;
import com.pack.model.StudentRegistrationModel;
import com.pack.model.TeacherModel;
import com.pack.model.Todo;


public class HibernateUtil {
	private static SessionFactory sessionFactory;

	public static SessionFactory getSessionFactory() {
		if (sessionFactory == null) {
			try {
				Configuration configuration = new Configuration();

				Properties settings = new Properties();
				settings.put(Environment.DRIVER, "com.mysql.jdbc.Driver");
				settings.put(Environment.URL, "jdbc:mysql://localhost:3306/demo?useSSL=false");
				settings.put(Environment.USER, "root");
				settings.put(Environment.PASS, "");
				settings.put(Environment.DIALECT, "org.hibernate.dialect.MySQL5Dialect");

				settings.put(Environment.SHOW_SQL, "true");

				settings.put(Environment.CURRENT_SESSION_CONTEXT_CLASS, "thread");

				settings.put(Environment.HBM2DDL_AUTO, "update");

				configuration.setProperties(settings);
				
				configuration.addAnnotatedClass(AcademicUnit.class);
				configuration.addAnnotatedClass(StudentDetailsModel.class);
				configuration.addAnnotatedClass(SemesterModel.class);
				configuration.addAnnotatedClass(CourseDefinitionModel.class);
				configuration.addAnnotatedClass(TeacherModel.class);
				configuration.addAnnotatedClass(CourseModel.class);
				configuration.addAnnotatedClass(StudentRegistrationModel.class);
				configuration.addAnnotatedClass(StudentCourseRegistration.class);








				
				ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
						.applySettings(configuration.getProperties()).build();
				System.out.println("Hibernate Java Config serviceRegistry created");
				sessionFactory = configuration.buildSessionFactory(serviceRegistry);
				return sessionFactory;

			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return sessionFactory;
	}
}
