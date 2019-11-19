package com.FlorisBayServer;

import java.io.BufferedReader;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.bson.BsonDocument;
import org.bson.Document;
import org.bson.conversions.Bson;
import org.bson.json.JsonMode;
import org.bson.json.JsonWriterSettings;
import org.bson.types.ObjectId;
import org.json.JSONException;
import org.json.JSONObject;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.result.DeleteResult;
import com.mongodb.client.result.UpdateResult;

import static com.mongodb.client.model.Filters.*;
import static com.mongodb.client.model.Updates.*;
import static com.mongodb.client.model.Updates.set;
import static com.mongodb.client.model.Updates.combine;

//TODO HTTP response codes
@WebServlet(urlPatterns = {"/product","/product/","/product/*"})
public class Product extends HttpServlet {
	static String uri = "mongodb://admin:admin@cluster0-shard-00-00-pg9mi.mongodb.net:27017,cluster0-shard-00-01-pg9mi.mongodb.net:27017,cluster0-shard-00-02-pg9mi.mongodb.net:27017/test?ssl=true&replicaSet=Cluster0-shard-0&authSource=admin&retryWrites=true&w=majority";
	static MongoClient mongoClient = new MongoClient(new MongoClientURI(uri));
	static MongoDatabase database = mongoClient.getDatabase("FlorisBayServer");
	static MongoCollection<Document> collection = database.getCollection("Users");
	private JsonWriterSettings writerSettings = new JsonWriterSettings(JsonMode.SHELL, true);
	
	//create return the json of the created object
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
		PrintWriter out = response.getWriter();
		out.println("create");
	}
	//read
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
		PrintWriter out = response.getWriter();
		out.println("read");
	}
	//update
	public void doPut(HttpServletRequest request, HttpServletResponse response) throws IOException {
		PrintWriter out = response.getWriter();
		out.println("update");
	}
	//delete
	public void doDelete(HttpServletRequest request, HttpServletResponse response) throws IOException {
		PrintWriter out = response.getWriter();
		out.println("delete");
	}
}
