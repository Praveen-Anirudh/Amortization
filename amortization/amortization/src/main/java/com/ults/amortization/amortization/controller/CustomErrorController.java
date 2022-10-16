package com.ults.amortization.amortization.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.error.ErrorAttributes;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ults.amortization.amortization.ErrorJson;

@RestController
public class CustomErrorController implements ErrorController {
    private static final String PATH = "/error";

    // @Value("${debug}")
    // private boolean debug;

    @Autowired
    private ErrorAttributes errorAttributes;

    @RequestMapping(value = PATH)
    ErrorJson error(HttpServletRequest request, HttpServletResponse response) {
        // Appropriate HTTP response code (e.g. 404 or 500) is automatically set by
        // Spring.
        // Here we just define response body.
        return new ErrorJson(response.getStatus(), getErrorAttributes(request, true));
    }

    private Map<String, Object> getErrorAttributes(HttpServletRequest request, boolean b) {
        return null;
    }

    public String getErrorPath() {
        return PATH;
    }

}
