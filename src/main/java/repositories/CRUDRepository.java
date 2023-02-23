package repositories;

import java.sql.SQLException;
import java.util.List;

public interface CRUDRepository<T, U> {
    List<T> listAll() throws SQLException;
    T getById(U id);
    T getByName(String name);
    boolean create(T t);
    boolean update(T t);

}
