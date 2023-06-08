package com.example.springbootecom.repository;

import com.example.springbootecom.model.AlbumEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.history.RevisionRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface AlbumRepository extends RevisionRepository<AlbumEntity, Integer,Integer>, JpaRepository<AlbumEntity,Integer> {

}
