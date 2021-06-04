package in.ashokit;

import java.util.Arrays;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import in.ashokit.entity.Employee;
import in.ashokit.repository.EmpRepository;

@SpringBootApplication
public class Application {

	

	public static void main(String[] args) {
		
		ConfigurableApplicationContext context = SpringApplication.run(Application.class, args);
			
		EmpRepository empRepository = context.getBean(EmpRepository.class);
		
		/*Employee findByEmpName = empRepository.findByEmpName("Ashok");
		System.out.println(findByEmpName);
		
		Employee findByEmpSal = empRepository.findByEmpSal(200000.00);
		System.out.println(findByEmpSal);*/
		
		//To retrieve more than one same records in database then
		//we can use collection as List for return type List<Employee>
		
		List<Employee> findByEmpName = empRepository.findByEmpName("Ashok");
		System.out.println(findByEmpName);
		
		List<Employee> findByEmpSal = empRepository.findByEmpSal(200000.00);
		System.out.println(findByEmpSal);
		
		List<Employee> findByEmpNameAndEmpSal = empRepository.findByEmpNameAndEmpSal("Nirvan",300000.00);
		System.out.println(findByEmpNameAndEmpSal);	
		
		//List<Employee> findByEmpSalIsGreaterThan = empRepository.findByEmpSalIsGreaterThan(200000.00);
		//System.out.println(findByEmpSalIsGreaterThan);
		
		//Here we can use Lambda Expression to print the records as our wish
		
		List<Employee> findByEmpSalIsGreaterThan = empRepository.findByEmpSalIsGreaterThan(200000.00);
		findByEmpSalIsGreaterThan.forEach(emp ->{
			System.out.println(emp);
		});
		
		List<Employee> findByEmpNameIn = empRepository.findByEmpNameIn(Arrays.asList("Saroj","Nirvan"));
		
		findByEmpNameIn.forEach(emp -> {
			System.out.println(emp);
		});
		
		Double salary= empRepository.findEmpSalByEmpName("Atharv");
		System.out.println(salary);
		
		String findEmpNameByEmpId = empRepository.findEmpNameByEmpId(1006);
		System.out.println(findEmpNameByEmpId);
		
		Integer count = empRepository.getCount();
		System.out.println(count);
	}
	
			
			 
}
			
	


