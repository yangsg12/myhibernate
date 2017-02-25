import employee.EmployeeEntity;
import employee.EmployeeInterceptor;
import org.hibernate.*;
import org.hibernate.cfg.Configuration;

import java.util.Iterator;
import java.util.List;

/**
 * Created by Yang on 2017/2/25.
 */
public class ManageEmployee {
    private static SessionFactory factory;

    public static void main(String[] args) {
        try {
            factory = new Configuration().configure().buildSessionFactory();
        } catch (HibernateException e) {
            e.printStackTrace();
        }

        ManageEmployee me = new ManageEmployee();

        Integer empID1 = me.addEmployee("Zara", "Ali", 2000);
        Integer empID2 = me.addEmployee("Bob", "Lee", 2000);
        Integer empID3 = me.addEmployee("Youtube", "Ali", 3000);
        Integer empID4 = me.addEmployee("Google", "Mike", 2000);
        System.out.println(empID1);

        me.listEmp();
        me.updateEmp(8, 6000);
        me.updateEmp(9, 7000);
        me.updateEmp(10, 6000);
        me.delEmp(16);
        me.listEmp();


    }

    public Integer addEmployee(String fname, String lname, int salary) {
        Session session = factory.openSession();
//        Session session = factory.openSession(new EmployeeInterceptor());

        Transaction transaction = null;
        Integer empID = null;
        try {
            transaction =session.beginTransaction();

            EmployeeEntity employee = new EmployeeEntity(fname, lname, salary);
            empID = ((Integer) session.save(employee));

            transaction.commit();


        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }finally {
            session.close();
        }

        return empID;
    }

    public void listEmp(){
        Session session = factory.openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();

            List employees = session.createQuery("FROM EmployeeEntity ").list();
            for (Iterator iterator = employees.iterator(); iterator.hasNext(); ) {
                EmployeeEntity employeeEntity = ((EmployeeEntity) iterator.next());
                System.out.print(" ID         : " + employeeEntity.getId());
                System.out.print(" First name : " + employeeEntity.getFirstName());
                System.out.print(" Last  name : " + employeeEntity.getLastName());
                System.out.print(" Salary     : " + employeeEntity.getSalary());

                System.out.println();
            }

            transaction.commit();


        } catch (HibernateException e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }finally {
            session.close();
        }
    }


    public void updateEmp(Integer empID, int salary) {
        Session session = factory.openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();

            System.out.println("update ....");
            EmployeeEntity employeeEntity = session.get(EmployeeEntity.class, empID);
            employeeEntity.setSalary(salary);
            session.update(employeeEntity);

            System.out.println("updated "+ employeeEntity.getId());


            transaction.commit();
        } catch (HibernateException e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    public void delEmp(Integer empID) {
        Session session = factory.openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            //updateEmp(id, 200);// 先更新

            EmployeeEntity employeeEntity = session.get(EmployeeEntity.class, empID);
            System.out.println("begin del..." +employeeEntity.getId());
            session.delete(employeeEntity);

            transaction.commit();

        } catch (HibernateException e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }finally {
            session.close();
        }
    }
}
