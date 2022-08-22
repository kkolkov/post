package com.kolkov.post.service;

import com.kolkov.post.entity.Status;
import com.kolkov.post.repository.StatusRepository;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.Collection;

@Service
@Getter
@Setter
@Transactional
@RequiredArgsConstructor
public class StatusService {
    private final StatusRepository statusRepository;

    public Collection<Status> getStatusByDispatchId(Long id) {
        return statusRepository.getStatusByDispatchId(id);
    }
}
