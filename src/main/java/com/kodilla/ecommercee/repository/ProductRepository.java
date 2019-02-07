package com.kodilla.ecommercee.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends CrudRepository<GroupRepository, Long> {
}
