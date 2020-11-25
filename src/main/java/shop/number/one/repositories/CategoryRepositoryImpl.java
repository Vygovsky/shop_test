
package shop.number.one.repositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import shop.number.one.model.Category;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;


@Repository
public class CategoryRepositoryImpl implements CategoryRepository {

    private final static String BD_FIND_ALL_CATEGORY = "SELECT*FROM CATEGORY";
    private final static String BD_FIND_BY_ID_CATEGORY = "SELECT * FROM CATEGORY WHERE ID=?";
    private final static String BD_INSERT_CATEGORY = "INSERT INTO CATEGORY (NAME) VALUES (?)";
    private final static String BD_DELETE_CATEGORY = "DELETE FROM CATEGORY WHERE ID=?";
    private final static String BD_UPDATE_CATEGORY = "UPDATE CATEGORY SET NAME = ? WHERE ID = ?";
    private final static String BD_UPDATE_CATEGORY_BY_NAME = "SELECT * FROM CATEGORY WHERE NAME=?";

    @Autowired
    private DataSource dataSource;

    @Override
    public String getCategoryName(String category) {
        Connection connection = null;
        Category categoryName = new Category();
        try {
            connection = dataSource.getConnection();
            connection.setAutoCommit(false);
            PreparedStatement preparedStatement = connection.prepareStatement(BD_UPDATE_CATEGORY_BY_NAME);
            preparedStatement.setString(1, category);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                //category.setId(resultSet.getLong("id"));
                categoryName.setName(resultSet.getString("name"));
            }

        } catch (SQLException ex) {
            System.out.println("SQLException. Executing rollback to savepoint..." + ex);
            ifRollback(connection);
        }
        return categoryName.getName();
    }

    @Override
    public Collection<Category> findAll() {
        Connection connection = null;
        List<Category> categories = new ArrayList<>();
        try {
            connection = dataSource.getConnection();
            connection.setAutoCommit(false);
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(BD_FIND_ALL_CATEGORY);
            while (resultSet.next()) {
                Category category = new Category();
                category.setId(resultSet.getLong("id"));
                category.setName(resultSet.getString("name"));
                categories.add(category);
                connection.commit();
            }
        } catch (SQLException ex) {
            System.out.println("SQLException. Executing rollback to savepoint..." + ex);
            ifRollback(connection);
        }
        return categories;
    }


    @Override
    public Category findById(Long id) {
        Connection connection = null;
        Category category = new Category();
        try {
            connection = dataSource.getConnection();
            connection.setAutoCommit(false);
            PreparedStatement preparedStatement = connection.prepareStatement(BD_FIND_BY_ID_CATEGORY);
            preparedStatement.setLong(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                category.setId(resultSet.getLong("id"));
                category.setName(resultSet.getString("name"));
            }
        } catch (SQLException ex) {
            System.out.println("SQLException. Executing rollback not category by id ..." + ex);
            ifRollback(connection);
        }
        return category;
    }

    @Override
    public Category save(Category category) {
        Connection connection = null;
        try {
            connection = dataSource.getConnection();
            connection.setAutoCommit(false);
            PreparedStatement preparedStatement = connection.prepareStatement(BD_INSERT_CATEGORY);
            preparedStatement.setString(1, category.getName());
            preparedStatement.executeUpdate();
            connection.commit();
        } catch (SQLException ex) {
            System.out.println("SQLException. Executing rollback to savepoint..." + ex);
            ifRollback(connection);
        }
        return category;
    }

    @Override
    public Category update(Category category) {
        return null;
    }

    @Override
    public void delete(Long id) {
        System.out.println("You don`t delete category");
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
}

