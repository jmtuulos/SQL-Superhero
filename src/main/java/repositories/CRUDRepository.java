package repositories;

import java.util.List;

public interface CRUDRepository<T, U> {
    List<T> listAll();
    T getById(U id);
    T create(T t);
    T update(T t);
    void delete(U id);

}
