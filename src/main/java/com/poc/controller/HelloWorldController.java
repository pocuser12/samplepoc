package com.poc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.poc.model.Response;
import com.poc.model.UserDetail;
import com.poc.service.DemoService;
import com.poc.util.EventCode;

/*
 * REST controller to expose hellowworld as rest endpoint 
 * this class contains 5 different methods that exposed as individual service with in helloworld endpoint 
 *
 */
@Controller
@RequestMapping("/helloWorld")
public class HelloWorldController extends BaseRestController {
	@Autowired
	private DemoService demoService;
	Response<Object> response = null;

	/*
	 * rest url- /helloworld this end point is the main endpoint of service and
	 * returns data from database, inplace of database I have used service url
	 * 
	 * /helloworld is the rest service. this end point have GET method to fetch
	 * query data.
	 */
	@RequestMapping(method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<Response<Object>> fetchData() {

		try {
			List<UserDetail> userDetails = demoService.getUserDetail();
			response = buildResponse(EventCode.REQUEST_SUCCESS.getCode(), "success", userDetails);

		} catch (Exception ex) {
			response = buildResponse(EventCode.SERVER_ERROR.getCode(), ex.getMessage(), true);

		}

		return new ResponseEntity<Response<Object>>(response, HttpStatus.OK);

	}

	/*
	 * rest url- /helloworld this method and rest url is to insert a new record in
	 * DB, it accepts UserDetail objects as required object in json payload
	 */

	@RequestMapping(method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<Response<Object>> insertData(@RequestBody(required = true) UserDetail userDetail) {

		try {
			if (null != userDetail) {
				demoService.insertUserDetail(userDetail);
				response = buildResponse(EventCode.REQUEST_SUCCESS.getCode(), "success",
						"Record inserted successfully");
			} else
				response = buildResponse(EventCode.SERVER_ERROR.getCode(), "success", "User Details is required");
		} catch (Exception ex) {
			response = buildResponse(EventCode.SERVER_ERROR.getCode(), ex.getMessage(), true);

		}

		return new ResponseEntity<Response<Object>>(response, HttpStatus.OK);
	}
	/*
	 * rest url- /helloworld this method and rest url is to delete a record based on
	 * id passed in the service url. rest end point will be /helloworld/10- this API
	 * will delete single record associated with id =10
	 */

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	@ResponseBody
	public ResponseEntity<Response<Object>> deleteData(@PathVariable("id") String id) {

		try {
			demoService.deleteUser(id);
			response = buildResponse(EventCode.REQUEST_SUCCESS.getCode(), "success", "User deleted successfully");

		} catch (Exception ex) {
			response = buildResponse(EventCode.SERVER_ERROR.getCode(), ex.getMessage(), true);

		}

		return new ResponseEntity<Response<Object>>(response, HttpStatus.OK);
	}

	/*
	 * rest url- /helloworld/details this method and rest url will fetch data from
	 * other sericve and display as it is as output I have repeated this method to
	 * build /helloworld/details rest endpoint.
	 */

	@RequestMapping("/detail")
	@ResponseBody
	public ResponseEntity<Response<Object>> getUserDetailString() {

		try {
			List<UserDetail> userDetails = demoService.getUserDetail();
			response = buildResponse(EventCode.REQUEST_SUCCESS.getCode(), "success", userDetails);

		} catch (Exception ex) {
			response = buildResponse(EventCode.SERVER_ERROR.getCode(), ex.getMessage(), true);

		}

		return new ResponseEntity<Response<Object>>(response, HttpStatus.OK);

	}

	/*
	 * rest service to return array of Fibonacci series based on input number
	 */
	@RequestMapping("/fibonacci/{n}")
	@ResponseBody
	public ResponseEntity<Response<Object>> getFibonacci(@PathVariable("n") int number) {

		try {
			response = buildResponse(EventCode.REQUEST_SUCCESS.getCode(), "success", demoService.getFibonacci(number));
		} catch (Exception ex) {
			response = buildResponse(EventCode.SERVER_ERROR.getCode(), ex.getMessage(), true);

		}

		return new ResponseEntity<Response<Object>>(response, HttpStatus.OK);
	}
}
