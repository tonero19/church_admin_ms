package com.tonero.users.dto;

import lombok.Data;

@Data
public class ChurchDetailDto {

	private Long id;

	private String name;

	private String type;

	private AddressDto address;
}
