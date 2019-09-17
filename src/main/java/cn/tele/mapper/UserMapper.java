package cn.tele.mapper;

import cn.tele.bean.User;
import java.util.List;

import org.springframework.stereotype.Component;

/**
 * @author tele
 * @Description
 * @create 2019-08-12
 */
public interface UserMapper {
	Integer  insertUser(User user);
	
	User getUserById(Integer id);
	
	List<User> listUserByUserName(String name);
	
	List<User> listUserByDepartmentId(Integer id);
	
	
	
    Integer updateUser(User user);
 
    Integer deleteUserById(Integer id);


    

   
}
