package com.tonero.church_detail.mapper;

import com.tonero.church_detail.dto.AddressDto;
import com.tonero.church_detail.dto.ChurchDetailDto;
import com.tonero.church_detail.entity.Address;
import com.tonero.church_detail.entity.ChurchDetail;

public class ChurchDetailsMapper {

	public static ChurchDetailDto mapToChurchDetailDto(ChurchDetail churchDetail, ChurchDetailDto churchDetailDto) {
		churchDetailDto.setName(churchDetail.getName());
		churchDetailDto.setType(churchDetail.getType());
		Address churchAddress = churchDetail.getAddress();
		final AddressDto addressDto = new AddressDto()
				.setCity(churchAddress.getCity())
				.setStreet(churchAddress.getStreet())
				.setCountry(churchAddress.getCountry())
				.setNumber(churchAddress.getNumber())
				.setPostCode(churchAddress.getPostCode());
		churchDetailDto.setAddress(addressDto);
		return churchDetailDto;
	}

	public static ChurchDetail mapToChurchDetail(ChurchDetailDto churchDetailDto, ChurchDetail churchDetail) {
		churchDetail.setName(churchDetailDto.getName());
		churchDetail.setType(churchDetailDto.getType());
		AddressDto churchAddressDto = churchDetailDto.getAddress();
		final Address address = new Address();
				address.setCity(churchAddressDto.getCity());
				address.setStreet(churchAddressDto.getStreet());
				address.setCountry(churchAddressDto.getCountry());
				address.setNumber(churchAddressDto.getNumber());
				address.setPostCode(churchAddressDto.getPostCode());
		churchDetail.setAddress(address);
		return churchDetail;
	}

}
