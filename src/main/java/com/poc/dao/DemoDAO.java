package com.poc.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.poc.model.UserDetail;
/*
 * this is DAO class to connect with DataBase , 
 * this class is responsible for all DBrelated queries and contains all CRUD operations dummy method
 * 
 */
@Repository("demoDAO")


public class DemoDAO {

	/*
	 * mock fetch query that will connect with DB to fetch data (select query)
	 */
	public List<UserDetail> getData()throws Exception
	{
		List<UserDetail> userList=new ArrayList<UserDetail>();
	
		return userList;
	}
	
	
	/*
	 * mock insert query that will connect with DB to insert records (insert query)
	 */
	public int saveData(UserDetail userDetail)throws Exception
	{
		int result=1;
		//result=db qquery to insert data that will retunr number of records to be added 
	
		return result;
	}
	
	

	/*
	 * mock fetch query that will connect with DB to fetch data (select query)
	 */
	public int deleteData(String id)throws Exception
	{
		int result=1;
		//result=db qquery to delete data that based on id and return reslut 
	
		return result;
	}
}
