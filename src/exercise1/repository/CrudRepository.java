package exercise1.repository;

import java.util.List;

public interface CrudRepository<T> {

    List<T> finAll();

    T findById(int id);

    void saveToDatabase(T object);
    void deleteFromDatabase(T object);
    void updateOnDatabase(T object);


}
