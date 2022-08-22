package com.kolkov.post.service;

import com.kolkov.post.dto.ArrivalDto;
import com.kolkov.post.model.RandomPostOfficeGenerator;
import com.kolkov.post.model.StatusType;
import com.kolkov.post.repository.StatusRepository;
import lombok.Data;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;

@Data
@Transactional
@Service
public class ArrivalService {
    private final RandomPostOfficeGenerator randomPostOfficeGenerator;
    private final StatusRepository statusRepository;

    public void registerDispatchArrival(ArrivalDto arrivalDto) {
        statusRepository.registerDispatchStatus(
                arrivalDto.getDispatchId(),
                randomPostOfficeGenerator.getOfficeInfo().getId(),
                StatusType.прибыло.toString());
    }
}
