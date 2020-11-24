
package shop.number.one.repositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import shop.number.one.model.OrdersItem;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Collection;
import java.util.Objects;

@Repository
public class OrdersItemRepositoryImpl implements OrdersItemRepository {
    private final static String BD_INSERT_ORDER_ITEM = "INSERT INTO ORDERS_ITEM (COUNT, ITEM_ID, ORDER_ID) VALUES (?,?,?)";
    @Autowired
    private DataSource dataSource;


    @Override
    public Collection<OrdersItem> findAll() {
        return null;
    }

    @Override
    public OrdersItem findById(Long aLong) {
        return null;
    }

    @Override
    public OrdersItem save(OrdersItem ordersItem) {
        Connection connection = null;
        try {
            connection = dataSource.getConnection();
            connection.setAutoCommit(false);
            PreparedStatement preparedStatement = connection.prepareStatement(BD_INSERT_ORDER_ITEM);
            preparedStatement.setInt(1, ordersItem.getCount());
            preparedStatement.setLong(2, ordersItem.getItem().getId());
            preparedStatement.setLong(3, ordersItem.getOrder().getId());
            preparedStatement.executeUpdate();
            connection.commit();
        } catch (SQLException ex) {
            System.out.println("SQLException. Executing rollback to savepoint..." + ex);
            ifRollback(connection);
        }
        return ordersItem;
    }

    @Override
    public OrdersItem update(OrdersItem object) {
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

