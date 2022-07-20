package com.example.nace.resource;


import com.example.nace.entity.Nace;
import com.example.nace.service.NaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import java.util.List;



@Api(
value = "Nace",
produces = "application/json")
@RestController
@RequestMapping("/nace")
public class NaceResource{

	private Logger logger = LoggerFactory.getLogger(NaceResource.class);

    @Autowired
    private NaceService service;

    @RequestMapping(method = RequestMethod.POST ,value="add")
    @ResponseBody
    @ResponseStatus(HttpStatus.CREATED)
    @ApiOperation(value = "adds the given item to nace", notes = "Adds item to nace")
    @ApiResponses(value=
            {@ApiResponse(code = 500,message = "Fields are with validation errors"),
            @ApiResponse(code = 400, message = "Error occurred while processing request")}
            )
    public  ResponseEntity<String> addProduct(@ApiParam(value = "Nace details  added ")
    @RequestBody Nace nace) {
        logger.debug("Entered add() >>"+nace);
        long id =  service.addProduct(nace);
        logger.debug("Exited add() >>"+nace);
        return new ResponseEntity<String>("Created :"+id, HttpStatus.CREATED);
    }

    @RequestMapping(method= RequestMethod.GET,value="getall" )
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "list nace items ", notes = "lists  all nace items ")
    public  List<Nace> getAllProducts() {
    	  logger.debug("Entered getAllProducts >>");
          return service.getAllNaces();
    }



}
