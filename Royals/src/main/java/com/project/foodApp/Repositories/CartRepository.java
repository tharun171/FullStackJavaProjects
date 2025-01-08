package com.project.foodApp.Repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.project.foodApp.Entities.UserEntityCart;


@Repository
public interface CartRepository extends CrudRepository<UserEntityCart,Integer>{

}
