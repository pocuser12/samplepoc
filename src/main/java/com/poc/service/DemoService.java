package com.poc.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.poc.config.AppConfig;
import com.poc.dao.DemoDAO;
import com.poc.model.UserDetail;


/*
 * service layer that contains business logic 
 * integrate with DAO layer to fetch data based on business logic.
 * 
 */

@Service
public class DemoService {
@Autowired DemoDAO demoDAO;
@Autowired AppConfig appconfig;
	public List<UserDetail> getUserDetail() throws Exception {
		
		/*
		 * get api to query data also same method used to fetch data from other service
		 * third party service url fetched from property file. 
		 */
		ResponseEntity<List<UserDetail>> response = new RestTemplate().exchange(
				appconfig.getServiceURL(), HttpMethod.GET, null,
				new ParameterizedTypeReference<List<UserDetail>>() {
				});
		List<UserDetail> details = response.getBody();
		return details;
	}
	
	/*
	 * insert method to insert data of userDetail through DAO layer
	 */
	public int insertUserDetail(UserDetail userDetail) throws Exception {
		 
		int result =demoDAO.saveData(userDetail);
		return result;
	}
/*
 * delete method to delete data based on id 
 */
	public int deleteUser(String id) throws Exception {
		 
		int result =demoDAO.deleteData(id);
		return result;
	}
	
	 /*
	  * based on input number method to generate fibonacci data and saved in list object.
	  */
	public List<Integer> getFibonacci(int number) throws Exception {

		List<Integer> fibList = new ArrayList<Integer>();

		for (int i = 0; i < number; i++) {
			fibList.add(Fibonacci(i));
		}
		return fibList;
	}
/*
 * recursive method to get fibonacci series 
 */
	private static int Fibonacci(int number) throws Exception  {
		if (number <= 1)
			return number;

		return Fibonacci(number - 2) + Fibonacci(number - 1);
	}

}
