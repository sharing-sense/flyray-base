package me.flyray.crm.model;

import java.util.Date;

/** 
* @author: bolei
* @date：2017年3月6日 下午9:53:42 
* @description：客户基础信息
*/

public class CustomerBase extends BaseModel{

	/**
	 * 客户自增ID
	 */
	private Long id;
	
	/**
	 * 客户编号
	 */
	private String customerNo;
	
	/**
	 * 客户名称
	 */
	private String custName;
	
	/**
	 * 客户昵称
	 */
	private String nickName;
	
	/**
	 * 客户电话
	 */
	private int phone;
	
	/**
	 * 客户性别
	 */
	private String sex;
	
	/**
	 * 客户住址
	 */
	private String address;
	
	/**
	 * 客户年龄
	 */
	private int age;
	
	/**
	 * 客户生日
	 */
	private Date birthday;
	
	/**
	 * 头像
	 */
	
	private String avatar;


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCustomerNo() {
		return customerNo;
	}

	public void setCustomerNo(String customerNo) {
		this.customerNo = customerNo;
	}

	public String getCustName() {
		return custName;
	}

	public void setCustName(String custName) {
		this.custName = custName;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public int getPhone() {
		return phone;
	}

	public void setPhone(int phone) {
		this.phone = phone;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public String getAvatar() {
		return avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}
	
}
