package com.kolkov.post.controller;

import com.kolkov.post.dto.ArrivalDto;
import com.kolkov.post.service.ArrivalService;
import lombok.Data;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;

@Data
@RestController
@RequestMapping("/register")
public class ArrivalController {
    private final ArrivalService arrivalService;

    @PostMapping("/arrival")
    void registerDispatchArrival(@Valid @RequestBody ArrivalDto arrivalDto) {
        arrivalService.registerDispatchArrival(arrivalDto);
    }
}
