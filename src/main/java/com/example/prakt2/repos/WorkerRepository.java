package com.example.prakt2.repos;

import com.example.prakt2.models.Worker;
import org.springframework.data.repository.CrudRepository;

public interface WorkerRepository extends CrudRepository<Worker, Long> {
    Worker findByName(String name);
}

