package DBWorker;

import fs_classes.classes.Person;
import org.apache.commons.beanutils.BeanUtils;
import org.hibernate.Session;

import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.Collection;
import java.util.HashSet;
import java.util.Map;

/**
 * Created by sitora on 13.11.16.
 */
public class DBUtils {
    private static final HashSet<String> TABLES;

    static {
        Session session = session = HibernateUtil.getSessionFactory().openSession();
        TABLES = new HashSet<>(session.createSQLQuery("SHOW TABLES").list());
        session.close();
    }

    public static HashSet<String> getParameteres(String tableName) throws SQLException {
        if (TABLES.contains(tableName)) {
            switch (tableName.toUpperCase()) {
                case "PERSON": {
                    return Person.COLUMNS;
                }
            }
        } else {
            throw new SQLException("No such table!");
        }
        return null;
    }

    public static void addInTable(String tableName, Map<String, Object> values) {
        try {
            Table table = fillObject(tableName, values);
            table.getDAO().add(table);
            table = null;
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void removeFromTable(String tableName, Map<String, Object> values) {
        try {
            Table table = fillObject(tableName, values);
            table.getDAO().removeElement(table);
            table = null;
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static Collection showTable(String tableName) {
        Collection collection = null;
        try {
            Table table = ((Class<? extends Table>) Class.forName("fs_classes.classes." + tableName)).newInstance();
            collection = table.getDAO().getAllElements();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return collection;
    }

    private static Table fillObject(String tableName, Map<String, Object> values) {
        Table table = null;
        try {
            table = ((Class<? extends Table>) Class.forName("fs_classes.classes." + tableName)).newInstance();
            for (String s : values.keySet()) {
                if (values.get(s) instanceof Integer) {
                    BeanUtils.setProperty(table, s.toLowerCase(), (Integer) values.get(s));
                } else {
                    BeanUtils.setProperty(table, s.toLowerCase(), values.get(s));
                }
            }

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
        return table;
    }

    public static HashSet<String> getTABLES() {
        return TABLES;
    }

}
