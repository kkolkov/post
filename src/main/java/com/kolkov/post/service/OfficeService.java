package com.kolkov.post.service;

import com.kolkov.post.repository.OfficeRepository;
import lombok.Data;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;

@Data
@Transactional
@Service
public class OfficeService {
    private final OfficeRepository officeRepository;
}
