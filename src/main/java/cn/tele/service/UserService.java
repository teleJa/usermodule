package cn.tele.service;

import java.util.List;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.validation.annotation.Validated;

import cn.tele.bean.User;

/** 
 *
 *@author Tele
 *
 */
public interface UserService {
	/**
	 * @param user
	 * @return 主键
	 */
	Integer  insertUser(User user);
	
	User getUserById(@NotNull(message = "uid不能为null") @Min(value = 1,message = "uid不合法") Integer id);
	
	List<User> listUserByUserName(@NotBlank(message = "姓名不能为空") @Size(max = 20,message = "姓名最大长度为50个字符") String name);
	
	List<User> listUserByDepartmentId(@NotNull Integer id);
	
	
	
    Integer updateUser(User user);
 
    Integer deleteUserById(@NotNull(message = "uid不能为null") @Min(value = 1,message = "uid不合法") Integer id);
	
}
