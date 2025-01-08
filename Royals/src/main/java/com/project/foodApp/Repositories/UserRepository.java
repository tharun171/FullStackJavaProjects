package com.project.foodApp.Repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.project.foodApp.Entities.UserEntity;


@Repository
public interface UserRepository extends CrudRepository<UserEntity,UserEntityId>{

	//because of having 2 ids we are getting idClass error
}
