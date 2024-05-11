package com.example.restaurant.services;

import com.example.restaurant.entities.Establishment;
import com.example.restaurant.repository.EstablishmentRepository;
import com.github.javafaker.Faker;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.LongStream;

@Service
public class EstablishmentServiceImpl implements EstablishmentService {

    private final EstablishmentRepository establishmentRepository;
    private List<Establishment> establishments;

    @PostConstruct
    public void loadAppInDB() {
        Faker faker = new Faker();
        establishments = LongStream.range(1, 10)
                .mapToObj(i -> Establishment.builder()
                        .id(i)
                        .name(faker.app().name())
                        .description(faker.app().name())
                        .build())
                .toList();
    }

    public List<Establishment> allApplications() {
        return establishments;
    }

    public Establishment applicationByID(int id) {
        return establishments.stream()
                .filter(app -> app.getId() == id)
                .findFirst()
                .orElse(null);
    }

    @Autowired
    public EstablishmentServiceImpl(EstablishmentRepository establishmentRepository) {
        this.establishmentRepository = establishmentRepository;
    }

    @Override
    public Establishment saveEstablishment(Establishment establishment) {
        return establishmentRepository.save(establishment);
    }

    @Override
    public Page<Establishment> getAllEstablishments(Pageable pageable) {
        return establishmentRepository.findAll(pageable);
    }

    @Override
    public Optional<Establishment> getOneByEstablishmentId(Long establishmentId) {
        return establishmentRepository.findById(establishmentId);
    }

    @Override
    public void deleteById(Long establishmentId) {
        establishmentRepository.deleteById(establishmentId);
    }
}
