package com.example.springbootecom.repository;

import com.example.springbootecom.model.AlbumEntity;
import org.springframework.data.repository.CrudRepository;


public interface AlbumRepository extends CrudRepository<AlbumEntity, Integer> {

}
