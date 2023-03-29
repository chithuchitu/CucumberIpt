package com.api.client;

import java.util.HashMap;
import java.util.Map;

import com.api.baseclass.Endpoints;
import com.api.baseclass.HTTPSMethods;

import io.restassured.response.Response;

public class SingleUserClients {

	Map<String, String> validHeader = new HashMap<>();
	Map<String, String> inValidHeader = new HashMap<>();

	public SingleUserClients() {

		try {
			validHeader.put("Accept", "application/vnd.github+json");
			validHeader.put("Authorization", "Bearer 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");

			inValidHeader.put("Accept", "application/vnd.github+json");
			inValidHeader.put("Authorization", "Bearer ghp_BIV833P5z6BcKR3vj2HrKFM2k0ScZD2WKKtjjjjjjjjUgg");

		} catch (Exception e) {
			System.out.println(e);
		}

	}
	public Map<String, String> getValidHeader() {
		return validHeader;
	}
	public Map<String, String> getInValidHeader() {
		return inValidHeader;
	}
	
	public Response getUserDetailsWithValidAuth(String owner, String repo) {
		String endpoint = Endpoints.singleUser.GET_SINGLE_USER.replaceAll("\\{Owner\\}", owner).replaceAll("\\{Repo\\}",repo);
		Response Response = HTTPSMethods.doGetCall(getValidHeader(), endpoint);
		return Response;
	}

	public Response getUserDetailsWithInValidAuth(String owner, String repo) {
		String endpoint = Endpoints.singleUser.GET_SINGLE_USER.replaceAll("\\{Owner\\}", owner).replaceAll("\\{Repo\\}",
				repo);
		Response Response = HTTPSMethods.doGetCall(getInValidHeader(), endpoint);
		return Response;
	}

	
	  public Response postUserDetailsWithValidAuth(String owner, String repo,String
	  payload) { 
	  String endpoint = Endpoints.singleUser.GET_SINGLE_USER.replaceAll("\\{Owner\\}",
	  owner).replaceAll("\\{Repo\\}", repo); Response Response =
	  HTTPSMethods.doPostCallWithBody(getInValidHeader(), endpoint, payload);
	  return Response;
	  
	  }
	 

	public Response deleteUserDetailsWithValidAuth(String owner, String repo) {
		String endpoints = Endpoints.singleUser.DELETE_SINGLE_USER.replaceAll("\\{Owner\\}", owner)
				.replaceAll("\\{Repo\\}", repo);
		Response Response = HTTPSMethods.doDeleteCall(validHeader, endpoints);
		return Response;
	}

}
