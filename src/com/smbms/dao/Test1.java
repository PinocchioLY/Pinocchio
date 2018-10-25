package com.smbms.dao;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.pojo.SmbmsUser;
import com.pojo.SmbmsUserAddress;
public class Test1 {
	public static void main(String[] args) {
		/*SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
		
		InputStream in =Test1.class.getClassLoader().getResourceAsStream("config.xml");
		
		SqlSessionFactory factory = builder.build(in);
		//打开回话
		SqlSession session =factory.openSession();*/
		SqlSession session = BaseDAO.openSession();
		//调用指定的SQL语句获取结果
		/*int count =session.selectOne("com.smbms.dao.ProviderMapper.getProviderCount");
		int count =session.getMapper(ProviderMapper.class).getProviderCount();*/
		
		List<SmbmsUser> userList=session.getMapper(SmbmsUserMapper.class).getUserList();
		for(SmbmsUser user:userList){
			System.out.println(user.getUserName()+">>"+user.getGender()+">>"+user.getUserPassword());
			
		}
		
		
		List<SmbmsUserAddress> useraddressesList=session.getMapper(SmbmsAddressMapper.class).getUserAddress();
		for(SmbmsUserAddress userAddress:useraddressesList){
			System.out.println(userAddress.getId()+">>"+userAddress.getContact()+">>"+userAddress.getAddressDesc()+">>"+userAddress.getPostCode()+">>"+userAddress.getTel()+">>"+userAddress.getCreatedBy()+">>"+userAddress.getCreationDate()+">>"+userAddress.getUserid());
			
		}
		
		
		
		
		
		
		
		
		
		
		BaseDAO.closeSession(session);
		/*System.out.println(count);
		session.close();*/
	}
}
