import employee.EmployeeEntity;
import org.hibernate.*;
import org.hibernate.cfg.Configuration;

import javax.persistence.Table;
import javax.persistence.criteria.CriteriaBuilder;
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
        me.delEmp(12);
        me.listEmp();


    }

    public Integer addEmployee(String fname, String lname, int salary) {
        Session session = factory.openSession();
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
                System.out.println("First name : " + employeeEntity.getFirstName());
                System.out.println("Last  name : " + employeeEntity.getLastName());
                System.out.println("Salary     : " + employeeEntity.getSalary());
                System.out.println("ID    : " + employeeEntity.getId());
                System.out.println("---------------------");
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


    public void updateEmp(Integer id, int salary) {
        Session session = factory.openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();

            System.out.println("update ....");
            EmployeeEntity employeeEntity = session.get(EmployeeEntity.class, id);
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

    public void delEmp(Integer id) {
        Session session = factory.openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            updateEmp(id, 200);// 先更新

            EmployeeEntity employeeEntity = session.get(EmployeeEntity.class, id);
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
