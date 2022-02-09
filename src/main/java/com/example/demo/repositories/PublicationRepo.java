package com.example.demo.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.pojo.User;

@Repository
public interface PublicationRepo extends CrudRepository<User, Integer> {

}
