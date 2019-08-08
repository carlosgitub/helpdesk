package com.helpdesk.backend.apirest.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class EmployeeServiceImpl implements IEmployeeService{

	@Autowired
	private com.helpdesk.backend.apirest.models.dao.IEmployeeDao employeeDao;
	
	@Override
	@Transactional(readOnly = true)
	public List<com.helpdesk.backend.apirest.models.entity.Employee> findAll() {
		return (List<com.helpdesk.backend.apirest.models.entity.Employee>) employeeDao.findAll();
	}

	@Override
	@Transactional
	public void save(com.helpdesk.backend.apirest.models.entity.Employee employee) {
		employeeDao.save(employee);
	}

	@Override
	@Transactional(readOnly = true)
	public com.helpdesk.backend.apirest.models.entity.Employee findById(Long id) {
		return employeeDao.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public void delete(com.helpdesk.backend.apirest.models.entity.Employee employee) {
		employeeDao.delete(employee);
		
	}

}
