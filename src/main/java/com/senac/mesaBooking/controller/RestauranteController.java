package com.senac.mesaBooking.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.senac.mesaBooking.model.Restaurante;
import com.senac.mesaBooking.service.RestauranteService;

@Controller
public class RestauranteController {
    @Autowired
    private RestauranteService restauranteService;

    @GetMapping("/cadastro")
    public String exibirFormularioCadastro(Model model) {
        model.addAttribute("restaurante", new Restaurante());
        return "cadastro";
    }

    @PostMapping("/cadastro")
    public String cadastrarRestaurante(@ModelAttribute Restaurante restaurante,
            @RequestParam("foto") MultipartFile foto,
            RedirectAttributes redirectAttributes) {
        try {
            restaurante.setImagem(foto.getBytes());
            restauranteService.salvarRestaurante(restaurante);
            redirectAttributes.addFlashAttribute("successMessage", "Restaurante cadastrado com sucesso!");
            return "redirect:/cadastro";
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("errorMessage", "Erro ao cadastrar o restaurante: " + e.getMessage());
            return "redirect:/cadastro";
        }
    }

    @GetMapping("/")
    public String paginaPrincipal(Model model) {
        List<Restaurante> restaurantes = restauranteService.buscarTodosRestaurantes();
        model.addAttribute("restaurantes", restaurantes);
        return "index";
    }


}
