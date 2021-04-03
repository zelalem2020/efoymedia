package com.abzgroup.efoymedia.dal.repositories;

import com.abzgroup.efoymedia.dal.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CategoryRepo extends JpaRepository<Category,Long> {
    Optional<Category> findFirstByName(String name);
}
