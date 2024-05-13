package com.example.restaurant.services;

import com.example.restaurant.dtos.Pagination;
import com.example.restaurant.dtos.eatery.CreateEateryRequest;
import com.example.restaurant.dtos.eatery.EateryDTO;
import com.example.restaurant.dtos.eatery.EateryMapper;
import com.example.restaurant.dtos.eatery.UpdateEateryRequest;
import com.example.restaurant.entities.Eatery;
import com.example.restaurant.exceptions.EateryNotFoundException;
import com.example.restaurant.repository.EateryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class EateryServiceImpl implements EateryService {

    private final EateryMapper eateryMapper;

    private EateryRepository repository;

    @Autowired
    public EateryServiceImpl(EateryRepository repository, EateryMapper eateryMapper) {
        this.eateryMapper = eateryMapper;
        this.repository = repository;
    }

    @Transactional
    @Override
    public EateryDTO createEatery(CreateEateryRequest createEateryRequest) {
        Eatery eatery = Eatery.builder()
                .name(createEateryRequest.getName())
                .description(createEateryRequest.getDescription())
                .build();

        Eatery savedEatery = repository.save(eatery);
        return eateryMapper.eateryToeateryDTO(savedEatery);
    }

    public Pagination<EateryDTO> getAllEateries(int pageNo, int pageSize) {
        Pageable paging = PageRequest.of(pageNo, pageSize);
        Page<Eatery> products = repository.findAll(paging);

        return new Pagination<>(products.stream().map(eateryMapper::eateryToeateryDTO).collect(Collectors.toList()),
                products.getTotalElements());
    }

    public EateryDTO getEateryDtoById(Long id) {
        return eateryMapper.eateryToeateryDTO(repository.findById(id)
                .orElseThrow(() -> {
                    try {
                        throw new EateryNotFoundException("Eatery with id " + id + " could not be found!");
                    } catch (EateryNotFoundException e) {
                        throw new RuntimeException(e);
                    }
                }));
    }

    @Transactional
    public Long deleteEateryById(Long id) {
        repository.deleteById(id);
        return id;
    }

    public EateryDTO updateEatery(UpdateEateryRequest updateEateryRequest, Long id) {
        Eatery eatery = repository.findById(id)
                .orElseThrow(() -> {
                    try {
                        throw new EateryNotFoundException("Eatery with id " + id + " could not be found");
                    } catch (EateryNotFoundException e) {
                        throw new RuntimeException(e);
                    }
                });
        eatery.setName(updateEateryRequest.getName());
        eatery.setDescription(updateEateryRequest.getDescription());
        repository.save(eatery);
        return eateryMapper.eateryToeateryDTO(eatery);
    }


//    private List<Eatery> establishments;

    //    @PostConstruct
//    public void loadAppInDB() {
//        Faker faker = new Faker();
//        establishments = LongStream.range(1, 10)
//                .mapToObj(i -> Eatery.builder()
//                        .id(i)
//                        .name(faker.app().name())
//                        .description(faker.lorem().sentence())
//                        .build())
//                .toList();
//    }

//    public List<Eatery> allEateries() {
//        return establishments;
//    }

//    public Eatery establishmentByID(int id) {
//        return establishments.stream()
//                .filter(app -> app.getId() == id)
//                .findFirst()
//                .orElse(null);
//    }
}
