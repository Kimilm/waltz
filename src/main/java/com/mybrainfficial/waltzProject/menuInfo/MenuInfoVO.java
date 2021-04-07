package com.mybrainfficial.waltzProject.menuInfo;

import java.io.Serializable;
import java.util.Date;

public class MenuInfoVO implements Serializable  {
	private String menuCd;
	private String menuNm;
	private String prntMenuCd;
	private String menuTp;
	private String menuUrl;
	private String menuUseYn;
	private int menuSortNo;
	private int menuLevel;
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
	public String getMenuNm() {
		return menuNm;
	}
	public void setMenuNm(String menuNm) {
		this.menuNm = menuNm;
	}
	public String getPrntMenuCd() {
		return prntMenuCd;
	}
	public void setPrntMenuCd(String prntMenuCd) {
		this.prntMenuCd = prntMenuCd;
	}
	public String getMenuTp() {
		return menuTp;
	}
	public void setMenuTp(String menuTp) {
		this.menuTp = menuTp;
	}
	public String getMenuUrl() {
		return menuUrl;
	}
	public void setMenuUrl(String menuUrl) {
		this.menuUrl = menuUrl;
	}
	public String getMenuUseYn() {
		return menuUseYn;
	}
	public void setMenuUseYn(String menuUseYn) {
		this.menuUseYn = menuUseYn;
	}
	public int getMenuSortNo() {
		return menuSortNo;
	}
	public void setMenuSortNo(int menuSortNo) {
		this.menuSortNo = menuSortNo;
	}
	public int getMenuLevel() {
		return menuLevel;
	}
	public void setMenuLevel(int menuLevel) {
		this.menuLevel = menuLevel;
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
