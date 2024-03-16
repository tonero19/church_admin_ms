package com.tonero.church_detail.service;

import com.tonero.church_detail.dto.ChurchDetailDto;

public interface IChurchDetailService {

	/**
	 *
	 * @param churchDetailDto
	 */
	void createChurch(ChurchDetailDto churchDetailDto);

	ChurchDetailDto getChurch(long id);
}
