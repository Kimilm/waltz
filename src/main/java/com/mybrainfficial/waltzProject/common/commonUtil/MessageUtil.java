package com.mybrainfficial.waltzProject.common.commonUtil;

import com.google.gson.JsonObject;
import com.mybrainfficial.waltzProject.ResultVO;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ResponseBody;

public class MessageUtil {
    private static final Logger LOGGER = LoggerFactory.getLogger(MessageUtil.class);

    // 1. 공통 message 체크
    // message 생성
    public static final MessageUtil SUCCESS_NORMAL = new MessageUtil(MessageCode.SUCCESS_NORMAL);
    public static final MessageUtil FAIL_SYSTEM_ERROR = new MessageUtil(MessageCode.FAIL_SYSTEM_ERROR);
    public static final MessageUtil FAIL_INVALID_ID_PWD = new MessageUtil(MessageCode.FAIL_INVALID_ID_PWD);

    String responseCode = "";
    String responseMessage = "";

    // constructor
    public MessageUtil(MessageCode msg) {
        // log!!
        LOGGER.warn("message: {}", msg.toString());
        this.setReturnValue(msg);
    }

    // result value setting
    private void setReturnValue(final MessageCode commonMessageCode) {
        this.responseCode = commonMessageCode.getCode();
        this.responseMessage = commonMessageCode.getMessage();
    }

    // jsonObject message return
    public JsonObject getJsonObject() {
        if (StringUtils.isNotEmpty(this.responseCode)) {
            final JsonObject result = new JsonObject();
            result.addProperty("resultCd", this.responseCode);
            result.addProperty("resultMsg", this.responseMessage);

            return result;
        } else {
            return FAIL_SYSTEM_ERROR.getJsonObject();
        }
    }

    // 2. ajax insert, update, delete 이후 success flag 체크
    // success flag check
    public static ResultVO getMessage(int result){
        return (result > 0 ? getSuccessCode() : getFailCode());
    }

    // success message
    public static ResultVO getSuccessCode() {
        ResultVO rvo = new ResultVO();

        rvo.setResultCd("0000");
        rvo.setResultMsg("성공했습니다.");
        rvo.setResultFlag(true);
        return rvo;
    }

    // fail message
    public static ResultVO getFailCode() {
        ResultVO rvo = new ResultVO();

        rvo.setResultCd("9999");
        rvo.setResultMsg("실패했습니다.");
        rvo.setResultFlag(false);
        return rvo;
    }
}
