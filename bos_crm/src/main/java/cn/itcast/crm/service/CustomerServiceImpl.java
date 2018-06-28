package cn.itcast.crm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.itcast.bos.utils.Md5Util;
import cn.itcast.crm.dao.CustomerDao;
import cn.itcast.crm.domain.Customer;
@Service("customerService")
@Transactional
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerDao customerDao;
	@Override
	public List<Customer> findAll() {
		System.out.println("服务端findAll()方法执行了");
		return customerDao.findAll();
	}
	@Override
	public List<Customer> findNotAssoction() {
		return customerDao.findByfixedAreaIdIsNull();
	}
	@Override
	public List<Customer> findHasAssoction(String fixedAreaID) {
		return customerDao.findByfixedAreaId(fixedAreaID);
	}
	@Override
	public void assignCustomers2FixedArea(String fixedAreaID, Integer[] integers) {
		customerDao.setFixedArea2Null(fixedAreaID);
		if(integers!=null&&integers.length>0){
			for (Integer integer : integers) {
				customerDao.assignCustomers2FixedArea(fixedAreaID,integer);
			}
		}
		
	}
	@Override
	public Boolean validateEmail(String eml) {
		List<Customer> list= customerDao.findByEmail(eml);
		if(list!=null&&list.size()>0){
			return false;
		}
		return true;
	}
	@Override
	public Boolean validateTelephone(String tel) {
		List<Customer> list =customerDao.findByTelephone(tel);
		if(list!=null&&list.size()>0){
			return false;
		}
		return true;
	}
	@Override
	public void save(Customer customer) {
		customer.setPassword(Md5Util.encode(customer.getPassword()));
		customerDao.save(customer);
	}
	@Override
	public Customer findByTelephone(String tel) {
		List<Customer> list= customerDao.findByTelephone(tel);
		if(list!=null&&list.size()>0){
			return list.get(0);
		}
		return null;
	}
	@Override
	public void activeAccount(Integer customerId) {
		customerDao.activeAccount(customerId);
	}
	@Override
	public Customer login(String tel, String password) {
		return customerDao.findByTelephoneAndPassword(tel,password);
	}
	@Override
	public String findFixedAreaIdByAddress(String address) {
		return customerDao.findFixedAreaIdByAddress(address);
	}

}
