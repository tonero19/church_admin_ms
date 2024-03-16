package com.tonero.users.dto;

import com.tonero.users.enums.RolesEnum;
import lombok.Data;

import java.util.Set;

@Data
public class RolesDto {

	Set<RolesEnum> roles;
}
