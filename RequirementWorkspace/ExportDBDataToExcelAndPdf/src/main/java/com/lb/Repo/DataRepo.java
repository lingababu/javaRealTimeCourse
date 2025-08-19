package com.lb.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lb.Entity.UsersData;

@Repository
public interface DataRepo extends JpaRepository<UsersData, Long> {

}
