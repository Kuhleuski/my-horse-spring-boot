package com.it.academy.myhorsespringboot.service;

import com.it.academy.myhorsespringboot.model.Horse;

import java.util.List;

public interface HorseService {

    void createHorse(String type, int age, double price);

    List<Horse> findAllHorses();

    void updateHorse(Integer id,String type, int age, double price);

    void deleteHorse(Integer id);

    Horse findHorseById(Integer id);

}
