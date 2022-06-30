package com.it.academy.myhorsespringboot.service;

import com.it.academy.myhorsespringboot.model.Horse;
import com.it.academy.myhorsespringboot.repository.HorseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class HorseServiceImpl implements HorseService {

    private final HorseRepository horseRepository;

    @Override
    public void createHorse(String type, int age, double price) {

        Horse horse = Horse.builder()
                .type(type)
                .age(age)
                .price(price)
                .build();
        horseRepository.save(horse);
    }

    @Override
    public List<Horse> findAllHorses() {
        return (List<Horse>) horseRepository.findAll();
    }

    @Override
    public void updateHorse(Integer id, String type, int age, double price) {
        Horse horse = horseRepository.findById(id).orElseThrow();
        horse.setType(type);
        horse.setAge(age);
        horse.setPrice(price);
        horseRepository.save(horse);
    }

    @Override
    public void deleteHorse(Integer id) {
        horseRepository.deleteById(id);
    }

    @Override
    public Horse findHorseById(Integer id) {
        return horseRepository.findById(id).orElseThrow();
    }
}
