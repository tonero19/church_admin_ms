package com.tonero.church_detail.entity;

import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;

@Embeddable
@Getter
@Setter
public class Address {

	private String street;

	private String number;

	private String postCode;

	private String city;

	private String state;

	private String country;
}
