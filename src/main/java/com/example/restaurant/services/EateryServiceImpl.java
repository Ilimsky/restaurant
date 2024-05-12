package com.example.restaurant.services;

import com.example.restaurant.dtos.eatery.CreateEateryRequest;
import com.example.restaurant.dtos.eatery.EateryDTO;
import com.example.restaurant.dtos.eatery.EateryMapper;
import com.example.restaurant.entities.Eatery;
import com.example.restaurant.repository.EateryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
