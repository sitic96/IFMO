package DBWorker;

import java.sql.SQLException;
import java.util.Collection;
import java.util.HashSet;

/**
 * Created by sitora on 12.11.16.
 */
public interface DBWorkMethods {

    public void add(Table element) throws SQLException;

    public void update(Integer id, Table element) throws SQLException;

    public Table getElementById(Integer id) throws SQLException;

    public Collection getAllElements() throws SQLException;

    public void removeElement(Table element) throws SQLException;

    public HashSet<String> getAllAvailableActions();
}
