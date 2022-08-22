package com.kolkov.post.service;


import com.kolkov.post.repository.DispatchRepository;
import lombok.Data;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;

@Data
@Transactional
@Service
public class DispatchService {
    private final DispatchRepository dispatchRepository;
}