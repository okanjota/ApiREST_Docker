package com.example.api.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.*;

import com.example.api.model.Cliente;

@RestController
@RequestMapping("/api/clientes")
public class ClienteController {
    private List<Cliente> clientes = new ArrayList<>();
    private AtomicLong contadorId = new AtomicLong(1); // Gera ID automático

    public ClienteController() {
        clientes.add(new Cliente(contadorId.getAndIncrement(), "Leonardo Dias", "27 420956489", "leonardo@email.com"));
        clientes.add(new Cliente(contadorId.getAndIncrement(), "Amara Hoffmann", "11 428429842", "amara@email.com"));
        clientes.add(new Cliente(contadorId.getAndIncrement(), "Armando Ferrari", "27 669334200", "armando@gmail.com"));
        clientes.add(new Cliente(contadorId.getAndIncrement(), "Juscelino Kubitschek", "11 489842948", "juscelino@gmail.com"));
    }

    @GetMapping
    public List<Cliente> listar() {
        return clientes;
    }

    @PostMapping
    public Cliente criar(@RequestBody Cliente cliente) {
        cliente.setId(contadorId.getAndIncrement());
        clientes.add(cliente);
        return cliente;
    }
}
