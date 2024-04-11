package com.example.demo.controller;

import com.example.demo.exception.EapErrorException;
import com.example.demo.resp.BaseResp;
import com.example.demo.resp.ResultResp;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.validation.BindException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.Locale;

@Slf4j
public class BaseController {

    MessageSource messageSource;

    protected void setMessage(BaseResp<?> resp, int errorCode){
        String sErrCd = messageSource.getMessage("err.c"+errorCode,null,Locale.KOREA);
        String sErrMsg = messageSource.getMessage("err.m"+errorCode,null,Locale.KOREA);
        log.debug("sErrCd:::::::"+sErrCd);
        log.debug("sErrMsg:::::::"+sErrMsg);
        resp.setResult_cd(sErrCd);
        resp.setResult_msg(sErrMsg);        
    }

    protected void setMessage(BaseResp<?> resp,int errorCode,String msg){        
        resp.setResult_cd(String.format("%d", errorCode));
        resp.setResult_msg(msg);        
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResultResp handleValidationExceptions(MethodArgumentNotValidException ex){
        log.debug("---------------------------");
        log.debug(ex.getMessage());
        log.debug("---------------------------");
        ResultResp resp = new ResultResp();
        resp.setResult_cd("403");
        ex.getBindingResult().getAllErrors()
                .forEach(c ->{ resp.setResult_msg(c.getDefaultMessage());});
        return resp;        
    }

    @ExceptionHandler(BindException.class)    
    public ResultResp handleValidationExceptions(BindException ex){
        log.debug("---------------------------");
        log.debug(ex.getMessage());
        log.debug("---------------------------");
        ResultResp resp = new ResultResp();
        resp.setResult_cd("403");
        ex.getBindingResult().getAllErrors()
                .forEach(c ->{ resp.setResult_msg(c.getDefaultMessage());});
        return resp;        
    }
    
    @ExceptionHandler(EapErrorException.class)
    public ResultResp handleEapErrorException(EapErrorException ex) {
    	ResultResp resp = new ResultResp();
	    setMessage(resp, ex.getCode());
    	
	    if(StringUtils.isNotBlank(ex.getMessage())) {
    		resp.setResult_msg(ex.getMessage());
    	}
    	log.debug("error code: {}, message: {}", resp.getResult_cd(), resp.getResult_msg());
    	return resp;
    }
}
