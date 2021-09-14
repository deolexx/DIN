package com.deo.din.repository;

import com.deo.din.entity.Task;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface TaskRepository extends CrudRepository<Task, UUID> {
}
