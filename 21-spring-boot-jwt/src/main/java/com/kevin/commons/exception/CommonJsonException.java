package com.kevin.commons.exception;

import com.kevin.utils.ResponseCodeEnum;
import com.kevin.utils.Result;

/**
 * @author caonanqing
 * @version 1.0
 * @description
 * 		在校验参数时, 如果不符合要求, 可以抛出此错误类
 *  	拦截器可以统一拦截此错误,将其中json返回给前端
 * @createDate 2019/6/26
 */
public class CommonJsonException extends RuntimeException {
	private Result result;

	/**
	 * 调用时可以在任何代码处直接throws这个Exception,
	 * 都会统一被拦截,并封装好json返回给前台
	 *
	 * @param errorEnum 以错误的ErrorEnum做参数
	 */
	public CommonJsonException(ResponseCodeEnum errorEnum) {
		this.result = Result.fail();
	}

	public CommonJsonException(Result result) {
		this.result = result;
	}

	public Result getResult() {
		return result;
	}
}
