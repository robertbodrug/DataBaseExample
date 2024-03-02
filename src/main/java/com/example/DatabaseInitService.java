package com.example;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Paths;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.function.Consumer;

public class DatabaseInitService {
    public static void main(String[] args) {
        try (Statement statement = Database.getInstance().getConnection().createStatement()) {

            List<String> queries = QueryToString.convert(new File("sql\\init_db.sql"));

            for (String query : queries) {
                statement.executeUpdate(query);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    }
