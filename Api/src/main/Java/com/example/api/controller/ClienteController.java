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
        clientes.add(new Cliente("Leonardo DIas", "11999999999", "leonardo@email.com"));
        clientes.add(new Cliente("Amara HOffmann", "11888888888", "amara@email.com"));
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
