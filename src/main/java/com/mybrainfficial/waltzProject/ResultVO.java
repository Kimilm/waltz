package com.mybrainfficial.waltzProject;

import java.io.Serializable;

public class ResultVO implements Serializable {

	private String resultCd;
	private String resultMsg;
	private boolean resultFlag;

    public void setResultCd(String resultCd) {
        this.resultCd = resultCd;
    }

    public String getResultCd() {
        return resultCd;
    }

    public void setResultFlag(boolean resultFlag) {
        this.resultFlag = resultFlag;
    }

    public boolean getResultFlag() {
        return resultFlag;
    }

    public void setResultMsg(String resultMsg) {
        this.resultMsg = resultMsg;
    }

    public String getResultMsg() {
        return resultMsg;
    }
}
