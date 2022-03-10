package at.spring.example.service.impl;

import at.spring.example.dto.DogDto;
import at.spring.example.entity.Dog;
import at.spring.example.mapper.DogMapper;
import at.spring.example.persistence.DogDao;
import at.spring.example.service.DogService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DogServiceImpl implements DogService {
    private final DogDao dao;
    private final DogMapper mapper;

    public DogServiceImpl(DogDao dao, DogMapper mapper) {
        this.dao = dao;
        this.mapper = mapper;
    }

    @Override
    public List<DogDto> allDogs() {
        return dao.getAll().stream().map(mapper::entityToDto).toList();
    }

    public DogDto create(DogDto dto) {
//        Dog entity = mapper.dtoToEntity(dto);
//        entity = dao.create(entity);
//        return mapper.entityToDto(entity);
        return mapper.entityToDto(dao.create(mapper.dtoToEntity(dto)));
    }
}
