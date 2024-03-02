package com.example;

import java.io.File;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.Set;

public class DatabasePopulateService {
    public static void main(String[] args) {
        try (PreparedStatement statement = Database.getInstance().getConnection().prepareStatement(QueryToString.convert(new File("sql\\populate_db.sql")))) {
            DatabaseInitService.main(new String[1]);
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
