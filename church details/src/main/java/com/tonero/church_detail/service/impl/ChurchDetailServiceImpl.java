package com.tonero.church_detail.service.impl;

import com.tonero.church_detail.dto.ChurchDetailDto;
import com.tonero.church_detail.entity.ChurchDetail;
import com.tonero.church_detail.mapper.ChurchDetailsMapper;
import com.tonero.church_detail.repository.ChurchDetailRepository;
import com.tonero.church_detail.service.IChurchDetailService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ChurchDetailServiceImpl implements IChurchDetailService {

	private final ChurchDetailRepository churchDetailRepository;

	@Override
	public void createChurch(ChurchDetailDto churchDetailDto) {
		ChurchDetail churchDetail = ChurchDetailsMapper.mapToChurchDetail(churchDetailDto, new ChurchDetail());
		churchDetail.setCreatedAt(LocalDate.now());
		churchDetailRepository.save(churchDetail);
	}

//	@Override
//	public ChurchDetailDto getChurch() {
//		final ChurchDetail churchDetail = churchDetailRepository.findAll().stream().findAny().orElseThrow();
//		return ChurchDetailsMapper.mapToChurchDetailDto(churchDetail, new ChurchDetailDto());
//	}

	@Override
	public ChurchDetailDto getChurch(long id) {
		Optional<ChurchDetail> optionalChurchDetail = churchDetailRepository.findById(id);
		ChurchDetailDto churchDetailDto = new ChurchDetailDto();
        return optionalChurchDetail.map(churchDetail -> ChurchDetailsMapper.mapToChurchDetailDto(churchDetail, churchDetailDto)).orElse(churchDetailDto);
	}
}
