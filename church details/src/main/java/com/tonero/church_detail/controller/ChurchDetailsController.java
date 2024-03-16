package com.tonero.church_detail.controller;

import com.tonero.church_detail.dto.ChurchDetailDto;
import com.tonero.church_detail.dto.ResponseDto;
import com.tonero.church_detail.service.IChurchDetailService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping(path = "/api/church", produces = {MediaType.APPLICATION_JSON_VALUE})
public class ChurchDetailsController {

	private final IChurchDetailService churchDetailService;

	@PostMapping("/create")
	public ResponseEntity<ResponseDto> createChurch(@RequestBody ChurchDetailDto churchDetailDto) {
		churchDetailService.createChurch(churchDetailDto);
		return ResponseEntity
				.status(HttpStatus.CREATED)
				.body(new ResponseDto("201", "Church created successfully"));
	}

//	@GetMapping
//	public ResponseEntity<ChurchDetailDto> getChurches() {
//		final ChurchDetailDto church = churchDetailService.getChurch();
//		log.info(church.toString());
//		return ResponseEntity
//				.status(HttpStatus.OK)
//				.contentType(MediaType.APPLICATION_JSON)
//				.body(church);
//	}

	@GetMapping
	public ResponseEntity<ChurchDetailDto> getChurch(@RequestParam(name = "id") long id) {
		final ChurchDetailDto church = churchDetailService.getChurch(id);
		log.info(church.toString());
		return ResponseEntity
				.status(HttpStatus.OK)
				.contentType(MediaType.APPLICATION_JSON)
				.body(church);
	}

}
