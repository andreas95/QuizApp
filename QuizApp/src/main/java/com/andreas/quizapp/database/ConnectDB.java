package main.java.com.andreas.quizapp.database;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.MongoCollection;
import org.bson.Document;
import javafx.application.Platform;
import java.util.ArrayList;

public class ConnectDB {
    private static MongoClient mongoClient;
    private static MongoDatabase database;

    public ConnectDB() {
        //Mongo URI details
        MongoClientURI uri = new MongoClientURI(
                "mongodb+srv://quizapp:6AJQXCPNj3hxPFPi@cluster0-djvd1.gcp.mongodb.net/test?retryWrites=true&w=majority");
        try {
            //create connection and get database
            mongoClient = new MongoClient(uri);
            database = mongoClient.getDatabase("Cluster0");
            //create collection if does not exists
            if (!database.listCollectionNames().into(new ArrayList<String>()).contains("quizQuestions")) database.createCollection("quizQuestions");
            //get collection
            MongoCollection<Document> collection = database.getCollection("quizQuestions");
            //insert built-in documents if collection is empty
            if (collection.countDocuments() == 0) collection.insertMany(QuestionsDB.getBuiltInQuestions());
        } catch (Exception e) {
            Platform.exit();
            System.exit(-1);
        }
    }

    public static MongoClient getClient() { return mongoClient; }
    public static MongoDatabase getDatabase() { return database; }
}
