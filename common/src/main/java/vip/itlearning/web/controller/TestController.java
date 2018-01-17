package vip.itlearning.web.controller;

import io.swagger.annotations.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Administrator on 2018/1/17.
 */
@Api(value = "Test", description = "test the swagger API")
@RestController
public class TestController {


    @ApiOperation(value = "get city by state", notes = "Get city by state")
    @ApiResponses(value = {@ApiResponse(code = 405, message = "Invalid input") })
    @RequestMapping(value = "/city", method = RequestMethod.GET)
    public void  getCityByState(
            @ApiParam(value = "The id of the city" ,required=true ) @RequestParam String state){

        return;
    }

}
