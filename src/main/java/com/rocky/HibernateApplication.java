package com.rocky;

import com.rocky.model.Address;
import com.rocky.model.Employee;
import com.rocky.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.text.ParseException;
import java.text.SimpleDateFormat;

public class HibernateApplication {
    public static void main(String[] args) throws ParseException {
        Employee emp = new Employee("Anil Reddy", 75000000.0, "9182519137", new SimpleDateFormat("yyyy-MM-dd").parse("1994-03-27"));

        emp.setHomeAddress(new Address("Nakkavanipalem", "Opp MRO Office", "Visakhapatnam", "AP", "530013"));
        emp.setOfficeAddress(new Address("Hitech City", "Google Office", "Hyderabad", "Telangana", "500084"));


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
