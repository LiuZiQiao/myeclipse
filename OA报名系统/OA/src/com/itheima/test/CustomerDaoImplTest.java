package com.itheima.test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import com.itheima.dao.CustomerDao;
import com.itheima.dao.impl.CustomerDaoImpl;
import com.itheima.domain.Customer;

public class CustomerDaoImplTest {

	@Test
	public void testFindAll() {
		CustomerDao dao = new CustomerDaoImpl();
		Customer customer = new Customer();
		customer.setId(4);
//		customer.setEmail("abc@123.com");
//		customer.setPhoneNumber("138....");
//		customer.setStatus("火热");
		List<Customer> cs = dao.find(customer);
		System.out.println(cs.size());
	}

}
