package com.codingShuttle.loveable.loveable.entity;

import com.codingShuttle.loveable.loveable.enums.ProjectRole;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.Instant;

@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "project_members")
public class ProjectMember {

    @EmbeddedId
    ProjectMemberId id;
    //This will behave as primary key (project_id,user_id)

    @ManyToOne
    @MapsId("projectId")
    Project project;
    //Create composite id
    //@Maps ID -- used when we want to get the value from the project
    //one project can have many member -- so we are using it in project member to uniquely link to the project table and that is based on projectID.
    //Reference the project that is defined by the id -- here project member id will refer to project id


    @ManyToOne
    @MapsId("userId")
    User user;
    //


    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    ProjectRole projectRole;

    Instant invitedAt;
    Instant acceptedAt;

}