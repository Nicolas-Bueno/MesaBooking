package com.senac.mesaBooking.domain;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.senac.mesaBooking.model.Restaurante;

@Repository
public interface RestauranteRepository extends JpaRepository<Restaurante, Long>{
   @Query("SELECT r FROM Restaurante r WHERE r.nome LIKE %:nome%")
    List<Restaurante> findByNomeContaining(@Param("nome") String nome);
 
}
