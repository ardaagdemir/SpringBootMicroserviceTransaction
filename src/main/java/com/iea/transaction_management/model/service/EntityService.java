package com.iea.transaction_management.model.service;

import java.util.List;

public interface EntityService<E, I>
{
    E findByID(I id);

    List<E> getAll();

    E save(E entity);

    void deleteByID(I id);
}
