package com.revature.repos;

import java.util.List;

public interface GeneralDAO <T>{

    T create(T obj);

    List<T> getAll();

    T getById(int id);

    T update(T obj);

    boolean deleteById(int id);
}
