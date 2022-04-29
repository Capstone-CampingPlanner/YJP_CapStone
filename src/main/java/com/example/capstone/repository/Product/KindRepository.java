package com.example.capstone.repository.Product;

import com.example.capstone.domain.Product.Kind;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KindRepository extends JpaRepository<Kind, Integer> {
    //
}
