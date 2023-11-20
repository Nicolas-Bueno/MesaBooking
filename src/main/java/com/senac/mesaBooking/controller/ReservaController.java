package com.senac.mesaBooking.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.senac.mesaBooking.model.Cliente;
import com.senac.mesaBooking.model.Reserva;
import com.senac.mesaBooking.model.Restaurante;
import com.senac.mesaBooking.service.ClienteService;
import com.senac.mesaBooking.service.ReservaService;
import com.senac.mesaBooking.service.RestauranteService;



@Controller
public class ReservaController {
    @Autowired
    ReservaService reservaService;

    @Autowired
    ClienteService clienteService;

    @Autowired
    RestauranteService restauranteService;

    @GetMapping("/reserva/{restauranteId}/{clienteId}")
    public String formReserva(@PathVariable("restauranteId") Long restauranteId, @PathVariable("clienteId") Long clienteId, Model model) {
        model.addAttribute("reserva", new Reserva());
        model.addAttribute("restauranteId", restauranteId);
 
        model.addAttribute("clienteId", clienteId);

        return "reserva";
    }

    @PostMapping("/reserva")
    public String reservar(@RequestParam("clienteId")Long clienteId, @RequestParam("restauranteId") Long restauranteId, @ModelAttribute Reserva reserva, RedirectAttributes redirectAttributes) {
        try {
            Restaurante restaurante = restauranteService.obterRestaurantePorId(restauranteId);
            Cliente cliente = clienteService.obterClientePorId(clienteId);
            reserva.setCliente(cliente);
            reserva.setRestaurante(restaurante);
            reservaService.salvarReserva(reserva);
            redirectAttributes.addFlashAttribute("successMessage", "Reserva feita com sucesso!");
            return "redirect:/";
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("errorMessage", "Erro ao reservar o restaurante: " + e.getMessage());
            return "redirect:/cadastro";
        }
    }
    

}
