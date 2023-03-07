package com.koreait.board.common.constant;

public class ResponseMessage { // (상수 선언) 상수선언의 접근제한자 : final
    public static final String DATABASE_ERROR = "Database Error"; // 접근제한자가 public이 아니면 다른 클래스에서 접근 불가능 / 그래서 public도 붙여줌
    public static final String SUCCESS = "Success";
    public static final String EXIST_PHONE_NUMBER = "Existed Telephone Number";
    public static final String NOT_EXIST_DEPARTMENT_CODE = "Does not Exist Department Code";
    public static final String NOT_EXIST_EMPLOYEE_NUMBER = "Dose not Exist Employee Number";
}
