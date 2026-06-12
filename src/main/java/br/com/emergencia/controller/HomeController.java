package br.com.emergencia.controller;

import br.com.emergencia.service.ChamadoService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    private final ChamadoService chamadoService;

    public HomeController(ChamadoService chamadoService) {
        this.chamadoService = chamadoService;
    }

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("ultimosChamados", chamadoService.listarChamados().stream().limit(2).toList());
        return "index";
    }

    @GetMapping("/emergencia")
    public String emergencia(Model model) {
        model.addAttribute("tiposEmergencia", chamadoService.listarTipos());
        return "emergencia";
    }

    @GetMapping("/localizacao")
    public String localizacao() {
        return "localizacao";
    }

    @GetMapping("/historico")
    public String historico(Model model) {
        model.addAttribute("chamados", chamadoService.listarChamados());
        return "historico";
    }

    @GetMapping("/telefones")
    public String telefones() {
        return "telefones";
    }
}
