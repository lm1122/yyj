package cn.itcast.crm.service;

import java.util.List;

import javax.jws.WebService;

import cn.itcast.crm.domain.Customer;
@WebService
public interface CustomerService {
	public List<Customer> findAll();
	
	//查询未关联到定区的客户数据
	public List<Customer> findNotAssoction();
	
	//查询关联到某个定区的客户数据
	public List<Customer> findHasAssoction(String fixedAreaID);
	
	public void assignCustomers2FixedArea(String fixedAreaID,Integer[] integers);
	//验证邮箱
	public Boolean validateEmail(String eml);
	//验证手机号
	public Boolean validateTelephone(String tel);
	//注册保存客户
	public void save(Customer customer);
	//查询账户状态
	public Customer findByTelephone(String tel);
	//激活账户
	public void activeAccount(Integer customerId);
	//客户登录
	public Customer login(String tel,String password);
	//根据地址查询定区id
	public String findFixedAreaIdByAddress(String address);
	
}
