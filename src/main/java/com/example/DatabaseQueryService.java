package com.example;

import com.example.entries.MaxProjectCountClient;

import java.io.File;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class DatabaseQueryService {

    public static List<MaxProjectCountClient> findMaxProjectsClient(){
        List<MaxProjectCountClient> result = new LinkedList<>();
        try (Statement statement = Database.getInstance().getConnection().createStatement()) {
            List<String> query = QueryToString.convert(new File("sql\\find_max_projects_client.sql"));
                ResultSet resultSet = statement.executeQuery(query.get(0));
            while (resultSet.next()){
                result.add(new MaxProjectCountClient(resultSet.getString(2),resultSet.getInt(1)));
            }


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
return result;
    }


}
