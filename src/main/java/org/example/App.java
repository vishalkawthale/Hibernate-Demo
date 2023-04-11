package org.example;

import org.example.data.Address;
import org.example.data.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {

        SessionFactory sessionFactory = new Configuration()
                .configure("/org/example/data/hibernate.cfg.xml")
                .buildSessionFactory();

        try(Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();

            Employee employee = new Employee( "Saurabh", "Bhoyar", new Address("IT Park", "Nagpur", "Maharashtra"));

            session.merge(employee);

            transaction.commit();
            System.out.println("Record added");
        }


    }
}
