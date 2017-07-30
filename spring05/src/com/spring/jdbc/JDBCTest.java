package com.spring.jdbc;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;

public class JDBCTest {

	private ApplicationContext ctx =null;
	private JdbcTemplate jdbcTemplate;
	private EmployeeDao employeeDao;
	private DepartmentDao departmentDao;
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	{
		ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		jdbcTemplate=(JdbcTemplate) ctx.getBean("jdbcTemplate");
		employeeDao = ctx.getBean(EmployeeDao.class);
		departmentDao=ctx.getBean(DepartmentDao.class);
		namedParameterJdbcTemplate=ctx.getBean(NamedParameterJdbcTemplate.class);
	}
	/**
	 * 使用具名参数
	 */
	@Test
	public void testNamedParameterJdbcTemplate2(){
		String sql = "INSERT INTO employes(last_name,email,depi_id) "
				+ "VALUES(:lastName,:email,:deptId)";
	    Employee employee = new Employee();
	    employee.setLastName("ss");
	    employee.setEmail("ss@163.com");
	    employee.setDeptId(3);
        SqlParameterSource paramSource = new BeanPropertySqlParameterSource(employee);	    
        namedParameterJdbcTemplate.update(sql, paramSource);
	}
	
	/**
	 * 可以为参数起名字，使用具名参数   
	 * 1.SQL语句中的参数名和类的属性一致
	 */
	@Test
	public void testNamedParameterJdbcTemplate(){
		String sql = "INSERT INTO `employes`(last_name,email,depi_id) VALUES(:ln,:email,:deptid)";
		Map<String, Object> paramMap = new HashMap<>();
		paramMap.put("ln", "FF");
		paramMap.put("email", "ff@163.com");
		paramMap.put("deptid", 2);
		namedParameterJdbcTemplate.update(sql, paramMap);
	}
	
	//第二种方法，不常用
	@Test
	public void testDepartmentDao(){
		System.out.println(departmentDao.get(1));
	}
	//第二种方法，不常用
	@Test
	public void testEmployeeDao(){
		System.out.println(employeeDao.get(1));
	}
	
	/**
	 * 从数据库中、获取一条记录，实际得到对应的一个对象
	 * 需要调用<Employee> rowMapper = new BeanPropertyRowMapper<>(Employee.class);方法
	 * 1.其中的RowMaper指定如何去映射结果集的行，常用的实现类为BeanPropertyRowMaper
	 * 2.使用SQL中类的别名完成列名和类的属性别名的映射
	 * 3.不支持级联属性   department为null
	 * 	 */
	@Test
	public void testQueryForIbject(){
		String sql = "SELECT id,last_name,email FROM `employes` WHERE id=?";
		org.springframework.jdbc.core.RowMapper<Employee> rowMapper = new BeanPropertyRowMapper<>(Employee.class);
		Employee employee = jdbcTemplate.queryForObject(sql, rowMapper,1);
		System.out.println(employee);
	}
	/**
	 * 获取单个列的值，或统计数据的个数
	 * 使用的是queryForObject(String sql, Class<Long> requiredType) 方法
	 */
	@Test
	public void testQueryForObject2(){
		String sql = "SELECT count(id) FROM `employes`";
		Long count = jdbcTemplate.queryForObject(sql, Long.class);
		System.out.println(count);
	}
	/**
	 * 查询到实体类的集合
	 * 使用的是query(String sql, RowMapper<Employee> rowMapper, Object... args方法
	 */
	@Test
	public void testQueryForList(){
		String sql = "SELECT id,last_name,email,depi_id  FROM `employes` WHERE id >?";
		org.springframework.jdbc.core.RowMapper<Employee> rowMapper = new BeanPropertyRowMapper<>(Employee.class);
		List<Employee> employees = jdbcTemplate.query(sql, rowMapper,5);
		System.out.println(employees);
	}
	
	/**
	 * 执行批量的更新：INSERT,UPDATE,DELECT
	 * 最后一个参数是Object[]的List类型，因为修改一条记录需要一个Object的数组，多条就需要多个Object的数组
	 */
	@Test
	public void testBatchUpdate(){
		String sql = "INSERT INTO employes(id,last_name,email,depi_id) VALUES(?,?,?,?)";
		List<Object[]> batchArgs = new ArrayList<>();
		batchArgs.add(new Object[]{7,"AA","aa@qq.com",2});
		batchArgs.add(new Object[]{8,"BB","bb@qq.com",1});
		batchArgs.add(new Object[]{9,"CC","cc@qq.com",1});
		batchArgs.add(new Object[]{10,"DD","dd@qq.com",2});
		jdbcTemplate.batchUpdate(sql, batchArgs);
	}
	/**
	 * 执行UPDATE,INSERT,DELETE
	 */
	@Test
	public void testUpdate(){
		String sql = "UPDATE `employes` LAST_NAME = ?  WHERE id=？";
		jdbcTemplate.update(sql,"z",4);
	}
	@Test 
	public void testDataSource()throws SQLException{
		DataSource dataSource = ctx.getBean(DataSource.class);
	    System.out.println(dataSource.getConnection());
	}

}
