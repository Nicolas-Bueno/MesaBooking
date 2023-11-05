package com.senac.mesaBooking.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.senac.mesaBooking.domain.ReservaRepository;
import com.senac.mesaBooking.model.Reserva;

@Service
public class ReservaService {
    @Autowired
    ReservaRepository reservaRepository;

    public Reserva salvarReserva(Reserva reserva){
        return reservaRepository.save(reserva);
    }
}
