package com.example.prakt2.repos;

import com.example.prakt2.models.flexik;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface flexik_repo extends CrudRepository<flexik, Long> {

    List<flexik> findByFlexTitle(String title);
}

