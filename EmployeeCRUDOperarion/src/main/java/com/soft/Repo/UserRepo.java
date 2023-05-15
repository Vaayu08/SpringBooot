package com.soft.Repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.soft.Entity.User;

public interface UserRepo extends JpaRepository<User, Integer> {

}
