package com.senac.mesaBooking.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.senac.mesaBooking.model.Reserva;

@Repository
public interface ReservaRepository extends JpaRepository<Reserva, Long>{
    
}
