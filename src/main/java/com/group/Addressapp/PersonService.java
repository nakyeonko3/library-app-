package com.group.Addressapp;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Primary
@Service
public class PersonService {
    private final PersonRepository personRepository;
    private final AddressRepository addressRepository;

    public PersonService(PersonRepository personRepository, AddressRepository addressRepository) {
        this.personRepository = personRepository;
        this.addressRepository = addressRepository;
    }

    @Transactional
    public void savePerson(){
        Person person = personRepository.save(new Person());
        Address address = addressRepository.save(new Address());
//        address.setAddress(person);
        person.setAddress(address);
        System.out.println("person name:"+address.getPerson().getName());
        System.out.println("citry:"+person.getAddress().getCity());
    }
}
