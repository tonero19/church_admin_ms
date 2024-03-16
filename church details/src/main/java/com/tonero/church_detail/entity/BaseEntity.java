package com.tonero.church_detail.entity;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;

@MappedSuperclass
@Getter
@Setter
@ToString
public class BaseEntity {

	@Column(updatable = false)
	private LocalDate createdAt;

	@Column(updatable = false)
	private String createdBy;

	@Column(insertable = false)
	private LocalDate updatedAt;

	@Column(insertable = false)
	private String updatedBy;
}
