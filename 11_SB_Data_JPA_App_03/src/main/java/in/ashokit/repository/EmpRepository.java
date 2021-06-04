package in.ashokit.repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import in.ashokit.entity.Employee;

public interface EmpRepository extends CrudRepository<Employee, Serializable>{
		
		//public Employee findByEmpName(String name);
		//public Employee findByEmpSal(Double sal);

		//If more than one Employee have same name or same salary
		//then we need to  define collection list  as List<Employee>
		
		//These are the findby() methods used in crud repository
		public List<Employee> findByEmpName(String name);
		public List<Employee> findByEmpSal(Double sal);
		public List<Employee> findByEmpNameAndEmpSal(String name,Double Sal);
		public List<Employee> findByEmpSalIsGreaterThan(Double empSal);
		public List<Employee> findByEmpNameIn(List<String> names);
		
		//Custom Queries to perform crud repository operation
		//Below custom queries are HQL queries
		@Query("select empSal from Employee where empName=:name")
		public Double findEmpSalByEmpName(String name);

		@Query("select empName from Employee where empId=:eid")
		public String findEmpNameByEmpId(Integer eid);
		
		//Below custom queries are SQL queries
		@Query(value="select count(*) from emp_tbl",nativeQuery=true)
		public Integer getCount();
		
		
}
