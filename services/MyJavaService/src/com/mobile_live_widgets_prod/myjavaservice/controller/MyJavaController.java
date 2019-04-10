/**
 *This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.
 */
package com.mobile_live_widgets_prod.myjavaservice.controller;

import com.mobile_live_widgets_prod.myjavaservice.MyJavaService;
import java.lang.String;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.MediaType;
import org.springframework.beans.factory.annotation.Autowired;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiParam;
import com.wavemaker.tools.api.core.annotations.WMAccessVisibility;
import com.wavemaker.tools.api.core.models.AccessSpecifier;

@RestController
@RequestMapping(value = "/myJava")
public class MyJavaController {

    @Autowired
    private MyJavaService myJavaService;

    @RequestMapping(value = "/sampleJavaOperation", produces = "application/json", method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    @ApiOperation(value = "")
    public String sampleJavaOperation(@RequestParam(value = "name", required = false) String name, HttpServletRequest request) {
        return myJavaService.sampleJavaOperation(name, request);
    }

    @RequestMapping(value = "/testJava", produces = "application/json", method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    @ApiOperation(value = "")
    public String testJava(@RequestParam(value = "a", required = false) String a, @RequestParam(value = "b", required = false) String b) {
        return myJavaService.testJava(a, b);
    }
}
