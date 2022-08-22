package com.kolkov.post.service;

import com.kolkov.post.repository.DirectionRepository;
import lombok.Data;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;

@Data
@Transactional
@Service
public class DirectionService {
    private final DirectionRepository directionRepository;
}
