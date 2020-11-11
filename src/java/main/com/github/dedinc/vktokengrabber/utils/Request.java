package com.github.dedinc.vktokengrabber.utils;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.RequestBody;
import okhttp3.Response;

public class Request {
	
	public static String post(String url, String json) {
		try {
			final MediaType JSON = MediaType.parse("application/json; charset=utf-8");
			OkHttpClient client = new OkHttpClient();
			  RequestBody body = RequestBody.create(JSON, json);
			  okhttp3.Request request = new okhttp3.Request.Builder()
			      .url(url)
			      .post(body)
			      .build();
			  Response response = client.newCall(request).execute();
			  return response.body().string();
		    } catch (Exception e) {
		    }
		return null;
		}
	
	public static String get(String url) {
		try {
			OkHttpClient client = new OkHttpClient();
			okhttp3.Request req = new okhttp3.Request.Builder()
					.url(url)
					.build();
			Response res = client.newCall(req).execute();
			return res.body().string();
		  } catch (Exception e) {
		}
		return null;
	 }
}
