package com.kolkov.post.controller;

import com.kolkov.post.entity.Status;
import com.kolkov.post.service.StatusService;
import lombok.Data;
import org.springframework.web.bind.annotation.*;
import java.util.Collection;

@Data
@RestController
@RequestMapping("/status")
public class StatusController {
    private final StatusService statusService;

    @PostMapping("/get/{id}")
    @ResponseBody
    public
    Collection<Status> getStatusByDispatchId(@PathVariable Long id) {
        return statusService.getStatusByDispatchId(id);
    }
}
