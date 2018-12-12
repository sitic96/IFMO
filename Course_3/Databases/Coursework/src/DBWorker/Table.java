package DBWorker;

/**
 * Created by sitora on 13.11.16.
 */
public abstract class Table {
    private final static int COLUMN_COUNT = -1;

    public abstract DBWorkMethods getDAO();

    @Override
    public String toString() {
        return "Table{}";
    }
}
