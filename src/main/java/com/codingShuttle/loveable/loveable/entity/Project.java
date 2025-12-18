package com.codingShuttle.loveable.loveable.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.Instant;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
@Table(name = "projects",
        indexes = {
                @Index(name = "idx_projects_updated_at_desc", columnList = "updated_at DESC,deleted_at"),
                @Index(name = "idx_projects_deleted_at",columnList = "deleted_at")
        }
)
//The use of index is to enhance the DB query, as in the above sample you can see that if we query with deleted_at/updated_at we can optimise the search result.
//It helps to enhance the Db query


public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(nullable = false)
    String name;

//    @ManyToOne
//    @JoinColumn(name= "owner_id", nullable = false)
//    User owner;
    //Many project to one user


    Boolean isPublic = false;

    @CreationTimestamp
    Instant createdAt;
    @UpdateTimestamp
    Instant updatedAt;


    Instant deletedAt; //soft delete
}
