package com.qa.test;

import java.io.IOException;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.qa.base.TestBase;
import com.qa.client.RestClient;
import com.qa.util.TestUtil;


public class GetClient extends TestBase {

	TestBase base;
	String url1;
	String endpoint;
	String url;
	RestClient restclient;
	CloseableHttpResponse closeablehttpresponse;
	TestUtil util;
	
	public  void getClient() {
		base =new TestBase();
		url1 = prop.getProperty("URL");
		endpoint =prop.getProperty("serviceURL");
		url = url1+endpoint;
		
	}
	
	
	@Test()
	public void getcheck() throws ClientProtocolException, IOException {
		restclient =new RestClient();
		closeablehttpresponse=restclient.getmethod(url);
	
	//check the status code (get statusLine and status code)
		int statuscode=closeablehttpresponse.getStatusLine().getStatusCode();
		Assert.assertEquals(200, statuscode);
		
	//convert it to String (Entity utils)
		String responsestring=EntityUtils.toString(closeablehttpresponse.getEntity(),"UTF-8");
		
	///convert it to JSONObject
		JSONObject jsonobject =new JSONObject(responsestring);
		System.out.println("JSON Output"+jsonobject);
		
	//	verify the value
		 util =new TestUtil();
		String id=util.getValueByPath(jsonobject, "/id");
		Assert.assertEquals(id, "2");
		String first_name=util.getValueByPath(jsonobject, "/data[0]/first_name");
		Assert.assertEquals("Janet", first_name);
		
		// verify another value
		util.getValueByPath(responsejson, jpath);

		util.getClass();

		util.toString();

	}
}
