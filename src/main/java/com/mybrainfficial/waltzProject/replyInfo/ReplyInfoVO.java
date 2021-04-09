package com.mybrainfficial.waltzProject.replyInfo;

import java.io.Serializable;
import java.util.Date;

public class ReplyInfoVO implements Serializable {
	private int replyId;
	private int postId;
	private String replyConts;
	private int replySortId;
	private String replyWrtrId;
	private String delYn;
	private String crtId;
	private Date crtDt;
	private String updtId;
	private Date updtDt;
	
	public int getReplyId() {
		return replyId;
	}
	public void setReplyId(int replyId) {
		this.replyId = replyId;
	}
	public int getPostId() {
		return postId;
	}
	public void setPostId(int postId) {
		this.postId = postId;
	}
	public String getReplyConts() {
		return replyConts;
	}
	public void setReplyConts(String replyConts) {
		this.replyConts = replyConts;
	}
	public int getReplySortId() {
		return replySortId;
	}
	public void setReplySortId(int replySortId) {
		this.replySortId = replySortId;
	}
	public String getReplyWrtrId() {
		return replyWrtrId;
	}
	public void setReplyWrtrId(String replyWrtrId) {
		this.replyWrtrId = replyWrtrId;
	}
	public String getDelYn() {
		return delYn;
	}
	public void setDelYn(String delYn) {
		this.delYn = delYn;
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
