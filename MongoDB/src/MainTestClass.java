import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;

public class MainTestClass {

	public static void main(String[] args) {
		MongoClientURI connectionStr = new MongoClientURI(
				"mongodb://admin:FRFdvn99235@node69630-mongodb.jls-sto2.elastx.net:11045");
		MongoClient mongoClient = new MongoClient(connectionStr);

	}

}
