package com.smbms.dao;

import java.io.InputStream;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class BaseDAO {
	private static SqlSessionFactory factory;
	static{//��̬�����,��BaseDao��һ�α�ʹ��ʱ�ᱻ����
		//�Ժ����BaseDAO�򲻻�ָ��static��̬���ڵĴ���
		SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
		InputStream in = BaseDAO.class.getClassLoader().getResourceAsStream("config.xml");
		factory = builder.build(in);
		
	}
	/**
	 * ��ȡһ��SqlSession����
	 * @return
	 */
	public static SqlSession openSession(){
		return factory.openSession();
		
	}
	/**
	 * �ر�SqlSession����
	 * @param session
	 */
	public static void closeSession(SqlSession session){
		if(session!=null){
			session.close();
		}
	}
}
