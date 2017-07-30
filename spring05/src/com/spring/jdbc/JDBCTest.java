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
	 * ʹ�þ�������
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
	 * ����Ϊ���������֣�ʹ�þ�������   
	 * 1.SQL����еĲ��������������һ��
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
	
	//�ڶ��ַ�����������
	@Test
	public void testDepartmentDao(){
		System.out.println(departmentDao.get(1));
	}
	//�ڶ��ַ�����������
	@Test
	public void testEmployeeDao(){
		System.out.println(employeeDao.get(1));
	}
	
	/**
	 * �����ݿ��С���ȡһ����¼��ʵ�ʵõ���Ӧ��һ������
	 * ��Ҫ����<Employee> rowMapper = new BeanPropertyRowMapper<>(Employee.class);����
	 * 1.���е�RowMaperָ�����ȥӳ���������У����õ�ʵ����ΪBeanPropertyRowMaper
	 * 2.ʹ��SQL����ı������������������Ա�����ӳ��
	 * 3.��֧�ּ�������   departmentΪnull
	 * 	 */
	@Test
	public void testQueryForIbject(){
		String sql = "SELECT id,last_name,email FROM `employes` WHERE id=?";
		org.springframework.jdbc.core.RowMapper<Employee> rowMapper = new BeanPropertyRowMapper<>(Employee.class);
		Employee employee = jdbcTemplate.queryForObject(sql, rowMapper,1);
		System.out.println(employee);
	}
	/**
	 * ��ȡ�����е�ֵ����ͳ�����ݵĸ���
	 * ʹ�õ���queryForObject(String sql, Class<Long> requiredType) ����
	 */
	@Test
	public void testQueryForObject2(){
		String sql = "SELECT count(id) FROM `employes`";
		Long count = jdbcTemplate.queryForObject(sql, Long.class);
		System.out.println(count);
	}
	/**
	 * ��ѯ��ʵ����ļ���
	 * ʹ�õ���query(String sql, RowMapper<Employee> rowMapper, Object... args����
	 */
	@Test
	public void testQueryForList(){
		String sql = "SELECT id,last_name,email,depi_id  FROM `employes` WHERE id >?";
		org.springframework.jdbc.core.RowMapper<Employee> rowMapper = new BeanPropertyRowMapper<>(Employee.class);
		List<Employee> employees = jdbcTemplate.query(sql, rowMapper,5);
		System.out.println(employees);
	}
	
	/**
	 * ִ�������ĸ��£�INSERT,UPDATE,DELECT
	 * ���һ��������Object[]��List���ͣ���Ϊ�޸�һ����¼��Ҫһ��Object�����飬��������Ҫ���Object������
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
	 * ִ��UPDATE,INSERT,DELETE
	 */
	@Test
	public void testUpdate(){
		String sql = "UPDATE `employes` LAST_NAME = ?  WHERE id=��";
		jdbcTemplate.update(sql,"z",4);
	}
	@Test 
	public void testDataSource()throws SQLException{
		DataSource dataSource = ctx.getBean(DataSource.class);
	    System.out.println(dataSource.getConnection());
	}

}
