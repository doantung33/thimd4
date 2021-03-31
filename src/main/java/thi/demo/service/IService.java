package thi.demo.service;

import java.util.List;

public interface IService<T> {
    List<T> findAll();

    T findById(Long id);

    T save(T t);

    void remove(Long id);
}
