package com.helpdesk.backend.apirest.models.services;

import java.util.List;

public interface IEmployeeService {
	
	public List<com.helpdesk.backend.apirest.models.entity.Employee> findAll();
	
	public void save(com.helpdesk.backend.apirest.models.entity.Employee employee);
	
	public com.helpdesk.backend.apirest.models.entity.Employee findById(Long id);
	
	public void delete(com.helpdesk.backend.apirest.models.entity.Employee employee);

}
