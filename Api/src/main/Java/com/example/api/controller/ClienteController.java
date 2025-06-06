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
    public ClienteController() {
    clientes.add(new Cliente(4382L, "Leonardo Dias", "27 420956489", "leonardo@email.com"));
    clientes.add(new Cliente(7251L, "Amara Hoffmann", "11 428429842", "amara@email.com"));
    clientes.add(new Cliente(3197L, "Armando Ferrari", "27 669334200", "armando@gmail.com"));
    clientes.add(new Cliente(8924L, "Juscelino Kubitschek", "11 489842948", "juscelino@gmail.com"));
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
