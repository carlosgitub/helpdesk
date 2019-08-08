package com.helpdesk.backend.apirest.models.dao;

import org.springframework.data.repository.CrudRepository;

public interface IEmployeeDao extends CrudRepository<com.helpdesk.backend.apirest.models.entity.Employee, Long>{

}
