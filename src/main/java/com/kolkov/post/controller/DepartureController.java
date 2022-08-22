package com.kolkov.post.controller;

import com.kolkov.post.dto.DepartureDto;
import com.kolkov.post.service.DepartureService;
import lombok.Data;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;

@Data
@RestController
@RequestMapping("/register")
public class DepartureController {
    private final DepartureService departureService;

    @PostMapping("/departure")
    void registerDispatchArrival(@Valid @RequestBody DepartureDto departureDto) {
        departureService.registerDispatchDeparture(departureDto);
    }
}

