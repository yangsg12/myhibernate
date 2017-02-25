package test.java;

import employee.EmployeeEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import org.hibernate.cfg.Configuration;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by Yang on 2017/2/25.
 */
public class LazyTest {
    private SessionFactory sessionFactory;
    private Session session;
    private Transaction transaction;

    @Before
    public void init() {
        Configuration configuration = new Configuration().configure();
        sessionFactory = configuration.buildSessionFactory();
        session = sessionFactory.openSession();
        transaction = session.beginTransaction();
    }

    @After
    public void destroy() {
        transaction.commit();
        session.close();
        sessionFactory.close();
    }

    @Test
    public void test()   {
        EmployeeEntity employeeEntity = session.load(EmployeeEntity.class, 1);
        System.out.println(employeeEntity.getId());
        System.out.println(employeeEntity.getLastName());
        System.out.println(employeeEntity.getFirstName());

    }


}
