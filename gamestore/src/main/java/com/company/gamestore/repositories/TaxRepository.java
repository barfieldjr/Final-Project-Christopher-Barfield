package com.company.gamestore.repositories;


import com.company.gamestore.model.Tax;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaxRepository  extends JpaRepository<Tax,Integer> {
}
