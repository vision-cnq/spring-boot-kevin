/*
package com.kevin.controller;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;


*/
/**
 * @author kevin
 * @version 1.0
 * @description     ExceptionHandler+ControllerAdvice的全局异常处理类
 * @createDate 2019/3/22
 *//*

@ControllerAdvice
public class GlobalException {

    */
/**
     * java.lang.ArithmeticException.class
     *     该方法需要返回一个ModelAndView：目的是可以让我们封装异常信息以及视图指定
     * @param e：会将产生异常对象注入到方法中
     * @return
     *//*

    @ExceptionHandler(value={java.lang.ArithmeticException.class})
    public ModelAndView arithmeticExceptionHandler(Exception e){
        ModelAndView mv = new ModelAndView();
        mv.addObject("error",e.toString());
        mv.setViewName("error1");
        return mv;
    }

    */
/**
     *  java.lang.NullPointerException.class
     *      该方法需要返回一个 ModelAndView： 目的是可以让我们封装异常信息以及视图的指定
     * @param e：会将产生异常对象注入到方法中
     * @return
     *//*

    @ExceptionHandler(value={java.lang.NullPointerException.class})
    public ModelAndView nullPointerExceptionHandler(Exception e){
        ModelAndView mv = new ModelAndView();
        mv.addObject("error",e.toString());
        mv.setViewName("error2");
        return mv;
    }

}
*/
