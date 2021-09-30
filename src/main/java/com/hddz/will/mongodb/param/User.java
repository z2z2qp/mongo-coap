package com.hddz.will.mongodb.param;

import java.util.List;

public class User {

	private List<String> role;

	private String name;

	private String avatar;

	private String wsurl;

	private String uaurl;

	private String daurl;
	
	private String modbusurl;

	private String version;

	public List<String> getRole() {
		return role;
	}

	public void setRole(List<String> role) {
		this.role = role;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAvatar() {
		return avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}

	public String getWsurl() {
		return wsurl;
	}

	public void setWsurl(String wsurl) {
		this.wsurl = wsurl;
	}

	public String getUaurl() {
		return uaurl;
	}

	public void setUaurl(String uaurl) {
		this.uaurl = uaurl;
	}

	public String getDaurl() {
		return daurl;
	}

	public void setDaurl(String daurl) {
		this.daurl = daurl;
	}
	
	public String getModbusurl() {
		return modbusurl;
	}
	
	public void setModbusurl(String modbusurl) {
		this.modbusurl = modbusurl;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

}
