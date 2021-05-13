package com.cg.mts.repository;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.cg.mts.Exception.CustomerNotFoundException;
import com.cg.mts.Entity.Customer;
import java.util.Optional;

@Repository
public interface ICustomerRepository extends JpaRepository<Customer, Integer>{
	
	
	public Optional<Customer> findByusername(String username);
	
	@Query("SELECT cu FROM Customer cu")
	public List<Customer> viewCustomers() throws CustomerNotFoundException;
	
	/*
	@Query("SELECT e FROM AbstractUser e WHERE e.username=?1")
	public Optional<Customer> findByUsername(String username);

	
	/*@Query("SELECT cu FROM Customer cu WHERE customerId=?1")
	public Customer viewCustomer(int customerId) throws CustomerNotFoundException;
	
	@Query("INSERT INTO Customer")
	public Customer insertCustomer(Customer customer) ;
	
	
	public Customer updateCustomer(Customer customer) throws CustomerNotFoundException;
	
	public Customer deleteCustomer(Customer customer) throws CustomerNotFoundException;
	
	public List<Customer>viewCustomers() throws CustomerNotFoundException;
	
	public Customer viewCustomer(int customerId) throws CustomerNotFoundException;
	
	@Query("SELECT cu.username, cu.password FROM Customer Cu")
	public Customer validateCustomer(String username, String password) throws CustomerNotFoundException; */
}