package com.codingShuttle.loveable.loveable.repository;

import com.codingShuttle.loveable.loveable.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {


}
