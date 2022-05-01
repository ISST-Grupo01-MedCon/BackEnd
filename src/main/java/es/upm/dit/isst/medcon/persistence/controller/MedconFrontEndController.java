package es.upm.dit.isst.medcon.persistence.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MedconFrontEndController {
    @RequestMapping(value = {
        /* PÁGINAS CONSULTA MÉDICO */
        "/medico/lista_siguientes_pacientes",
        "/medico/lista_pacientes_descartados",
        "/medico/lista_completa_pacientes",
        "/medico/detalles_paciente/{id}",
        "/medico/nueva_consulta_paciente/{id}",
        "/medico/recetas_paciente/{id}",
        "/medico/pruebas_paciente/{id}",
        "/home",
        "/contacto"
    })
    public String getPaginasAutenticadas(HttpServletRequest request) {
        return "/index.html";
    }

    @RequestMapping(value = {
        "/",
        /* PÁGINAS PACIENTE */
        "/paciente/login",
        "/paciente/login/dni",
        "/paciente/login/cipa",
        "/paciente/ticket/{id}",
        /* PÁGINAS SALA DE ESPERA */
        "/sala_de_espera",
        /* PÁGINAS CONSULTA MÉDICO */
        "/medico/login"
    })
    public String getPaginasSinAutenticar(HttpServletRequest request) {
        return "/index.html";
    }
}
