package com.mybrainfficial.waltzProject.common.commonUtil;

public enum MessageCode {
    /** 시스템 관련 (공통) **/
    SUCCESS_NORMAL("0000", "처리되었습니다."),
    FAIL_SYSTEM_ERROR("9999", "시스템에러"),
    FAIL_INVALID_REQUEST("9998", "올바르지 않은 요청"),
    FAIL_INVALID_COMMON_PARAMETER("9998", "올바르지 않은 공통 파라미터"),
    FAIL_INVALID_PARAMETER("9997", "올바르지 않은 파라미터"),
    FAIL_NOT_ALLOWED_MEMBER("9996", "허용되지 않는 사용자"),
    FAIL_CANNOT_INSERT_NULL("9995", "필수 값을 채워주세요."),

//    FAIL_FILE_NOT_FOUND("F005", "파일이 존재하지 않습니다."),
//    FAIL_PATH_NOT_FOUND("F006", "경로가 존재하지 않습니다"),
//    FAIL_TRANSFORM_DATA("F007", "데이터 변환 실패(Primitive -> Collection)"),
//    FAIL_SELECTKEY_RETURN_NO_DATA("F008", "키 생성에 실패하였습니다."),
//    FAIL_VALUE_TOO_LARGE_FOR_COLUMN("F009", "입력하신 값이 너무 큽니다."),

    /** 로그인 관련 **/
    FAIL_LOGIN_FAIL_CNT("1111", "로그인 실패 회수 초과"),
    FAIL_TRY_LOGIN_FIRST("1112", "처리를 위해 로그인이 필요합니다."),
    FAIL_INVALID_ID_PWD("1113", "입력하신 ID와 Password 정보가 없습니다."),

    /** 파일, 이미지, 엑셀, 워드 관련 **/
    FAIL_FILE_MIMETYPE("F001", "올바르지 않은 파일 내용입니다."),
    FAIL_FILE_EXT("F002", "올바르지 않은 파일 확장자 입니다."),
    FAIL_IMAGE_MIMETYPE("F003", "올바르지 않은 이미지 형식입니다."),
    FAIL_IMAGE_EXT("F004", "올바르지 않은 이미지 확장자 입니다."),
    FAIL_EXCEL_MIMETYPE("F005", "올바르지 않은 엑셀 형식입니다."),
    FAIL_EXCEL_EXT("F006", "올바르지 않은 엑셀 확장자 입니다."),
    FAIL_WORD_MIMETYPE("F007", "올바르지 않은 워드문서 형식입니다."),
    FAIL_WORD_EXT("F008", "올바르지 않은 워드문서 확장자 입니다."),
    FAIL_PDF_MIMETYPE("F009", "올바르지 않은 PDF 문서 형식입니다."),
    FAIL_PDF_EXT("F010", "올바르지 않은 PDF 문서 확장자 입니다."),
    FAIL_FILE_SIZE("F011", "최대 2MB 이하의 파일 첨부만 가능합니다."),
    FAIL_NO_DATA_SUCCESS("F012", "처리건 없음."),
    FAIL_UNIQUE_CONSTRAINT_VIOLATED("F013", "이미 존재하는 데이터입니다."),
    FAIL_DIR_PATH_MUST_ENDS_WITH_SLASH("F014", "디렉토리 경로는 항상 '/' 으로 끝나야만 합니다."),
    FAIL_ILLEGAL_BLOCK_SIZE_AES("F015", "암/복호화 오류 발생"),

    /** 개발자용 메시지 **/
    FAIL_TO_DECRYPTION_DATA("F998", "(개발자용)암호화 값이 아닌 값을 Decryption 하고 있음!"),
    FAIL_TOO_MANY_RESULT("F996", "(개발자용)sqlSession.selectOne();에서 여러 row 리턴!"),
    FAIL_VIOLATED_CHILD_RECORD_FOUND("F997", "(개발자용)데이터를 삭제하기전 제약조건을 확인!"),
    FAIL_MAPPED_STATMENTS_COLLECTION_DOES_NOT_CONTAIN("F998", "(개발자용)SQL을 수행할 Mapper를 찾지 못함!"),
    FAIL_BAD_SQL_GRAMMER("F999", "(개발자용)SQL 문법 에러!");

    private String code;
    private String message;

    MessageCode(final String code, final String message) {
        this.code = code;
        this.message = message;
    }

    public String getCode() {
        return this.code;
    }

    public String getMessage() {
        return this.message;
    }

    @Override
    public String toString() {
        return this.name() + "(\"" + this.code + "\", \"" + this.message + "\");";
    }
}
