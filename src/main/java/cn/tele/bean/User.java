package cn.tele.bean;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.beans.factory.annotation.Value;

import cn.tele.validator.groups.Delete;
import cn.tele.validator.groups.Query;
import cn.tele.validator.groups.Update;


/** 
 *
 *@author Tele
 *
 */
public class User {
	@NotNull(message = "uid不能为null",groups = {Query.class,Update.class,Delete.class})
	@Min(value = 1,message = "uid不合法")
	private Integer uid;
	
	@NotBlank(message = "姓名不能为空")
	@Size(max = 20,message = "姓名最大长度为50个字符")
	private String userName;
	
	@NotBlank(message = "性别不能为空")
	@Size(max = 20,message = "性别最大长度位20个字符")
	private String sex;

	@NotNull
	@Max(value = 70,message = "最大年龄为70岁")
	private Integer age;

	@NotNull
	private Integer departmentId;
	
	@Value(value = "1")
	private Integer state;
	
	
	
	public User() {
		super();
	}
	
	public User(Integer uid, String userName, String sex, Integer age, Integer departmentId, Integer state) {
		super();
		this.uid = uid;
		this.userName = userName;
		this.sex = sex;
		this.age = age;
		this.departmentId = departmentId;
		this.state = state;
	}
	
	public User(String userName, String sex, Integer age, Integer departmentId, Integer state) {
		super();
		this.userName = userName;
		this.sex = sex;
		this.age = age;
		this.departmentId = departmentId;
		this.state = state;
	}
	
	public User(String userName, String sex, Integer age, Integer departemntId) {
		super();
		this.userName = userName;
		this.sex = sex;
		this.age = age;
		this.departmentId = departemntId;
	}


	public Integer getUid() {
		return uid;
	}
	public void setUid(Integer uid) {
		this.uid = uid;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	
	public Integer getDepartmentId() {
		return departmentId;
	}


	public void setDepartmentId(Integer departmentId) {
		this.departmentId = departmentId;
	}


	public Integer getState() {
		return state;
	}
	public void setState(Integer state) {
		this.state = state;
	}
	@Override
	public String toString() {
		return "User [uid=" + uid + ", userName=" + userName + ", sex=" + sex + ", age=" + age + ", departmentId="
				+ departmentId + ", state=" + state + "]";
	}
}
