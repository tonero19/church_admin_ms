package com.tonero.users.service.impl;

import com.tonero.users.dto.ChurchDetailDto;
import com.tonero.users.dto.ResponseDto;
import com.tonero.users.dto.RolesDto;
import com.tonero.users.dto.UserDto;
import com.tonero.users.entity.Role;
import com.tonero.users.entity.User;
import com.tonero.users.enums.RolesEnum;
import com.tonero.users.mapper.UserMapper;
import com.tonero.users.repository.RoleRepository;
import com.tonero.users.repository.UserRepository;
import com.tonero.users.service.IUserService;
import com.tonero.users.service.client.ChurchDetailsFeignClient;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Slf4j
@Service
public class UserServiceImpl implements IUserService {
	private final UserRepository userRepository;
	private final RoleRepository roleRepository;
	private final ChurchDetailsFeignClient churchDetailsFeignClient;

	@Override
	public void createUser(UserDto userDto) {
		log.info(userDto.toString());
		final User user = UserMapper.mapToUser(userDto, new User());
		user.setRoles(getUserRoles(userDto.getRoles()));
		if (user.getRoles().isEmpty()) {
			throw new RuntimeException("user has no roles");
		}
		userRepository.save(user);
	}

	@Override
	public void createRoles(RolesDto rolesDto) {
		final Set<Role> roles = rolesDto.getRoles().stream().map(r -> new Role().setRole(r)).collect(Collectors.toSet());
		roleRepository.saveAll(roles);
	}

	@Override
	public ResponseEntity<ChurchDetailDto> getChurch(Long userId) {
		Optional<User> optionalUser = userRepository.findById(userId);
		if (optionalUser.isPresent()) {
			String churchId = optionalUser.get().getChurchId();
			if (!churchId.isEmpty()) {
				return churchDetailsFeignClient.getChurch(Long.parseLong(churchId));
			}
		}
		return null;
	}

	private Set<Role> getUserRoles(Set<RolesEnum> rolesStrings) {
		final HashSet<Role> roles = new HashSet<>();
		for (RolesEnum role : rolesStrings) {
			if (role == RolesEnum.ADMIN) {
				roles.add(roleRepository.getAdminRole());
			}
			if (role == RolesEnum.USER) {
				roles.add(roleRepository.getUserRole());
			}
		}
		return roles;
	}


}
