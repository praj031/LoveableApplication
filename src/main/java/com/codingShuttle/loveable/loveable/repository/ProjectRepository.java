package com.codingShuttle.loveable.loveable.repository;

import com.codingShuttle.loveable.loveable.entity.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

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

    @Query("""
            SELECT p FROM Project p 
            LEFT JOIN FETCH p.owner 
            WHERE p.id = :projectId 
            AND p.deletedAt IS NULL 
            AND p.owner.id = :userId
            """)
    Optional<Project> findAccessibleByUser(@Param("projectId") Long projectId,
                                           @Param("userId") Long userId);
    //This query will give fields from project as well as the owner of that particular project ID as well, which was never deleted and owner is the userID entered

    @Query("""
            SELECT p FROM Project p
            LEFT JOIN FETCH p.owner
            WHERE p.id = :projectId
                AND p.deletedAt IS NULL
                AND p.owner.id = :userId
            """)
    Optional<Project> findAccessibleProjectById(@Param("projectId") Long projectId,
                                                @Param("userId") Long userId);





}
