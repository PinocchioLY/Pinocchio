package com.smbms.dao;

import java.io.InputStream;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class BaseDAO {
	private static SqlSessionFactory factory;
	static{//静态代码块,在BaseDao第一次被使用时会被调用
		//以后调用BaseDAO则不会指定static静态块内的代码
		SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
		InputStream in = BaseDAO.class.getClassLoader().getResourceAsStream("config.xml");
		factory = builder.build(in);
		
	}
	/**
	 * 获取一个SqlSession对象
	 * @return
	 */
	public static SqlSession openSession(){
		return factory.openSession();
		
	}
	/**
	 * 关闭SqlSession对象
	 * @param session
	 */
	public static void closeSession(SqlSession session){
		if(session!=null){
			session.close();
		}
	}
}
