package com.spring.jdbc;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
//开发过程中第一种用法
@Repository
public class EmployeeDao {
  private JdbcTemplate jdbcTemplate;
  public Employee get(Integer id){
	  String sql = "SELECT id,last_name,email FROM `employes` WHERE id=?";
		org.springframework.jdbc.core.RowMapper<Employee> rowMapper = new BeanPropertyRowMapper<>(Employee.class);
		Employee employee = jdbcTemplate.queryForObject(sql, rowMapper,id);
		return employee;
  }
}
