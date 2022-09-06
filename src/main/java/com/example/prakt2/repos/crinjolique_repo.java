package com.example.prakt2.repos;

import com.example.prakt2.models.crinjolique;
import com.example.prakt2.models.flexik;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface crinjolique_repo extends CrudRepository<crinjolique, Long> {
    List<crinjolique> findByEsheodnoPoleContains(String title);


}

