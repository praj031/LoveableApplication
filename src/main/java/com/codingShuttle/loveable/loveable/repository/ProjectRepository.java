package com.codingShuttle.loveable.loveable.repository;

import com.codingShuttle.loveable.loveable.entity.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProjectRepository extends JpaRepository<Project,Long> {

    @Query("""
            SELECT p FROM Project p
            WHERE p.deletedAt IS NULL
            AND p.owner.id = :userId
            ORDER BY p.updatedAt DESC
            """
    )
    List<Project> findAllAccessibleByUser(@Param("userId") Long userId);
    // We are querying for all the project owned by this user, conditional is it should be deleted and we are ordering by updated date in descending order.


}
