package com.senac.mesaBooking.service;

import org.apache.commons.codec.binary.Base64;
import java.util.List;

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

    public List<Restaurante> buscarTodosRestaurantes() {
        List<Restaurante> restaurantes = restauranteRepository.findAll();
        
        // Converter os dados da imagem em base64
        for (Restaurante restaurante : restaurantes) {
            byte[] imagemBytes = restaurante.getImagem();
            final String imagemBase64 = Base64.encodeBase64String(imagemBytes);
            restaurante.setImagemBase64(imagemBase64);
            restauranteRepository.save(restaurante);
        }
        
        return restaurantes;
    }

    public Restaurante obterRestaurantePorId(Long restauranteId) {
        return restauranteRepository.findById(restauranteId).orElse(null);
    }
    
}
