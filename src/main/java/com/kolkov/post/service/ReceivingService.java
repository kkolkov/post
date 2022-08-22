package com.kolkov.post.service;

import com.kolkov.post.dto.ReceivingDto;
import com.kolkov.post.model.RandomPostOfficeGenerator;
import com.kolkov.post.model.StatusType;
import com.kolkov.post.repository.StatusRepository;
import lombok.Data;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;

@Data
@Transactional
@Service
public class ReceivingService {
    private final
    RandomPostOfficeGenerator randomPostOfficeGenerator;
    private final StatusRepository statusRepository;
    public void registerDispatchReceiving(ReceivingDto receivingDto) {
        statusRepository.registerDispatchStatus(
                receivingDto.getDispatchId(),
                randomPostOfficeGenerator.getOfficeInfo().getId(),
                StatusType.получено.toString());
    }
}
