package com.rocky;

import com.rocky.model.Employee;
import com.rocky.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class HibernateApplication {
    public static void main(String[] args) {
        Employee emp = new Employee("Anil Reddy", 75000.0);

        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;

        try {
            tx = session.beginTransaction();
            session.save(emp);
            tx.commit();
            System.out.println("Employee inserted successfully!");
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }
}
