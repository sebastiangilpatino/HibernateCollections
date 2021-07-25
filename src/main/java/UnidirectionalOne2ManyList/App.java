package UnidirectionalOne2ManyList;

import java.time.LocalDate;
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
						Flight.class, Passenger.class));
	// @formatter:on
	}

	public static void main(String[] args) {
		Session session = null;
		Transaction tx = null;
		//////////////////////////////////
		try {
			session = sessionFactory.openSession();
			tx = session.beginTransaction();

			Passenger passenger = new Passenger("Jorge Gil");

			Flight flight1 = new Flight(112, "Dubai", "Las Vegas", LocalDate.now());
			Flight flight2 = new Flight(123, "Detroit", "Los Angeles", LocalDate.of(2021, 12, 10));
			Flight flight3 = new Flight(987, "Cali", "Medellin", LocalDate.of(2021, 12, 24));

			passenger.addFlight(flight1);
			passenger.addFlight(flight2);
			passenger.addFlight(flight3);

			session.persist(passenger);

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

			Query query = session.createQuery("from Passenger");

			List<Passenger> passengerList = query.list();

			for (Passenger e : passengerList) {
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
