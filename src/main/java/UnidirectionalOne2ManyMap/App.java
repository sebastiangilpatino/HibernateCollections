package UnidirectionalOne2ManyMap;

import java.util.Arrays;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import Utilities.HibernateUtils;

public class App {
	private static SessionFactory sessionFactory;

	static {
	// @formatter:off
		sessionFactory = HibernateUtils
				.getSessionFactory(Arrays.asList(
						School.class, Student.class));
	// @formatter:on
	}

	public static void main(String[] args) {
		Session session = null;
		Transaction tx = null;
		//////////////////////////////////
		try {
			session = sessionFactory.openSession();
			tx = session.beginTransaction();

			School school = new School("Maharishi");

			Student student1 = new Student(612422, "Jorge", "Gil");
			Student student2 = new Student(612458, "Naem", "Haddad");
			Student student3 = new Student(614852, "Maria", "Estrada");

			school.addStudent(student1);
			school.addStudent(student2);
			school.addStudent(student3);

			session.persist(school);

			tx.commit();

		} catch (HibernateException e) {
			tx.rollback();
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}
		//////////////////////////////////////
		try {
			session = sessionFactory.openSession();
			tx = session.beginTransaction();

			Query query = session.createQuery("from School");

			List<School> schoolList = query.list();

			for (School e : schoolList) {
				System.out.println(e);
			}

			tx.commit();
		} catch (HibernateException e) {
			tx.rollback();
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}
		// Close the SessionFactory (not mandatory)
		sessionFactory.close();
	}
}
