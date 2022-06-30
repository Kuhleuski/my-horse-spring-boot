package com.it.academy.myhorsespringboot.repository;

import com.it.academy.myhorsespringboot.model.Horse;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HorseRepository extends CrudRepository <Horse,Integer> {
}
