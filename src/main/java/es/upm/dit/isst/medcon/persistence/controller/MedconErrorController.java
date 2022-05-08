package es.upm.dit.isst.medcon.persistence.controller;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MedconErrorController implements ErrorController  {

    @RequestMapping("/error")
    public String handleError() {
        // Se redirige a React
        return "/index.html";
    }
}
