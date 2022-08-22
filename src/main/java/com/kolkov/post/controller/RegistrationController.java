package com.kolkov.post.controller;

import com.kolkov.post.dto.RegistrationDto;
import com.kolkov.post.model.DispatchSticker;
import com.kolkov.post.service.RegistrationService;
import lombok.Data;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;

@Data
@RestController
@RequestMapping("/register")
public class RegistrationController {
    private final RegistrationService registrationService;

    @PostMapping("/new")
    ResponseEntity<DispatchSticker> registerNewDispatch(@Valid @RequestBody RegistrationDto registrationDto) {
        return registrationService.registerNewDispatch(registrationDto);
    }
}
