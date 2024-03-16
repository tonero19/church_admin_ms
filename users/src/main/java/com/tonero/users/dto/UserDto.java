package com.tonero.users.dto;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.tonero.users.enums.RolesEnum;
import lombok.Data;

import java.util.HashSet;
import java.util.Set;

@Data
@JsonNaming(value = PropertyNamingStrategies.SnakeCaseStrategy.class)
public class UserDto {

	private Long id;

	private String churchId;

	private String userName;

	private String email;

	private String password;

	private Set<RolesEnum> roles = new HashSet<>();
}
