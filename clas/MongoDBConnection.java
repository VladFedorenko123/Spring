package com.srccode.clas;

import org.bson.Document;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.srccode.interfaces.ConnectMongoDB;

public class MongoDBConnection implements ConnectMongoDB {
	@Override
	public String connection() {
		PropertySingleton properties = new PropertySingleton();
		MongoClient mongo = new MongoClient(properties.mongoUrl, Integer.parseInt(properties.mongoPort));
		MongoDatabase database = mongo.getDatabase(properties.mongoDatabase);
		MongoCollection<Document> collection = database.getCollection(properties.mongoCollection);

		String text = collection.find().first().getString("str");
		mongo.close();
		return text;
	}
}
