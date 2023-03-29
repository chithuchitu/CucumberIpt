package com.api.basicscript;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class ReqRes_In {
	
	public static void singleUserGet() {
		RestAssured.baseURI="https://reqres.in/";
		Response response = RestAssured.given().when().get("api/users/2").
		then().log().all().extract().response();
		 int statusCode = response.getStatusCode();
		 String a = response.asPrettyString();
		 System.out.println("The Status Code"+statusCode);
		 System.out.println("The Response"+a);
	
	}
	public static void singleUserNotFound() {
		RestAssured.baseURI="https://reqres.in/";
		Response response = RestAssured.given().when().get("https://reqres.in/api/users/23").
		then().log().all().extract().response();
		int statusCode = response.getStatusCode();
		 String a = response.asPrettyString();
		 System.out.println("The Status Code"+statusCode);
		 System.out.println("The Response"+a);
	
	

	}
	public static void singleUsercreate() {
		RestAssured.baseURI="https://reqres.in/";
		Response response = RestAssured.given().body("{\r\n"
				+ "    \"name\": \"chithra\",\r\n"
				+ "    \"job\": \"TestEngineer\"\r\n"
				+ "}").when().post("https://reqres.in/api/users")
			 .then().log().all().extract().response();
		 int statusCode = response.getStatusCode();
		 String a = response.asPrettyString();
		 System.out.println("The Status Code"+statusCode);
		 System.out.println("The Response"+a);
		
		
	}
	private static void patchSingleuser(){
		RestAssured.baseURI="https://reqres.in/";
		Response response = RestAssured.given().body("{\r\n"
				+ "    \"name\": \"morpheus\",\r\n"
				+ "    \"job\": \"zion resident\"\r\n"
				+ "}").when().patch("api/users/2")
			 .then().log().all().extract().response();
		 int statusCode = response.getStatusCode();
		 String a = response.asPrettyString();
		 System.out.println("The Status Code"+statusCode);
		 System.out.println("The Response"+a);
		
		

	}
	public static void PutSingleUserupdate() {
		RestAssured.baseURI="https://reqres.in/";
		Response response = RestAssured.given().body("{\r\n"
				+ "    \"name\": \"chithu\",\r\n"
				+ "    \"job\": \"QA\"\r\n"
				+ "}").put("https://reqres.in/api/users/2").then().log().all().extract().response();
		int statusCode = response.getStatusCode();
		 String a = response.asPrettyString();
		 System.out.println("The Status Code"+statusCode);
		 System.out.println("Response"+a);
	

	}
	public static void singleUserdelete() {
		RestAssured.baseURI="https://reqres.in/";
		Response response = RestAssured.given().delete("https://reqres.in/api/users/2").then().log().all().extract().response();
		int statusCode = response.getStatusCode();
		 String a = response.asPrettyString();
		 System.out.println("The Status Code"+statusCode);
		 System.out.println("Deleted");
	
		
	}
	
	public static void multiUserGet() {
		RestAssured.baseURI="https://reqres.in/";
		Response response = RestAssured.given().get("https://reqres.in/api/users?page=2").then().log().all().extract().response();
		int statusCode = response.getStatusCode();
		 String a = response.asPrettyString();
		 System.out.println("The Status Code"+statusCode);
		 System.out.println("The Response"+a);
	
	

	}
	
	public static void singleResource() {
		RestAssured.baseURI="https://reqres.in/";
		 Response response = RestAssured.given().get("https://reqres.in/api/users").then().log().all().extract().response();
		 int statusCode = response.getStatusCode();
		 String a = response.asPrettyString();
		 System.out.println("The Status Code"+statusCode);
		 System.out.println("The Response"+a);
	
		
		

	}
	public static void singleResourceNotFound() {
		RestAssured.baseURI="https://reqres.in/";
		 Response response = RestAssured.given().get("https://reqres.in/api/users/23"
		 		+ "").then().log().all().extract().response();
		 int statusCode = response.getStatusCode();
		 System.out.println("The Status Code"+statusCode);
		 System.out.println("The Response404 -Resource Not Found");
	
		
	}
	public static void registerSuccess() {
		RestAssured.baseURI="https://reqres.in/";
		 Response response = RestAssured.given().body("{\r\n"
		 		+ "    \"email\": \"eve.holt@reqres.in\",\r\n"
		 		+ "    \"password\": \"pistol\"\r\n"
		 		+ "}").when().post("api/register").then().log().all().extract().response();
		 		 
		 int statusCode = response.getStatusCode();
		 System.out.println("The Status Code"+statusCode);
		 
	}
	public static void registerUnsuccess() {
		RestAssured.baseURI="https://reqres.in/";
		Response response = RestAssured.given().body("{\r\n"
				+ "    \"email\": \"peter@klaven\"\r\n"
				+ "}"
				 ).when().post("api/login").then().log().all().extract().response();
		 
		 int statusCode = response.getStatusCode();
		 String a = response.asPrettyString();
		 System.out.println("The Status Code"+statusCode);
		 System.out.println("The Response"+a);
	
		 
	}
	public static void loginSuccess() {
		RestAssured.baseURI="https://reqres.in/";
		Response response = RestAssured.given().body("{\r\n"
				+ "\"email\": \"eve.holt@reqres.in\",\r\n"
				+ "\"password\": \"cityslicka\"\r\n"
				+ "}").when().post("api/login")
			 .then().log().all().extract().response();
		 int statusCode = response.getStatusCode();
		 String a = response.asPrettyString();
		 System.out.println("The Status Code"+statusCode);
		 System.out.println("The Response"+a);
		
	}
	public static void loginUnsuccess() {
		RestAssured.baseURI="https://reqres.in/";
		Response response = RestAssured.given().body("{\r\n"
				+ "    \"email\": \"sydney@fife\"\r\n"
				+ "}")
				.post("api/login").then().log().all().extract().response();
 
int statusCode = response.getStatusCode();
String a = response.asPrettyString();
System.out.println("The Status Code"+statusCode);
System.out.println("The Response"+a);

	}
	public static void delayedResponse() {
		RestAssured.baseURI="https://reqres.in/";
		Response response = RestAssured.given().get("api/users?delay=3").then().log().all().extract().response();
		 int statusCode = response.getStatusCode();
		 String a = response.asPrettyString();
		 System.out.println("The Status Code"+statusCode);
		 System.out.println("The Response"+a);
	
	}
	

	public static void main(String[] args) {
		//  singleUserGet();
	//	singleUsercreate();
		//	singleUserdelete();
		//  PutSingleUserupdate();
		//	singleUserNotFound();
		//	multiUserGet();
		//	singleResource();
			singleResourceNotFound();
		//  registerSuccess();
		//registerUnsuccess();
		//patchSingleuser();
		//loginSuccess();
		//	loginUnsuccess();
		//	delayedResponse();



		
		 
		
		
		
	}
}
