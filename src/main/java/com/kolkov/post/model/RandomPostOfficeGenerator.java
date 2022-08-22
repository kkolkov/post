package com.kolkov.post.model;

import com.kolkov.post.entity.Office;
import com.kolkov.post.repository.OfficeRepository;
import lombok.*;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;

@Service
@Getter
@Setter
@Transactional
@RequiredArgsConstructor
public class RandomPostOfficeGenerator {
    private final OfficeRepository officeRepository;
    private long leftLimit = 137L;
    private long rightLimit = 151L;

    public Office getOfficeInfo() {
        long generatedLong = leftLimit + (long) (Math.random() * (rightLimit - leftLimit));

        return officeRepository.getReferenceById(generatedLong);
    }
}
