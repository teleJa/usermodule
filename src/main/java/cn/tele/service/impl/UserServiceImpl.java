package cn.tele.service.impl;

import java.util.List;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import cn.tele.bean.User;
import cn.tele.mapper.UserMapper;
import cn.tele.service.UserService;

/** 
 *
 *@author Tele
 *
 */
@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserMapper userMapper;

	
	@Override
	public Integer insertUser(User user) {
		return userMapper.insertUser(user);
	}

	
	@Override
	public User getUserById(@NotNull(message = "uid不能为null") @Min(value = 1,message = "uid不合法")  Integer id) {
		return userMapper.getUserById(id);
	}
	 
	@Override
	public List<User> listUserByUserName(@NotBlank(message = "姓名不能为空") @Size(max = 20,message = "姓名最大长度为50个字符") String name) {
		return userMapper.listUserByUserName(name);
	}

	@Override
	public List<User> listUserByDepartmentId(@NotNull Integer id) {
		return userMapper.listUserByDepartmentId(id);
	}

	@Override
	public Integer updateUser(User user) {
		return userMapper.updateUser(user);
	}

	@Override
	public Integer deleteUserById(@NotNull(message = "uid不能为null") @Min(value = 1,message = "uid不合法") Integer id) {
		return userMapper.deleteUserById(id);
	}


}
