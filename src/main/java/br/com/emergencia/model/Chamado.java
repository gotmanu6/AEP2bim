package br.com.emergencia.model;

import java.time.LocalDateTime;

public class Chamado {

    private Long id;
    private TipoEmergencia tipo;
    private String descricao;
    private String endereco;
    private String pessoaEnvolvida;
    private LocalDateTime dataHora;
    private String status;

    public Chamado() {
    }

    public Chamado(Long id, TipoEmergencia tipo, String descricao, String endereco,
                   String pessoaEnvolvida, LocalDateTime dataHora, String status) {
        this.id = id;
        this.tipo = tipo;
        this.descricao = descricao;
        this.endereco = endereco;
        this.pessoaEnvolvida = pessoaEnvolvida;
        this.dataHora = dataHora;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public TipoEmergencia getTipo() {
        return tipo;
    }

    public void setTipo(TipoEmergencia tipo) {
        this.tipo = tipo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getPessoaEnvolvida() {
        return pessoaEnvolvida;
    }

    public void setPessoaEnvolvida(String pessoaEnvolvida) {
        this.pessoaEnvolvida = pessoaEnvolvida;
    }

    public LocalDateTime getDataHora() {
        return dataHora;
    }

    public void setDataHora(LocalDateTime dataHora) {
        this.dataHora = dataHora;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
