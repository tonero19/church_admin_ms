package com.tonero.church_detail.dto;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
@JsonNaming(value = PropertyNamingStrategies.SnakeCaseStrategy.class)
public class AddressDto {

	private String street;

	private String number;

	private String postCode;

	private String city;

	private String state;

	private String country;
}
