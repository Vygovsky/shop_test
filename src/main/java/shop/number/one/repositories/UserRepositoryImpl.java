package shop.number.one.repositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import shop.number.one.model.User;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

@Repository
public class UserRepositoryImpl implements UserRepository {

    private final static String BD_FIND_ALL_USERS = "SELECT*FROM USER";
    private final static String BD_FIND_BY_ID_USER = "SELECT * FROM USER WHERE ID=?";
    private final static String BD_INSERT_USER = "INSERT INTO USER (NICKNAME, EMAIL, BIRTHDAY) VALUES (?,?,?)";
    private final static String BD_DELETE_USER = "DELETE FROM USER WHERE ID=?";
    private final static String BD_UPDATE_USER = "UPDATE USER SET NICKNAME = ?, EMAIL = ?, BIRTHDAY = ? WHERE ID = ?";

    @Autowired
    private DataSource dataSource;

    @Override
    public Collection<User> findAll() {
        Connection connection = null;
        List<User> users = new ArrayList<>();
        try {
            connection = dataSource.getConnection();
            connection.setAutoCommit(false);
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(BD_FIND_ALL_USERS);
            while (resultSet.next()) {
                User user = new User();
                //user.setId(UUID.fromString(resultSet.getString("id")));
                user.setId(resultSet.getLong("id"));
                user.setNickname(resultSet.getString("nickName"));
                user.setEmail(resultSet.getString("email"));
                user.setBirthday(resultSet.getDate("birthday"));
                users.add(user);
                connection.commit();
            }
        } catch (SQLException ex) {
            System.out.println("SQLException. Executing rollback to savepoint..." + ex);
            ifRollback(connection);
        }
        return users;
    }

    @Override
    public User findById(UUID uuid) {
        Connection connection = null;
        User user = new User();
        try {
            connection = dataSource.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(BD_FIND_BY_ID_USER);
            preparedStatement.setString(1, String.valueOf(uuid));
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
               // user.setId(UUID.fromString(resultSet.getString("id")));
                user.setId(resultSet.getLong("id"));
                user.setNickname(resultSet.getString("nickName"));
                user.setEmail(resultSet.getString("email"));
                user.setBirthday(resultSet.getDate("birthday"));
            }
        } catch (SQLException ex) {
            System.out.println("SQLException. Executing rollback not user by uuid ..." + ex);
            ifRollback(connection);
        }
        return user;
    }

    private void ifRollback(Connection connection) {
        if (Objects.nonNull(connection)) {
            try {
                connection.rollback();
            } catch (SQLException e) {
                //do nothing, but it could be logged
            }
        }
    }

    @Override
    public User save(User user) {
        Connection connection = null;
        Date birthday = user.getBirthday();
        java.sql.Date sqlDate = new java.sql.Date(birthday.getTime());
        try {
            connection = dataSource.getConnection();
            connection.setAutoCommit(false);
            PreparedStatement preparedStatement = connection.prepareStatement(BD_INSERT_USER);
            preparedStatement.setString(1, user.getNickname());
            preparedStatement.setString(2, user.getEmail());
            preparedStatement.setDate(3, sqlDate);
            preparedStatement.executeUpdate();
            connection.commit();
        } catch (SQLException ex) {
            System.out.println("SQLException. Executing rollback to savepoint..." + ex);
            ifRollback(connection);
        }
        return user;
    }


    @Override
    public User update(User user) {
        Connection connection = null;
        Date birthday = user.getBirthday();
        java.sql.Date sqlDate = new java.sql.Date(birthday.getTime());
        try {
            connection = dataSource.getConnection();
            connection.setAutoCommit(false);
            PreparedStatement preparedStatement = connection.prepareStatement(BD_UPDATE_USER);
            preparedStatement.setString(1, user.getNickname());
            preparedStatement.setString(2, user.getEmail());
            preparedStatement.setDate(3, sqlDate);
            preparedStatement.setString(4, String.valueOf(user.getId()));
            preparedStatement.executeUpdate();
            connection.commit();
        } catch (SQLException ex) {
            System.out.println("SQLException. Executing rollback to update..." + ex);
            ifRollback(connection);
        }
        return user;
    }

    @Override
    public void delete(UUID uuid) {
        Connection connection = null;
        try {
            connection = dataSource.getConnection();
            connection.setAutoCommit(false);
            PreparedStatement preparedStatement = dataSource.getConnection().prepareStatement(BD_DELETE_USER);
            preparedStatement.setString(1, String.valueOf(uuid));
            preparedStatement.executeUpdate();
            connection.commit();
        } catch (SQLException ex) {
            System.out.println("SQLException. Executing rollback to delete..." + ex);
            ifRollback(connection);
        }
    }
}


