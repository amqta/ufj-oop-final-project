package model.entities;

import java.util.Objects;

public class Coletor {
    private String nome;
    private Integer id;

    public Coletor(Integer id,String nome) {
        this.id = id;
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Coletor coletor = (Coletor) o;
        return Objects.equals(id, coletor.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }


}
