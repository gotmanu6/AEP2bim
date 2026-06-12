package br.com.emergencia.repository;

import br.com.emergencia.model.Chamado;
import br.com.emergencia.model.TipoEmergencia;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

@Repository
public class ChamadoRepository {

    private final List<Chamado> chamados = new ArrayList<>();
    private final AtomicLong sequencia = new AtomicLong(1);

    @PostConstruct
    public void carregarDadosIniciais() {
        salvar(new Chamado(null, TipoEmergencia.MEDICA, "Queda com dor no peito",
                "Rua das Flores, 120 - Centro", "Maria Souza",
                LocalDateTime.now().minusDays(2).withSecond(0).withNano(0), "CONCLUIDO"));
        salvar(new Chamado(null, TipoEmergencia.INCENDIO, "Principio de incendio na cozinha",
                "Av. Brasil, 450 - Jardim America", "Joao Pereira",
                LocalDateTime.now().minusHours(5).withSecond(0).withNano(0), "EM ATENDIMENTO"));
    }

    public List<Chamado> listarTodos() {
        return chamados.stream()
                .sorted(Comparator.comparing(Chamado::getDataHora).reversed())
                .toList();
    }

    public Optional<Chamado> buscarPorId(Long id) {
        return chamados.stream()
                .filter(chamado -> chamado.getId().equals(id))
                .findFirst();
    }

    public Chamado salvar(Chamado chamado) {
        if (chamado.getId() == null) {
            chamado.setId(sequencia.getAndIncrement());
        }

        chamados.removeIf(item -> item.getId().equals(chamado.getId()));
        chamados.add(chamado);
        return chamado;
    }
}
