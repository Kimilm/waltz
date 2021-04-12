package com.mybrainfficial.waltzProject.menuInfo;

import java.io.Serializable;
import java.util.Date;

public class AuthMappInfoVO implements Serializable {
	private String menuCd;
	private String userGrpCd;
	private String selYn;
	private String updtYn;
	private String delYn;
	private String downYn;
	private String crtId;
	private Date crtDt;
	private String updtId;
	private Date updtDt;
	
	public String getMenuCd() {
		return menuCd;
	}
	public void setMenuCd(String menuCd) {
		this.menuCd = menuCd;
	}
	public String getUserGrpCd() {
		return userGrpCd;
	}
	public void setUserGrpCd(String userGrpCd) {
		this.userGrpCd = userGrpCd;
	}
	public String getSelYn() {
		return selYn;
	}
	public void setSelYn(String selYn) {
		this.selYn = selYn;
	}
	public String getUpdtYn() {
		return updtYn;
	}
	public void setUpdtYn(String updtYn) {
		this.updtYn = updtYn;
	}
	public String getDelYn() {
		return delYn;
	}
	public void setDelYn(String delYn) {
		this.delYn = delYn;
	}
	public String getDownYn() {
		return downYn;
	}
	public void setDownYn(String downYn) {
		this.downYn = downYn;
	}
	public String getCrtId() {
		return crtId;
	}
	public void setCrtId(String crtId) {
		this.crtId = crtId;
	}
	public Date getCrtDt() {
		return crtDt;
	}
	public void setCrtDt(Date crtDt) {
		this.crtDt = crtDt;
	}
	public String getUpdtId() {
		return updtId;
	}
	public void setUpdtId(String updtId) {
		this.updtId = updtId;
	}
	public Date getUpdtDt() {
		return updtDt;
	}
	public void setUpdtDt(Date updtDt) {
		this.updtDt = updtDt;
	}
}
