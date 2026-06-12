package br.com.emergencia.model;

public enum TipoEmergencia {
    MEDICA("Emergencia medica", "Atendimento medico urgente", "bi-heart-pulse"),
    INCENDIO("Incendio", "Bombeiros e controle de fogo", "bi-fire"),
    IDOSO("Idoso em risco", "Apoio prioritario para pessoa idosa", "bi-person-fill"),
    CRIANCA("Crianca em emergencia", "Situacao critica envolvendo criancas", "bi-emoji-smile"),
    PCD("PCD em emergencia", "Atendimento acessivel para PCDs", "bi-universal-access-circle");

    private final String titulo;
    private final String descricao;
    private final String icone;

    TipoEmergencia(String titulo, String descricao, String icone) {
        this.titulo = titulo;
        this.descricao = descricao;
        this.icone = icone;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public String getIcone() {
        return icone;
    }
}
