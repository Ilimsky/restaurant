package com.example.restaurant.services;

import com.example.restaurant.entities.Establishment;
import com.example.restaurant.repository.EstablishmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EstablishmentServiceImpl implements EstablishmentService{

    private final EstablishmentRepository establishmentRepository;

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
