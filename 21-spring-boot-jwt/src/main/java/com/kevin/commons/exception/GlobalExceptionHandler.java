package com.kevin.commons.exception;

import com.kevin.utils.ResponseCodeEnum;
import com.kevin.utils.Result;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * @author caonanqing
 * @version 1.0
 * @description		统一异常拦截
 * @createDate 2019/6/26
 */
@ControllerAdvice
@ResponseBody
public class GlobalExceptionHandler {
	private Logger logger = LoggerFactory.getLogger(this.getClass().getName());

	/**
	 * 默认捕获所以Exception级别的异常
	 * @param req
	 * @param e
	 * @return
	 */
	@ExceptionHandler(value = Exception.class)
	public Result defaultErrorHandler(HttpServletRequest req, Exception e) {
		String errorPosition = "";
		//如果错误堆栈信息存在
		if (e.getStackTrace().length > 0) {
			StackTraceElement element = e.getStackTrace()[0];
			String fileName = element.getFileName() == null ? "未找到错误文件" : element.getFileName();
			int lineNumber = element.getLineNumber();
			errorPosition = fileName + ":" + lineNumber;
			logger.error(e.toString());
			for (StackTraceElement traceElement : e.getStackTrace()){
				logger.error("\tat " + traceElement);
			}
		}
		Result result = new Result();
		result.setCode(ResponseCodeEnum.REQUEST_HANDING_EXCEPTION.getCode());
		result.setMsg(ResponseCodeEnum.REQUEST_HANDING_EXCEPTION.getMessage());
		result.addData("error",e.getMessage() + " ,错误位置:" + errorPosition);
		return result;
	}

	/**
	 * GET/POST请求方法错误的拦截器
	 * 因为开发时可能比较常见,而且发生在进入controller之前,上面的拦截器拦截不到这个错误
	 * 所以定义了这个拦截器
	 */
	@ExceptionHandler(HttpRequestMethodNotSupportedException.class)
	public Result httpRequestMethodHandler() {
		return Result.build(ResponseCodeEnum.REQUEST_METHOD_ERROR.getCode(),ResponseCodeEnum.REQUEST_METHOD_ERROR.getMessage());
	}

	/**
	 * 本系统自定义错误的拦截器
	 * 拦截到此错误之后,就返回这个类里面的json给前端
	 * 常见使用场景是参数校验失败,抛出此错,返回错误信息给前端
	 */
	@ExceptionHandler(CommonJsonException.class)
	public Result commonJsonExceptionHandler(CommonJsonException commonJsonException) {
		return commonJsonException.getResult();
	}

}
