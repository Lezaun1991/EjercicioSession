package com.example.trabajosession.servicios;

import com.example.trabajosession.entidades.Cliente;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

@Service
public class ClienteService {
    @Autowired
    private HttpSession session;
    public void añadirSesion() {
        // El objeto Cliente se agregará a la sesión si la sesión ya existe.
        Cliente clienteNuevo = new Cliente();
        session.setAttribute("cliente", clienteNuevo);
    }
}
