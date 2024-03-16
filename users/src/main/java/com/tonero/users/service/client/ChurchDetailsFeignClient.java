package com.tonero.users.service.client;

import com.tonero.users.dto.ChurchDetailDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient("church-details")
public interface ChurchDetailsFeignClient {

    @GetMapping("/api/church")
    public ResponseEntity<ChurchDetailDto> getChurch(@RequestParam(name = "id") long id);
}
