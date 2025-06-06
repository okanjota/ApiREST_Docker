package com.example.api.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.api.model.Cliente;

@RestController
@RequestMapping("/api/clientes")
public class ClienteController {
    private List<Cliente> clientes = new ArrayList<>();

    public ClienteController() {
        clientes.add(new Cliente("Leonardo Dias", "27 420956489", "leonardo@email.com"));
        clientes.add(new Cliente("Amara HOffmann", "11 428429842", "amara@email.com"));
        clientes.add(new Cliente("Armando Ferrari", "27 669334200", "armando@gmail.com"));
        clientes.add(new Cliente("Juscelino Kubtschek", "11 489842948", "Juscelino@gmail.com"));
    }

    @GetMapping
    public List<Cliente> listar() {
        return clientes;
    }

    @PostMapping
    public Cliente criar(@RequestBody Cliente cliente) {
        clientes.add(cliente);
        return cliente;
    }
}
