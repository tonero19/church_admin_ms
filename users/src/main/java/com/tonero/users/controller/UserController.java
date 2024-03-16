package com.tonero.users.controller;

import com.tonero.users.dto.ChurchDetailDto;
import com.tonero.users.dto.ResponseDto;
import com.tonero.users.dto.RolesDto;
import com.tonero.users.dto.UserDto;
import com.tonero.users.service.IUserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@Slf4j
@RequestMapping(path = "/api/users", produces = {MediaType.APPLICATION_JSON_VALUE})
public class UserController {

	private final IUserService userService;

	@PostMapping("/create")
	public ResponseEntity<ResponseDto> createUser(@RequestBody UserDto userDto) {
		userService.createUser(userDto);
		return ResponseEntity
				.status(HttpStatus.CREATED)
				.body(new ResponseDto("201", "User created successfully"));
	}

	@PostMapping("/roles/create")
	public ResponseEntity<ResponseDto> createRoles(@RequestBody RolesDto rolesDto) {
		userService.createRoles(rolesDto);
		return ResponseEntity
				.status(HttpStatus.CREATED)
				.body(new ResponseDto("201", "Roles created successfully"));
	}

		@GetMapping("/{user-id}/church")
		public ResponseEntity<ChurchDetailDto> getChurch(@PathVariable(name="user-id") Long userId) {
			return userService.getChurch(userId);
		}
}
