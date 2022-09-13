package com.example.prakt2.repos;

import com.example.prakt2.models.Filial;
import org.springframework.data.repository.CrudRepository;

public interface FilialRepository extends CrudRepository<Filial, Long> {
    Filial findByName(String name);
}