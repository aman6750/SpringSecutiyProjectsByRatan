package com.employee.serviceImpl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employee.Repository.EmployeeRepository;
import com.employee.dto.employeeDTO;
import com.employee.entity.Employee;
import com.employee.exception.NoEmployeeException;
import com.employee.service.EmployeeService;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService{
	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	

	@Override
	public employeeDTO addEmployee(employeeDTO empDto) {
		
		Employee employee = new Employee();
		
		employee.setEmpId(empDto.getEmpId());
		employee.setName(empDto.getName());
		employee.setCtc(empDto.getCtc());
		employee.setState(empDto.getState());
		
//		employee.setManager(null); -> for an employee managerid field will be null , so no need to write it it will be by default null
	
		employeeRepository.save(employee);
		
		return empDto;
		
		
	}
	
	@Override
	public employeeDTO assignEmployeeToManager(String empId, String managerId)throws NoEmployeeException{
		
		// get information of the employee
		
		Employee employee =employeeRepository.findById(empId).orElseThrow(()-> new NoEmployeeException("No Employee exist with id :"+empId));
		
		// get information of the manager
		
		Employee manager =employeeRepository.findById(managerId).orElseThrow(()-> new NoEmployeeException("No Manager exist with id  :"+managerId));
		
		employee.setManager(manager);
		
		manager.getList().add(employee);
		
		employeeRepository.save(manager);
		
	}
	
	
	

}
