package repositories;

import java.util.List;

public interface CRUDRepository<T, U> {
    List<T> listAll();

}
