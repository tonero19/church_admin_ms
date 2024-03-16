package com.tonero.users.mapper;

import com.tonero.users.dto.UserDto;
import com.tonero.users.entity.User;

public class UserMapper {

	public static User mapToUser(UserDto userDto, User user) {
		return user.setUserName(userDto.getUserName())
				.setPassword(userDto.getPassword())
				.setEmail(userDto.getEmail())
				.setChurchId(userDto.getChurchId());
	}
}
