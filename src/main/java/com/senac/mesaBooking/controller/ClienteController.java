package com.senac.mesaBooking.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.senac.mesaBooking.model.Cliente;
import com.senac.mesaBooking.service.ClienteService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class ClienteController {
   @Autowired
   ClienteService clienteService;
   
   @GetMapping("/cliente-form")
   public String exibirFormularioCadastro(Model model){
    model.addAttribute("cliente", new Cliente());
    return "cliente-form";
   }

   @PostMapping("/cliente-form")
   public String cadastrarClienre(@ModelAttribute Cliente cliente, RedirectAttributes redirectAttributes) {
        try {
            clienteService.salvarCliente(cliente);
            redirectAttributes.addFlashAttribute("successMessage", "Cliente cadastrado com sucesso!");
            return "redirect:/cliente-form";
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("errorMessage", "Erro ao cadastrar o Cliente: " + e.getMessage());
            return "redirect:/cliente-form";
        }   
   }
   
}
