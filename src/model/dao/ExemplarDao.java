package model.dao;

import model.entities.Exemplar;

import java.util.List;

public interface ExemplarDao {
    void cadastroExemplar(Exemplar e); // rf01
    List<Exemplar> consultarExemplar(Exemplar e); // rf02
    void atualizarExemplar(Exemplar e); // rf03
    void removerExemplar(Exemplar e); //rf04
    List<Exemplar> listagemGeral();// rf05
}
