package com.tonero.users.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public enum RolesEnum {
	ADMIN("ADMIN"),
	USER("USER");

	@Getter
	private final String name;
}
