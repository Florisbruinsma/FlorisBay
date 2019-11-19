package com.FlorisBay;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.client.HttpClient;

@WebServlet(urlPatterns = {"/Login"})
public class LoginServlet extends HttpServlet {
	
	//create return the json of the created object
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException {
		PrintWriter out = res.getWriter();
		String username = req.getParameter("username");
	    String password = req.getParameter("password");
	    
//	    HttpClient httpClient = HttpClientBuilder.create().build(); //Use this instead 

	    String payload = String.format("{" +
                "\"username\": \"%s\", " +
                "\"password\": \"%s\", " +
                "}",username, password);
        StringEntity entity = new StringEntity(payload,
                ContentType.APPLICATION_FORM_URLENCODED);

        HttpClient httpClient = HttpClientBuilder.create().build();
        HttpPost request = new HttpPost("http://localhost:8080/FlorisBayServer/LoginServlet");
        request.setEntity(entity);

        HttpResponse response = httpClient.execute(request);
        System.out.println(response.getStatusLine().getStatusCode());
	    String result = response.getHeaders("result")[0].getValue();
	    
		res.sendRedirect(req.getContextPath() + "/Login.jsp?login_state=" + result);
	}
}
