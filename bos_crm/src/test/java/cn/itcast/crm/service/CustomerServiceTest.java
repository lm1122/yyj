package cn.itcast.crm.service;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cn.itcast.crm.domain.Customer;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class CustomerServiceTest {

	@Autowired
	private CustomerService customerService;
	@Test
	public void testFindNotAssoction() {
		List<Customer> list = customerService.findNotAssoction();
		System.out.println(list.size());
	}
	@Test
	public void testFindHasAssoction() {
		List<Customer> list = customerService.findHasAssoction("dq001");
		System.out.println(list.size());
	}
	@Test
	public void testAssignCustomers2FixedArea() {
		Integer[] integers=new Integer[]{1,4};
		customerService.assignCustomers2FixedArea("dq003", null);
		
	}
	

}
