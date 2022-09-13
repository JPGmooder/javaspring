package com.example.prakt2.repos;

import com.example.prakt2.models.Doljnost;
import com.example.prakt2.models.Filial;
import org.springframework.data.repository.CrudRepository;

public interface DoljnostRepository extends CrudRepository<Doljnost, Long> {
    Doljnost findByName(String name);

}
