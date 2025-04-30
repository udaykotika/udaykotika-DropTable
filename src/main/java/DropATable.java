
import Util.ConnectionUtil;
import Util.FileUtil;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

/*
 * SQL sublanguage: DDL (Data Definition Language)
 *
 * In the last activity we learned how to create tables in SQL. In this activity we are going to learn how to drop a table from our database.
 *
 * The syntax for dropping a table is as follows:
 * DROP TABLE table_name;
 */
public class DropATable {

    /**
     * Task: Drop the table "song"
     * song Table Diagram:
     * | title | artist |
     * ---------------------------------------------
     * |'Let it be' |'Beatles' |
     * |'Hotel California' |'Eagles' |
     * |'Kashmir' |'Led Zeppelin' |
     */
    public void problem1() {
        String sql;
        try {
            // Read the SQL statement from the file
            sql = FileUtil.parseSQLFile("problem1.sql");
        } catch (IOException e) {
            System.err.println("Failed to read SQL file: " + e.getMessage());
            return;
        }

        // Execute the SQL statement
        try (Connection connection = ConnectionUtil.getConnection();
                Statement statement = connection.createStatement()) {

            statement.executeUpdate(sql);
            System.out.println("Table 'song' dropped successfully.");

        } catch (SQLException e) {
            System.err.println("SQL execution failed: " + e.getMessage());
        }
    }
}
