package connectors;

import org.neo4j.driver.v1.AuthTokens;
import org.neo4j.driver.v1.Driver;
import org.neo4j.driver.v1.GraphDatabase;
import org.neo4j.driver.v1.Session;
import org.neo4j.driver.v1.types.Relationship;

import static org.neo4j.driver.v1.Values.parameters;

/**
 * Created by sitora on 22.04.17.
 */
public class Neo4jConnector implements Connector {
    private static Neo4jConnector instance;
    Driver driver;
    Session session;
    Relationship relationship;

    public static Neo4jConnector getInstance() {
        if (instance == null) {
            instance = new Neo4jConnector();
        }
        return instance;
    }

    private Neo4jConnector() {
        this.connect();
    }

    @Override
    public void connect() {
        driver = GraphDatabase.driver("bolt://localhost:7687", AuthTokens.basic("neo4j", "neo4j"));
        session = driver.session();
    }

    public void save(String code) {
        session.run("CREATE (a:Airports {code: {code}})",
                parameters("code", code));
    }

    public void addReference(String code1, String code2) {
        session.run("MATCH (u:Airports {code:'" + code1 + "'}), (r:Airports {code:'" + code2 + "'})\n" +
                    "CREATE (u)-[:CONNECTED_WITH]->(r)");
    }
}
