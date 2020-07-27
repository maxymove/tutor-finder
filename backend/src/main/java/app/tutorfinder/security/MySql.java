package app.tutorfinder.security;

import app.tutorfinder.models.CourseTaken;
import app.tutorfinder.models.User;
import app.tutorfinder.models.UserCourse;
import org.springframework.stereotype.Component;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Component
public class MySql {

    private final String jdbcDriverStr = "com.mysql.jdbc.Driver";
    private final String jdbcURL = "jdbc:mysql://localhost/tutorfinder?"
            + "user=root&password=chakeera";

    private Connection connection;
    private Statement statement;
    private ResultSet resultSet;
    private PreparedStatement preparedStatement;

    public MySql() {
        try {
            connection = DriverManager.getConnection(jdbcURL);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

//    public List<UserCourse> getCourseTakenList(String username) {
//        List<UserCourse> courseTakenList = new ArrayList<>();
//        try {
//            connection = DriverManager.getConnection(jdbcURL);
//            statement = connection.createStatement();
//            resultSet = statement.executeQuery("select course_taken.course_id, courses.course_name from course_taken INNER JOIN courses ON course_taken.course_id=courses.course_id where course_taken.username = " + username);
//            while (resultSet.next()) {
//                UserCourse userCourse = new UserCourse();
//                userCourse.setCourseId(resultSet.getString(1));
//                userCourse.setCourseName(resultSet.getString(2));
//                courseTakenList.add(userCourse);
//            }
//        } catch (SQLException throwables) {
//            throwables.printStackTrace();
//        } finally {
//            close();
//        }
//        return courseTakenList;
//    }

    public List<CourseTaken> getCourseTakenList() {
        List<CourseTaken> courseTakenList = new ArrayList<>();
        try {
            connection = DriverManager.getConnection(jdbcURL);
            statement = connection.createStatement();
            resultSet = statement.executeQuery("select * from tutorfinder.course_taken;");
            while (resultSet.next()) {
                CourseTaken courseTaken = new CourseTaken();
                courseTaken.setId(resultSet.getLong(1));
                courseTaken.setCourseId(resultSet.getString(2));
                courseTaken.setUsername(resultSet.getString(3));
                courseTakenList.add(courseTaken);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            close();
        }
        return courseTakenList;
    }

    public void insertCourse(String username, String courseId) {
        try {
            connection = DriverManager.getConnection(jdbcURL);
            String query = " insert into tutorfinder.course_taken (username, course_id)"
                    + " values (?, ?)";
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, courseId);
            preparedStatement.execute();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            close();
        }
    }

    public void deleteCourse(String username, String courseId) {
        try {
            connection = DriverManager.getConnection(jdbcURL);
            String query = " delete from tutorfinder.course_taken where username = ? and course_id = ?";
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, courseId);
            preparedStatement.execute();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            close();
        }
    }

    public User getUser(String username) {
        for (User user : getUsers()) {
            if (user.getUsername().equals(username)) {
                return user;
            }
        }
        return null;
    }

    public List<User> getUsers() {
        List<User> users = new ArrayList<>();
        try {
            connection = DriverManager.getConnection(jdbcURL);
            statement = connection.createStatement();
            resultSet = statement.executeQuery("select * from tutorfinder.users;");
            while (resultSet.next()) {
                User user = new User();
                user.setId(resultSet.getLong(1));
                user.setEmail(resultSet.getString(2));
                user.setPassword(resultSet.getString(3));
                user.setUsername(resultSet.getString(4));
                users.add(user);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            close();
        }
        return users;
    }

    public void close() {
        try {
            if (resultSet != null) {
                resultSet.close();
            }
            if (statement != null) {
                statement.close();
            }
            if (connection != null) {
                connection.close();
            }
        } catch (Exception e) {
        }
    }
}