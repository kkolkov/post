package com.kolkov.post.service;

import com.kolkov.post.entity.*;
import com.kolkov.post.dto.RegistrationDto;
import com.kolkov.post.model.DispatchSticker;
import com.kolkov.post.model.StatusType;
import com.kolkov.post.repository.*;
import com.kolkov.post.model.RandomPostOfficeGenerator;
import lombok.Data;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;

@Data
@Transactional
@Service
public class RegistrationService {
    private final AddressRepository addressRepository;
    private final CustomerRepository customerRepository;
    private final DirectionRepository directionRepository;
    private final DispatchRepository dispatchRepository;
    private final OfficeRepository officeRepository;
    private final StatusRepository statusRepository;
    private final RandomPostOfficeGenerator randomPostOfficeGenerator;

    public
    ResponseEntity<DispatchSticker> registerNewDispatch(RegistrationDto registrationDto) {
        Direction direction = new Direction();
        Customer customer = new Customer();
        Dispatch dispatch = new Dispatch();
        Address address = new Address();
        Office office = new Office();
        Status status = new Status();

        DispatchSticker dispatchSticker = new DispatchSticker();

        direction.setIndex(registrationDto.getCustomerIndex());
        direction.setAddress(registrationDto.getCustomerAddress());

        customer.setName(registrationDto.getCustomerName());
        customer.setDirection(direction);

        dispatch.setType(registrationDto.getDispatchType());
        dispatch.setCustomer(customer);

        address.setIndex(randomPostOfficeGenerator.getOfficeInfo().getAddress().getIndex());
        address.setAddress(randomPostOfficeGenerator.getOfficeInfo().getAddress().getAddress());

        office.setName(randomPostOfficeGenerator.getOfficeInfo().getName());
        office.setAddress(address);

        status.setDispatch(dispatch);
        status.setOffice(office);

        status.setStatus(StatusType.зарегистрировано);

        directionRepository.save(direction);
        customerRepository.save(customer);
        dispatchRepository.save(dispatch);
        addressRepository.save(address);
        officeRepository.save(office);
        statusRepository.save(status);

        dispatchSticker.setDispatchId(dispatch.getId());
        dispatchSticker.setCustomerName(customer.getName());
        dispatchSticker.setCustomerIndex(direction.getIndex());
        dispatchSticker.setCustomerAddress(direction.getAddress());

        return ResponseEntity.ok(dispatchSticker);
    }
}
