package com.senac.mesaBooking.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.senac.mesaBooking.domain.RestauranteRepository;
import com.senac.mesaBooking.model.Restaurante;

@Service
public class RestauranteService {
    @Autowired
    private RestauranteRepository restauranteRepository;

    public Restaurante salvarRestaurante(Restaurante restaurante){
        return restauranteRepository.save(restaurante);
    }
}
