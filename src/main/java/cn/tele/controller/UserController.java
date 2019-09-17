package cn.tele.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import cn.tele.bean.User;
import cn.tele.service.UserService;
import cn.tele.validator.groups.Update;

/** 
 *
 *@author Tele
 *
 */
@Controller
@RequestMapping("/userController")
public class UserController {
	@Autowired
	private UserService userService;
	
	
	@RequestMapping(value = {"/getUserById/{uid}","/getUserById"})
	public @ResponseBody Object getUserById(@PathVariable Integer uid) {
		User user = userService.getUserById(uid);
		return user != null ? user : "未查询到uid="+ uid + "的用户";
	}
	
	
	@RequestMapping(value= {"/listUserByUserName/{name}","/listUserByUserName"})
	public @ResponseBody List<User> listUserByUserName(@PathVariable String name){
		return userService.listUserByUserName(name);
	}
	
	
	@RequestMapping(value= {"/listUserByDepartmentId/{id}","/listUserByDepartmentId"})
	public @ResponseBody List<User> listUserByDepartmentId(@PathVariable Integer id){
		return userService.listUserByDepartmentId(id);
	}

	@RequestMapping(value= {"/deleteUserById/{id}","/deleteUserById"})
	public @ResponseBody String deleteUserById(@PathVariable Integer id) {
		User user = userService.getUserById(id);
		int state = user != null ? user.getState() : 0;
		Integer count = state == 1 ? userService.deleteUserById(id) : 0;
		return count == 1 ? "成功删除1条记录" : "删除id为" + id + "的用户失败";
	}
	
	@RequestMapping("/insertUser")
	public @ResponseBody String insertUser(@Validated @RequestBody User user) {
		Integer count = userService.insertUser(user);
		return count ==1 ? "成功增加1条记录" : "增加" + user + "失败";
	}
	
	
	@RequestMapping("/updateUser")
	public @ResponseBody String updateUser(@Validated(Update.class) @RequestBody User user) {
		Integer count = userService.updateUser(user);
		return count == 1 ? "成功更新1条记录":"更新" + user + "失败";
	}
}
