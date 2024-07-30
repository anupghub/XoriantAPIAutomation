package apiAutomation;

import org.testng.Assert;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.restassured.RestAssured;

public class FinalPayload {
	public static void main(String args[]) throws JsonProcessingException{
		
		IssueTypes issue = new IssueTypes("Bug");
		Projects project = new Projects("TEST");
		
		Payloads payload = new Payloads("Demo1_SUmmary", "Demo1_Description", issue, project);
		Fields field = new Fields(payload);
		
		
		ObjectMapper obj = new ObjectMapper();
		
		String new_Obj =  obj.writerWithDefaultPrettyPrinter().writeValueAsString(field);
	
		System.out.println(new_Obj);
		
		RestAssured.baseURI = "https://reqres.in/api/users";
		RequestSpecification request = RestAssured.given();
		
		request.contentType(ContentType.JSON);
		request.body(new_Obj);
		
		Response response = request.post("/posts");
		
           System.out.println(response.asString());
		
		String body = response.getBody().asString();
		JsonPath path = new JsonPath(body);
		
		System.out.println(" Response : "+path.get("job"));
		int SC = response.statusCode();
		
		Assert.assertEquals(SC, 200);
		
		
	}

}
