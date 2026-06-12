package br.com.emergencia.controller;

import br.com.emergencia.model.Chamado;
import br.com.emergencia.service.ChamadoService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/chamados")
public class ChamadoController {

    private final ChamadoService chamadoService;

    public ChamadoController(ChamadoService chamadoService) {
        this.chamadoService = chamadoService;
    }

    @GetMapping
    public String listar(Model model) {
        model.addAttribute("chamados", chamadoService.listarChamados());
        return "historico";
    }

    @PostMapping
    public String abrir(@ModelAttribute Chamado chamado, RedirectAttributes redirectAttributes) {
        try {
            Chamado chamadoAberto = chamadoService.abrirChamado(chamado);
            redirectAttributes.addFlashAttribute("mensagem",
                    "Chamado #" + chamadoAberto.getId() + " aberto com sucesso.");
            return "redirect:/historico";
        } catch (IllegalArgumentException erro) {
            redirectAttributes.addFlashAttribute("erro", erro.getMessage());
            return "redirect:/emergencia";
        }
    }

    @GetMapping("/api")
    @ResponseBody
    public List<Chamado> apiListar() {
        return chamadoService.listarChamados();
    }

    @PostMapping("/api")
    @ResponseBody
    public Chamado apiAbrir(@ModelAttribute Chamado chamado) {
        try {
            return chamadoService.abrirChamado(chamado);
        } catch (IllegalArgumentException erro) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, erro.getMessage(), erro);
        }
    }
}
