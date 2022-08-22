package com.kolkov.post.service;

import com.kolkov.post.repository.CustomerRepository;
import lombok.Data;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;

@Data
@Transactional
@Service
public class CustomerService {
    private final CustomerRepository customerRepository;
}
