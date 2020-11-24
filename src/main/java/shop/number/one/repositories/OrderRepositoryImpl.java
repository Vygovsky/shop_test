
package shop.number.one.repositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import shop.number.one.model.Order;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Collection;
import java.util.Date;
import java.util.Objects;
import java.util.UUID;

@Repository
public class OrderRepositoryImpl implements OrderRepository {

    private final static String BD_INSERT_ORDER = "INSERT INTO ORDERS (USER_ID) VALUES (?);";

    @Autowired
    UserRepository userRepository;
    @Autowired
    private DataSource dataSource;

    @Override
    public Collection<Order> findAll() {
        return null;
    }

    @Override
    public Order findById(Long aLong) {
        return null;
    }

    @Override
    public Order save(Order order) {


        Connection connection = null;
        try {
            connection = dataSource.getConnection();
            connection.setAutoCommit(false);
            PreparedStatement preparedStatement = connection.prepareStatement(BD_INSERT_ORDER);
            preparedStatement.setLong(1, order.getUser().getId());
            preparedStatement.executeUpdate();
            connection.commit();
        } catch (SQLException ex) {
            System.out.println("SQLException. Executing rollback to savepoint..." + ex);
            ifRollback(connection);
        }
        return order;
    }


    @Override
    public Order update(Order object) {
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

