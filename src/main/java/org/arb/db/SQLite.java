package org.arb.db;

import java.sql.*;

public class SQLite {
    private Connection conn = null;

// "jdbc:sqlite:D:/projects/java/opencv/sqlite.db";
    public void connect(String url) {
        try {
            // create a connection to the database
            this.conn = DriverManager.getConnection(url);

            System.out.println("Connection to SQLite has been established.");

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void createNewTable() throws SQLException {
        // SQL statement for creating a new table
        String sql = "CREATE TABLE IF NOT EXISTS activity (\n"
                + "	 id integer PRIMARY KEY\n"
                + ", activity_date datetime NOT NULL\n"
                + ", face_found int NOT NULL\n"
                + ");";

        Statement stmt = this.conn.createStatement();
        stmt.execute(sql);
    }

    public void insertActivity(int exists) throws SQLException {
        // SQL statement for creating a new table
        String sql = "insert into activity (activity_date, face_found)\n"
                + "	 values (CURRENT_TIMESTAMP, " + String.valueOf(exists) + ");";

        Statement stmt = this.conn.createStatement();
        stmt.execute(sql);
    }

    public void close() {
        try {
            if (this.conn != null) {
                this.conn.close();
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }


    public void getCapacityGreaterThan(double capacity) throws SQLException {
        String sql = "SELECT id, name, capacity "
                + "FROM warehouses WHERE capacity > ?";

        PreparedStatement pstmt  = this.conn.prepareStatement(sql);
        // set the value
        pstmt.setDouble(1, capacity);
        //
        ResultSet rs = pstmt.executeQuery();

        // loop through the result set
        while (rs.next()) {
            System.out.println(rs.getInt("id") + "\t" +
                    rs.getString("name") + "\t" +
                    rs.getDouble("capacity"));
        }
    }
}
