package com.luv2code.springdemo.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.luv2code.springdemo.entity.Customer;

@Repository
public class CustomerDAOImpl implements CustomerDAO {

	@Autowired
	private SessionFactory sessionFactory;
			
	@Override
	public List<Customer> getCustomers() {
		
		Session currentSession = sessionFactory.getCurrentSession();
				
		Query<Customer> theQuery = 
				currentSession.createQuery("from Customer order by lastName",
											Customer.class);
		
		List<Customer> customers = theQuery.getResultList();
				
		return customers;
	}

	@Override
	public void saveCustomer(Customer theCustomer) {

		Session currentSession = sessionFactory.getCurrentSession();
		
		currentSession.saveOrUpdate(theCustomer);
		
	}

	@Override
	public Customer getCustomer(int theId) {

		Session currentSession = sessionFactory.getCurrentSession();
		
		Customer theCustomer = currentSession.get(Customer.class, theId);
		
		return theCustomer;
	}

	@Override
	public void deleteCustomer(int id) {
		Session session=sessionFactory.getCurrentSession();
		Query<Customer> theQuery=session.createQuery("delete from Customer where id=:theId ");
		theQuery.setParameter("theId", id);

		theQuery.executeUpdate();
		
		
	}

	@Override
	public List<Customer> searchCustomer(String theSearchName) {
		Query theQuery=null;
		Session session=sessionFactory.getCurrentSession();
		
		if(theSearchName!=null&&theSearchName.trim().length()>0) {
			
				theQuery=session.createQuery("from Customer where"
						+ " lower(firstName) like :theName OR lower(lastName) like :theName",Customer.class);
				
				theQuery.setParameter("theName", "%"+theSearchName.toLowerCase()+"%");
			
		}
		else {
			theQuery=session.createQuery("from Customer",Customer.class);
		}
		List<Customer>customers=theQuery.getResultList();
		
		return customers;
	}

}






