package connectors;

import org.neo4j.driver.v1.*;

import java.util.ArrayList;
import java.util.List;

import static org.neo4j.driver.v1.Values.parameters;

/**
 * Created by sitora on 22.04.17.
 */
public class Neo4jConnector implements Connector {
    private static Neo4jConnector instance;
    Driver driver;
    Session session;

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
        session.run("CREATE (a:Airports_DB {code: {code}})",
                parameters("code", code));
    }

    public void addReference(String code1, String code2) {
        session.run("MATCH (u:Airports_DB {code:'" + code1 + "'}), (r:Airports_DB {code:'" + code2 + "'})\n" +
                "CREATE (u)-[:CONNECTED_WITH]->(r)");
    }

    public List<String> getConnectedAirports(String code) {
        List<String> codes = new ArrayList<>();
        StatementResult result = session.run("MATCH (a:Airports_DB{code:'" + code + "'})-[:CONNECTED_WITH]->(d)\n" +
                "RETURN distinct d.code as code");
        while (result.hasNext()) {
            Record record = result.next();
            codes.add(record.get("code").asString() + " ");
        }
        return codes;
    }

    public List<String> getWay(String code1, String code2) {
        List<String> codes = new ArrayList<>();
        StatementResult result = session.run("MATCH (f:Airports_DB {code: \"" + code1 + "\"}), (t:Airports_DB {code: \"" + code2 + "\"}), \n" +
                "p = shortestPath((f)-[*..25]-(t)) RETURN p");
        while (result.hasNext()) {
            Record record = result.next();
            codes.add(record.get("code").asString() + " ");
        }
        return codes;
    }
}
