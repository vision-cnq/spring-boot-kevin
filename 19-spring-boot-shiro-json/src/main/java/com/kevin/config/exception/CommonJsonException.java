package com.kevin.config.exception;

import com.kevin.util.CommonUtil;
import com.kevin.util.Result;
import com.kevin.util.constants.ErrorEnum;

/**
 * @author caonanqing
 * @version 1.0
 * @description
 * 		在校验参数时, 如果不符合要求, 可以抛出此错误类
 *  	拦截器可以统一拦截此错误,将其中json返回给前端
 * @createDate 2019/6/26
 */
public class CommonJsonException extends RuntimeException {
	private Result resultJson;

	/**
	 * 调用时可以在任何代码处直接throws这个Exception,
	 * 都会统一被拦截,并封装好json返回给前台
	 *
	 * @param errorEnum 以错误的ErrorEnum做参数
	 */
	public CommonJsonException(ErrorEnum errorEnum) {
		this.resultJson = CommonUtil.errorJson(errorEnum);
	}

	public CommonJsonException(Result resultJson) {
		this.resultJson = resultJson;
	}

	public Result getResultJson() {
		return resultJson;
	}
}
