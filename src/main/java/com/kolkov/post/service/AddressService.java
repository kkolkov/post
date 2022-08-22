package com.kolkov.post.service;

import com.kolkov.post.repository.AddressRepository;
import lombok.Data;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;

@Data
@Transactional
@Service
public class AddressService {
    private final AddressRepository addressRepository;
}
