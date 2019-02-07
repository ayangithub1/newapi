package com.qa.client;

import java.io.IOException;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;


//To Get URL
public class RestClient {

	public CloseableHttpResponse getmethod (String url) throws ClientProtocolException, IOException {
		
		CloseableHttpClient closeablehttpclient=HttpClients.createDefault(); // create a new connection
		HttpGet httpsget = new HttpGet(url);//get the url
		CloseableHttpResponse closeablehttpresponse=closeablehttpclient.execute(httpsget);
		return closeablehttpresponse;
	}
}
