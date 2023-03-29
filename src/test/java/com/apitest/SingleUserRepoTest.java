package com.apitest;

import org.junit.Assert;
import org.testng.annotations.Test;
import com.api.baseclass.Constants;
import com.api.client.SingleUserClients;
import io.restassured.response.Response;


public class SingleUserRepoTest {
	
	
SingleUserClients singleUser = new SingleUserClients();

	@Test(description = "This api or valid AUth",priority = 1)
	 private void getSingleUserWithValidAuth() {
		 Response response = singleUser.getUserDetailsWithValidAuth("chithuchitu","Flipkart-Rpo");
		 System.out.println(response);
		 Assert.assertEquals(response.getStatusCode(), Constants.HTTP_STATUS_CODE_OK);

	}
	
	@Test(description = "This api for inavlidAuth ",priority = 2)
	private void getSingleUserWithInValidAuth() {
		Response response = singleUser.getUserDetailsWithInValidAuth("chithuclhitu", "https://github.com/chithuchitu/Flipkart.git");
		 Assert.assertEquals(response.getStatusCode(), Constants.HTTP_STATUS_CODE_UNAUHORIZED);


	}
	
	@Test(description = "This api for Invalid Repo",priority = 3)
	private void getSingleUserWithInvaldRepo() {
		Response response = singleUser.getUserDetailsWithValidAuth("chithuchitu", "https://github.com/chithuchitu/Flipkarhht.git");
		 Assert.assertEquals(response.getStatusCode(), Constants.HTTP_STATUS_CODE_NOT_FOUND);
	}
}
