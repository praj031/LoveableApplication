package com.codingShuttle.loveable.loveable.mapper;

import com.codingShuttle.loveable.loveable.dto.auth.SignupRequest;
import com.codingShuttle.loveable.loveable.dto.auth.UserProfileResponse;
import org.mapstruct.Mapper;
import com.codingShuttle.loveable.loveable.entity.User;

import java.nio.file.attribute.UserPrincipal;

@Mapper(componentModel = "spring")
public interface UserMapper {

     User toEntity(SignupRequest signupRequest);

     UserProfileResponse toUserProfileResponse(User user);

}
