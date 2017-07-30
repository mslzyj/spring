package com.spring.jdbc;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;
//第二种方法，不常用
@Repository
public class DepartmentDao extends JdbcDaoSupport {
	@Autowired
   public void setDataSouirce2(DataSource dataSource){
	   setDataSource(dataSource);
   }
	public Department get(Integer id){
		String sql = "SELECT id,last_name,email FROM `employes` WHERE id=?";
		org.springframework.jdbc.core.RowMapper<Department> rowMapper = new BeanPropertyRowMapper<>(Department.class);
		return getJdbcTemplate().queryForObject(sql, rowMapper,id);
	}
}
