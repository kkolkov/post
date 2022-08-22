package com.kolkov.post.service;

import com.kolkov.post.dto.DepartureDto;
import com.kolkov.post.model.RandomPostOfficeGenerator;
import com.kolkov.post.model.StatusType;
import com.kolkov.post.repository.StatusRepository;
import lombok.Data;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;

@Data
@Transactional
@Service
public class DepartureService {
    private final RandomPostOfficeGenerator randomPostOfficeGenerator;
    private final StatusRepository statusRepository;
    public void registerDispatchDeparture(DepartureDto departureDto) {
        statusRepository.registerDispatchStatus(
                departureDto.getDispatchId(),
                randomPostOfficeGenerator.getOfficeInfo().getId(),
                StatusType.убыло.toString());
    }
}
