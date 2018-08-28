package com.vuanhnguyenduc.vuanhportfolio.controller.admin;

import com.vuanhnguyenduc.vuanhportfolio.commons.Constants;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;

@Controller
public class CustomErrorController implements ErrorController {
    @Override
    public String getErrorPath() {
        return "/error";
    }

    @GetMapping("/error")
    public String handleError(HttpServletRequest request){
        Object status = request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);
        Exception exception = (Exception) request.getAttribute(RequestDispatcher.ERROR_EXCEPTION);

        if(status != null){
            Integer statusCode = Integer.valueOf(status.toString());
            if(statusCode == HttpStatus.NOT_FOUND.value()){
                return Constants.ERROR_404_PAGE;
            } else if(statusCode == HttpStatus.FORBIDDEN.value()){
                return Constants.ERROR_403_PAGE;
            } else{
                return String.format("<html><body><h2>Error Page</h2><div>Status Code : <b>%s</b></div><div>Exception Message: <b>%s</b></div><body></html>",statusCode,exception.getMessage());
            }
        }
        return String.format("<html><body><h2>Error Page</h2><div>Exception Message: <b>%s</b></div><body></html>",exception.getMessage());
    }
}
