package BidirectionalOne2Many;

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
						Employee.class, Laptop.class));
	// @formatter:on
	}

	public static void main(String[] args) {
		Session session = null;
		Transaction tx = null;
		//////////////////////////////////
		try {
			session = sessionFactory.openSession();
			tx = session.beginTransaction();

			Employee employee = new Employee("Jorge", "Gil");
			Laptop laptop1 = new Laptop("ASUS", "Gamer");
			Laptop laptop2 = new Laptop("DELL", "Xps");

			employee.addLaptop(laptop1);
			employee.addLaptop(laptop2);

			session.persist(employee);

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

			Query query = session.createQuery("from Employee");

			List<Employee> empList = query.list();

			for (Employee e : empList) {
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
