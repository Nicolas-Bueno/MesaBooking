package com.senac.mesaBooking.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.senac.mesaBooking.domain.ClienteRepository;
import com.senac.mesaBooking.model.Cliente;

@Service
public class ClienteService {
    @Autowired
    ClienteRepository clienteRepository;

    public Cliente salvarCliente(Cliente cliente){
        return clienteRepository.save(cliente);
    }

    public List<Cliente> obterTodosClientes(){
        List<Cliente> clientes = clienteRepository.findAll();

        return clientes;
    }
}
