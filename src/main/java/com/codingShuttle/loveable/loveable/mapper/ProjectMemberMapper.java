package com.codingShuttle.loveable.loveable.mapper;

import com.codingShuttle.loveable.loveable.dto.member.MemberResponse;
import com.codingShuttle.loveable.loveable.entity.ProjectMember;
import com.codingShuttle.loveable.loveable.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ProjectMemberMapper {

    @Mapping(target = "userId", source = "id")
    @Mapping(target = "projectRole", constant = "EDITOR")
    MemberResponse toProjectMemberResponseFromOwner(User owner);

    @Mapping(target = "userId", source = "user.id")
    @Mapping(target = "username", source = "user.username")
    @Mapping(target = "name", source = "user.name")
    MemberResponse toProjectMemberResponseFromMember(ProjectMember projectMember);
}
