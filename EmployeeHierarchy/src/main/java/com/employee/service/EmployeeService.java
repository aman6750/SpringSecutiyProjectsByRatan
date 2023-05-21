package com.employee.service;

import com.employee.dto.employeeDTO;
import com.employee.exception.NoEmployeeException;

public interface EmployeeService {
	
      public employeeDTO addEmployee(employeeDTO empDto);
      
      public employeeDTO assignEmployeeToManager(String empId, String managerId)throws NoEmployeeException;

}
