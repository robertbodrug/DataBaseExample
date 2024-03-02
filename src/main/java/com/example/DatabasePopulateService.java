package com.example;

import java.io.File;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.Set;

public class DatabasePopulateService {
    public static void main(String[] args) {
        try (Statement statement = Database.getInstance().getConnection().createStatement()) {
        DatabaseInitService.main(new String[1]);
            List<String> queries = QueryToString.convert(new File("sql\\populate_db.sql"));
            for (String query : queries) {
                statement.executeUpdate(query);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
