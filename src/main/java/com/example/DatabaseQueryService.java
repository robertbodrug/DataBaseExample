package com.example;

import com.example.entries.*;

import java.io.File;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;

public class DatabaseQueryService {

    public static List<MaxProjectCountClient> findMaxProjectsClient(){

        List<MaxProjectCountClient> result = new LinkedList<>();

        try (PreparedStatement statement = Database.getInstance().getConnection().prepareStatement(QueryToString.convert(new File("sql\\find_max_projects_client.sql"))))
        {
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()){
                result.add(new MaxProjectCountClient(resultSet.getString(1),resultSet.getInt(2)));
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return result;
    }

    public static List<MaxSalaryCountWorker> findMaxSalaryWorker(){

        List<MaxSalaryCountWorker> result = new LinkedList<>();

        try (PreparedStatement statement = Database.getInstance().getConnection().prepareStatement(QueryToString.convert(new File("sql\\find_max_salary_worker.sql")))) {
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()){
                result.add(new MaxSalaryCountWorker(resultSet.getString(1),resultSet.getInt(2)));
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return result;
    }

    public static List<MaxAgeCountProject> findLongestProject(){

        List<MaxAgeCountProject> result = new LinkedList<>();

        try (PreparedStatement statement = Database.getInstance().getConnection().prepareStatement(QueryToString.convert(new File("sql\\find_max_salary_worker.sql")))) {

            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()){
                result.add(new MaxAgeCountProject(resultSet.getInt(1), LocalDate.parse(resultSet.getString(2))));
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return result;
    }

    public static List<YongestEldestWorker> findYoungestEldestWorkers(){

        List<YongestEldestWorker> result = new LinkedList<>();

        try (PreparedStatement statement = Database.getInstance().getConnection().prepareStatement(QueryToString.convert(new File("sql\\find_youngest_eldest_workers.sql")))) {

            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()){
                result.add(new YongestEldestWorker(resultSet.getString(1),resultSet.getString(2),LocalDate.parse(resultSet.getString(3))));
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return result;
    }

    public static List<ProjectPrices> findProjectPrices(){

        List<ProjectPrices> result = new LinkedList<>();

        try (PreparedStatement statement = Database.getInstance().getConnection().prepareStatement(QueryToString.convert(new File("sql\\find_youngest_eldest_workers.sql")))) {

            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()){
                result.add(new ProjectPrices(resultSet.getInt(1),resultSet.getInt(2)));
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return result;
    }

}
