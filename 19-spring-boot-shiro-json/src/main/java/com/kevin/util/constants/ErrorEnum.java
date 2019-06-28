package com.kevin.util.constants;


/**
 * @author caonanqing
 * @version 1.0
 * @description		错误枚举类
 * @createDate 2019/6/26
 */
public enum ErrorEnum {
	/*
	 * 错误信息
	 * */
	E_400(400, "请求处理异常，请稍后再试"),
	E_404(404,"请求资源不存在"),
	E_500(500, "请求错误"),
	E_501(501, "请求路径不存在"),
	E_502(502, "权限不足"),
	E_10008(10008, "角色删除失败,尚有用户属于此角色"),
	E_10009(10009, "账户已存在"),

	E_20011(20011, "登陆已过期,请重新登陆"),

	E_90003(90003, "缺少必填参数");

	private int errorCode;

	private String errorMsg;

	ErrorEnum(int errorCode, String errorMsg) {
		this.errorCode = errorCode;
		this.errorMsg = errorMsg;
	}

	public int getErrorCode() {
		return errorCode;
	}

	public String getErrorMsg() {
		return errorMsg;
	}

	public static String getMessageByCode(int errorCode) {
		ErrorEnum[] values = ErrorEnum.values();
		for (ErrorEnum ec : values) {
			if (ec.errorCode == errorCode) {
				return ec.errorMsg;
			}
		}
		return "";
	}

}