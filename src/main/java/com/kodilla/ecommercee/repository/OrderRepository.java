package com.kodilla.ecommercee.repository;

import com.kodilla.ecommercee.GenericEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends CrudRepository<GenericEntity, Long> {

    @Override
    List<GenericEntity> findAll();

    @Override
    GenericEntity save(GenericEntity order);
}
