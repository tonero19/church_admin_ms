package com.tonero.users.service;

import com.tonero.users.dto.ChurchDetailDto;
import com.tonero.users.dto.RolesDto;
import com.tonero.users.dto.UserDto;
import org.springframework.http.ResponseEntity;

public interface IUserService {

	void createUser(UserDto userDto);

	void createRoles(RolesDto rolesDto);

	ResponseEntity<ChurchDetailDto> getChurch(Long userId);
}
