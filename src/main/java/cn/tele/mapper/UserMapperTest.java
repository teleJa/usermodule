package cn.tele.mapper;

import static org.junit.Assert.*;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.aspectj.lang.annotation.After;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import cn.tele.bean.User;

/**
 *
 * @author Tele
 *
 */
public class UserMapperTest {

	@Test
	public void testGet() {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		SqlSessionFactory sqlSessionFactory = (SqlSessionFactory) ctx.getBean("sqlSessionFactory");
		SqlSession sqlSession = sqlSessionFactory.openSession(false);
		UserMapper mapper = sqlSession.getMapper(UserMapper.class);
		
		System.out.println(mapper.getUserById(1));
		
		sqlSession.commit();
		sqlSession.close();
	}
	
	@Test
	public void testInsert() {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		SqlSessionFactory sqlSessionFactory = (SqlSessionFactory) ctx.getBean("sqlSessionFactory");
		SqlSession sqlSession = sqlSessionFactory.openSession(false);
		UserMapper mapper = sqlSession.getMapper(UserMapper.class);
		
		mapper.insertUser(new User(null,"male",20, 1));
		
		sqlSession.commit();
		sqlSession.close();
	}
	
	
	
	@Test
	public void testUpdate() {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		SqlSessionFactory sqlSessionFactory = (SqlSessionFactory) ctx.getBean("sqlSessionFactory");
		SqlSession sqlSession = sqlSessionFactory.openSession(false);
		UserMapper mapper = sqlSession.getMapper(UserMapper.class);
		
		System.out.println(mapper.getUserById(1));
		
		sqlSession.commit();
		sqlSession.close();
	}
	

}
