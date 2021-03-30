package com.mybrainfficial.waltzProject.boardInfo;

import java.io.Serializable;
import java.util.Date;

public class BoardInfoVO implements Serializable{
	private int postId;
	private String brdCd;
	private int origPostId;
	private String replyYn;
	private String postSubject;
	private String postConts;
	private String wrtrId;
	private Date wrtrDt;
	private String postDateFrom;
	private String postDateTo;
	private String imptncYn;
	private String attachYn;
	private String ansYn;
	private String delYn;
	private int hitCnt;
	private String crtId;
	private Date crtDt;
	private String updtId;
	private Date updtDt;
	
	public int getPostId() {
		return postId;
	}
	public void setPostId(int postId) {
		this.postId = postId;
	}
	public String getBrdCd() {
		return brdCd;
	}
	public void setBrdCd(String brdCd) {
		this.brdCd = brdCd;
	}
	public int getOrigPostId() {
		return origPostId;
	}
	public void setOrigPostId(int origPostId) {
		this.origPostId = origPostId;
	}
	public String getReplyYn() {
		return replyYn;
	}
	public void setReplyYn(String replyYn) {
		this.replyYn = replyYn;
	}
	public String getPostSubject() {
		return postSubject;
	}
	public void setPostSubject(String postSubject) {
		this.postSubject = postSubject;
	}
	public String getPostConts() {
		return postConts;
	}
	public void setPostConts(String postConts) {
		this.postConts = postConts;
	}
	public String getWrtrId() {
		return wrtrId;
	}
	public void setWrtrId(String wrtrId) {
		this.wrtrId = wrtrId;
	}
	public Date getWrtrDt() {
		return wrtrDt;
	}
	public void setWrtrDt(Date wrtrDt) {
		this.wrtrDt = wrtrDt;
	}
	public String getPostDateFrom() {
		return postDateFrom;
	}
	public void setPostDateFrom(String postDateFrom) {
		this.postDateFrom = postDateFrom;
	}
	public String getPostDateTo() {
		return postDateTo;
	}
	public void setPostDateTo(String postDateTo) {
		this.postDateTo = postDateTo;
	}
	public String getImptncYn() {
		return imptncYn;
	}
	public void setImptncYn(String imptncYn) {
		this.imptncYn = imptncYn;
	}
	public String getAttachYn() {
		return attachYn;
	}
	public void setAttachYn(String attachYn) {
		this.attachYn = attachYn;
	}
	public String getAnsYn() {
		return ansYn;
	}
	public void setAnsYn(String ansYn) {
		this.ansYn = ansYn;
	}
	public String getDelYn() {
		return delYn;
	}
	public void setDelYn(String delYn) {
		this.delYn = delYn;
	}
	public int getHitCnt() {
		return hitCnt;
	}
	public void setHitCnt(int hitCnt) {
		this.hitCnt = hitCnt;
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
