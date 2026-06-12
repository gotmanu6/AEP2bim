package br.com.emergencia.service;

import br.com.emergencia.model.Chamado;
import br.com.emergencia.model.TipoEmergencia;
import br.com.emergencia.repository.ChamadoRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class ChamadoService {

    private final ChamadoRepository repository;

    public ChamadoService(ChamadoRepository repository) {
        this.repository = repository;
    }

    public Chamado abrirChamado(Chamado chamado) {
        validarChamado(chamado);
        chamado.setStatus("ABERTO");
        chamado.setDataHora(LocalDateTime.now().withSecond(0).withNano(0));
        return repository.salvar(chamado);
    }

    public List<Chamado> listarChamados() {
        return repository.listarTodos();
    }

    public List<TipoEmergencia> listarTipos() {
        return List.of(TipoEmergencia.values());
    }

    private void validarChamado(Chamado chamado) {
        if (chamado.getTipo() == null) {
            throw new IllegalArgumentException("Tipo da emergencia obrigatorio.");
        }

        if (chamado.getEndereco() == null || chamado.getEndereco().isBlank()) {
            throw new IllegalArgumentException("Endereco obrigatorio para direcionar a equipe.");
        }

        if (chamado.getDescricao() == null || chamado.getDescricao().isBlank()) {
            chamado.setDescricao("Ocorrencia registrada pelo aplicativo.");
        }

        if (chamado.getPessoaEnvolvida() == null || chamado.getPessoaEnvolvida().isBlank()) {
            chamado.setPessoaEnvolvida("Nao informado");
        }
    }
}
