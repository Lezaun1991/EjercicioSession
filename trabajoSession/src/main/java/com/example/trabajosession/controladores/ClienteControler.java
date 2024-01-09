package com.example.trabajosession.controladores;

import com.example.trabajosession.entidades.Cliente;
import com.example.trabajosession.entidades.TipoNacionalidad;
import com.example.trabajosession.servicios.ClienteService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j

@RequiredArgsConstructor
@Controller
/*@RequestMapping({"/cliente","/"})*/
public class ClienteControler {

    private final ClienteService service;

    private final HttpSession session;

    @ModelAttribute("cliente")
    private Cliente usuarioSesion() {
        Cliente nuevoCliente = (Cliente) session.getAttribute("cliente");
        if (nuevoCliente == null) {
            nuevoCliente = new Cliente();
            // Almacena la instancia en la sesión
            session.setAttribute("cliente", nuevoCliente);

            return nuevoCliente;
        }

        return nuevoCliente;
    }


    @GetMapping({"/pagina1","/"})
    public String pagina1() {
        return "pagina1";
    }


    @PostMapping("/pagina1/submit")
    public String pagina1Submit(Cliente cliente) {
        if (cliente.getNacionalidad() != TipoNacionalidad.ESPAÑOLA &&
                cliente.getNacionalidad() != TipoNacionalidad.ALEMANA
                &&cliente.getNacionalidad() != TipoNacionalidad.FRANCESA
                && cliente.getNacionalidad() != TipoNacionalidad.ANDORRANA
        ) {
            // Tratar el caso de selección inválida, por ejemplo, redirigir o mostrar un mensaje de error.
            return "redirect:/pagina1"; // Otra página de error
        }



        session.setAttribute("cliente", cliente);
        return "redirect:/pagina2";
        // Actualiza los datos en la sesión

//        model.addAttribute("cliente", session.getAttribute("cliente"));


    }
    @GetMapping("/pagina2")
    public String pagina2() {
        return "pagina2";
    }
    @PostMapping("/pagina2/submit")
    public String pagina2Submit(@ModelAttribute("cliente") Cliente cliente) {
        session.setAttribute("cliente", cliente);
//        model.addAttribute("cliente", session.getAttribute("cliente"));
        return "redirect:/pagina3";
    }
    @GetMapping("/pagina3")
    public String pagina3() {
        return "pagina3";
    }

    @PostMapping("/pagina3/submit")
    public String pagina3Submit(Cliente cliente) {
        // Actualiza los datos en la sesión
        session.setAttribute("cliente", cliente);
//        model.addAttribute("cliente", session.getAttribute("cliente"));

        return "redirect:/final";
    }
    @GetMapping("/final")
    public String paginaFinal() {
        return "paginaFinal";
    }
    @GetMapping("/eliminar")
    public String eliminar(){
        session.invalidate();
        return "redirect:/pagina1";
    }
}