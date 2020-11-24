
package shop.number.one.repositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import shop.number.one.model.Category;
import shop.number.one.model.Item;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Collection;
import java.util.List;
import java.util.Objects;

@Repository
public class ItemRepositoryImpl implements ItemRepository {

    private final static String BD_INSERT_ITEM = "INSERT INTO ITEM (NAME,PRICE, CATEGORY_ID) VALUES (?,?,?)";
    @Autowired
    private DataSource dataSource;

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
        return null;
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

