
package shop.number.one.repositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import shop.number.one.model.Category;
import shop.number.one.model.Item;

import javax.persistence.Embeddable;
import javax.persistence.Embedded;
import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Objects;

@Repository
public class ItemRepositoryImpl implements ItemRepository {

    private final static String BD_INSERT_ITEM = "INSERT INTO ITEM (NAME,PRICE, CATEGORY_ID) VALUES (?,?,?)";
    private final static String BD_FIND_BY_ID_CATEGORY = "SELECT * FROM ITEM WHERE ID=?";
    private final static String BD_INSERT_CATEGORY = "INSERT INTO CATEGORY (NAME) VALUES (?)";
    private final static String BD_FIND_ALL_ITEM = "SELECT*FROM ITEM";

    @Autowired
    private DataSource dataSource;
    @Autowired
    private CategoryRepository categoryRepository;


    @Override
    public List<Item> itemsByCategory(Category category) {
        return null;
    }

    @Override
    public void quantityItemByCategory(long id, int amount) {

    }

    @Override
    public long getCount(long id) {
        return 0;
    }

    @Override
    public Collection<Item> findAll() {

        Connection connection = null;
        List<Item> items = new ArrayList<>();
        try {
            connection = dataSource.getConnection();
            connection.setAutoCommit(false);
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(BD_FIND_ALL_ITEM);
            while (resultSet.next()) {
                Item item = new Item();
                item.setId(resultSet.getLong("id"));
                item.setName(resultSet.getString("name"));
                item.setPrice(resultSet.getInt("price"));
                item.setCategory(categoryRepository.findById(item.getId()));
                items.add(item);
                connection.commit();
            }
        } catch (SQLException ex) {
            System.out.println("SQLException. Executing rollback to savepoint..." + ex);
            ifRollback(connection);
        }
        return items;
    }

    @Override
    public Item findById(Long aLong) {
        return null;
    }

    @Override
    public Item save(Item item) {
        Connection connection = null;
        try {
            connection = dataSource.getConnection();
            connection.setAutoCommit(false);
            PreparedStatement preparedStatement = connection.prepareStatement(BD_INSERT_ITEM);
            preparedStatement.setString(1, item.getName());
            preparedStatement.setInt(2, item.getPrice());
            preparedStatement.setLong(3, item.getCategory().getId());
            preparedStatement.executeUpdate();
            connection.commit();
        } catch (SQLException ex) {
            System.out.println("SQLException. Executing rollback to savepoint..." + ex);
            ifRollback(connection);
        }
        return item;
    }

    @Override
    public Item update(Item object) {
        return null;
    }

    @Override
    public void delete(Long aLong) {

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

