package com.geektrust.backend.Repository;

import java.time.LocalDate;
import java.util.List;

public interface CRUD_Repository<T,ID> {
    public void save(T entity);
    public T findById(ID id);
    public List<LocalDate> findAll();
    public void delete(T entity);
    public void deleteById(ID id);
    public int count();
    public void setSubscriptionPrice(int userId, String category, String planType);
}
