package tarefas;

import java.io.Serializable;

public class Tarefa implements Serializable {
    
    private Integer id;
    private String descricao;
    private Boolean concluida;

    public Tarefa() {
    }

    public Tarefa(Integer id, String descricao, Boolean concluida) {
        this.id = id;
        this.descricao = descricao;
        this.concluida = concluida;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Boolean getConcluida() {
        return concluida;
    }

    public void setConcluida(Boolean concluida) {
        this.concluida = concluida;
    }
    
}
