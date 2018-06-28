package cn.itcast.crm.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import cn.itcast.crm.domain.Customer;

public interface CustomerDao extends JpaRepository<Customer, Integer> {

	List<Customer> findByfixedAreaIdIsNull();

	List<Customer> findByfixedAreaId(String fixedAreaID);

	@Query("update Customer set fixedAreaId = null where fixedAreaId=?")
	@Modifying
	void setFixedArea2Null(String fixedAreaID);
	@Query("update Customer set fixedAreaId = ? where id=?")
	@Modifying
	void assignCustomers2FixedArea(String fixedAreaID, Integer integer);

	List<Customer> findByEmail(String eml);

	List<Customer> findByTelephone(String tel);
	
	@Query("update Customer set type =1 where id = ?")
	@Modifying
	void activeAccount(Integer customerId);
	
	Customer findByTelephoneAndPassword(String tel, String password);
	@Query("select fixedAreaId from Customer where address = ?")
	String findFixedAreaIdByAddress(String address);

	

}
