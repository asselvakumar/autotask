package com.project.autotask.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController 
@RequestMapping(path =  "/apitesting")
public class SampleTask {
    Logger logger = LoggerFactory.getLogger(SampleTask.class);

	    
    @GetMapping(value = "/getapipoc", produces = "application/json")
    public ResponseEntity<?> getApiPoc(@RequestHeader(value="Accept", required = false) String acceptHeader, HttpServletRequest request){
        ModelMap map = new ModelMap();
        String Value = "<p>Hello,world</p>";
        logger.debug("Debug Message Logged !!!");
        logger.info("Info Message Logged !!!");
        logger.debug(request.getRequestURI().toString());
        
        if(acceptHeader == null || acceptHeader.length()<=0 || acceptHeader.equalsIgnoreCase("*/*"))
        {
            logger.info("AcceptHeader is null or empty or */*: " + acceptHeader);
            return ResponseEntity.status(HttpStatus.OK).body(Value);
        }
        else
        {
            map.put("message", "Hello World");
            logger.info("AcceptHeader is: " + acceptHeader);
            return new ResponseEntity<ModelMap>(map, HttpStatus.OK);
        }
    }

    @PostMapping(path = "/postapipoc", produces = "application/json")
    public ResponseEntity<?> postApiPoc(){
        ModelMap map = new ModelMap();
        logger.debug("Debug Message postApiPoc Logged !!!");
        logger.info("Info Message postApiPoc Logged !!!");
        map.put("message", "Post API Successful");
        return new ResponseEntity<ModelMap>(map, HttpStatus.OK);
    }
}
