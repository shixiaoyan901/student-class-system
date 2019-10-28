package com.ssm.student_system.common;

/**
 * @Author shixiaoyan
 * Date on 2019/10/21  14:59
 * 自定义可能发生的异常
 */
public class MyException extends RuntimeException{

    private static final long serialVersionUID =1L;
//    错误编码
    private String errorCode;
//    消息是否属于文件中的Key
    private boolean propertiseKey = true;
//    构造一个基本异常 信息描述
    public  MyException(String message){
        super(message);
    }
//    构建一个基本异常
    public MyException(String errorCode,String message){
        this(errorCode,message,true);
    }
//    构建一个基本异常
    public MyException(String errorCode,String message,Throwable cause){
        this(errorCode,message,cause,true);

    }
//    构建一个基本异常
    public MyException(String errorCode, String message, boolean propertiesKey)
    {
        super(message);
        this.setErrorCode(errorCode);
        this.setPropertiesKey(propertiesKey);
    }
//    构建一个基本异常
    public MyException(String errorCode, String message, Throwable cause, boolean propertiesKey)
    {
        super(message, cause);
        this.setErrorCode(errorCode);
        this.setPropertiesKey(propertiesKey);
    }


//    构造一个基本异常，@param cause 根异常类（可以存在任何异常）
    public MyException(String message, Throwable cause)
    {
        super(message, cause);
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public boolean isPropertiseKey() {
        return propertiseKey;
    }


    private void setPropertiesKey(boolean propertiesKey) {
        this.propertiseKey = propertiesKey;
    }
}
