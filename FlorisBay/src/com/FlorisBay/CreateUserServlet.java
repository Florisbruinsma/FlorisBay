package com.FlorisBay;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.http.Header;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;

@WebServlet(urlPatterns = {"/CreateUser"})
public class CreateUserServlet extends HttpServlet {
	
	//create return the json of the created object
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException {
		PrintWriter out = res.getWriter();
		String username = req.getParameter("username");
	    String password = req.getParameter("password");
//	    String password2 = req.getParameter("password2");
	    String email = req.getParameter("email");
	    String product = String.format("{" +
                "\"name\": \"box\", " +
                "\"tag\": \"electronic\", " +
                "\"price\": \"200\"" +
                "}");
	    String payload = String.format("{" +
                "\"username\": \"%s\", " +
                "\"password\": \"%s\", " +
                "\"email\": \"%s\", " +
                "\"product\": [%s, %s]" +
                "}", username, password, email,product,product);
        StringEntity entity = new StringEntity(payload,
                ContentType.APPLICATION_FORM_URLENCODED);

        HttpClient httpClient = HttpClientBuilder.create().build();
        HttpPost request = new HttpPost("http://localhost:8080/FlorisBayServer/CreateUserServlet");
        request.setEntity(entity);

        HttpResponse response = httpClient.execute(request);
        System.out.println(response.getStatusLine().getStatusCode());
	    out.println(response.getHeaders("result")[0].getValue());
	    
//		out.println("create user" + username + password + email);
	}
}
