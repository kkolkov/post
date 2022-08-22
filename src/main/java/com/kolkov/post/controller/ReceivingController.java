package com.kolkov.post.controller;

import com.kolkov.post.dto.ReceivingDto;
import com.kolkov.post.service.ReceivingService;
import lombok.Data;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;

@Data
@RestController
@RequestMapping("/register")
public class ReceivingController {
    private final ReceivingService receivingService;

    @PostMapping("/receiving")
    void registerDispatchReceiving(@Valid @RequestBody ReceivingDto receivingDto) {
        receivingService.registerDispatchReceiving(receivingDto);
    }
}
