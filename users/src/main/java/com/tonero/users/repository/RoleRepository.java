package com.tonero.users.repository;

import com.tonero.users.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface RoleRepository extends JpaRepository<Role, Long> {

	@Query("select r from Role r where r.role = com.tonero.users.enums.RolesEnum.ADMIN")
	Role getAdminRole();

	@Query("select r from Role r where r.role = com.tonero.users.enums.RolesEnum.USER")
	Role getUserRole();
}
