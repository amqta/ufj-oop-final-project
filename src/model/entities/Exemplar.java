package model.entities;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

public class Exemplar {
    private Integer id;
    private String reino;
    private String filo;
    private String classe;
    private String ordem;
    private String familia;
    private String genero;
    private String especie;
    private String localDeColeta;
    private String UF;
    private LocalDate dataColeta;
    private Coletor coletor;
    private String observacoes;

    public Exemplar() {}

    public Exemplar(Integer id, String reino, String filo, String classe, String ordem, String familia, String genero, String especie, String localDeColeta, String UF, LocalDate dataColeta, Coletor coletor, String observacoes) {
        this.id = id;
        this.reino = reino;
        this.filo = filo;
        this.classe = classe;
        this.ordem = ordem;
        this.familia = familia;
        this.genero = genero;
        this.especie = especie;
        this.localDeColeta = localDeColeta;
        this.UF = UF;
        this.dataColeta = dataColeta;
        this.coletor = coletor;
        this.observacoes = observacoes;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getReino() {
        return reino;
    }

    public void setReino(String reino) {
        this.reino = reino;
    }

    public String getFilo() {
        return filo;
    }

    public void setFilo(String filo) {
        this.filo = filo;
    }

    public String getClasse() {
        return classe;
    }

    public void setClasse(String classe) {
        this.classe = classe;
    }

    public String getOrdem() {
        return ordem;
    }

    public void setOrdem(String ordem) {
        this.ordem = ordem;
    }

    public String getFamilia() {
        return familia;
    }

    public void setFamilia(String familia) {
        this.familia = familia;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getEspecie() {
        return especie;
    }

    public void setEspecie(String especie) {
        this.especie = especie;
    }

    public String getLocalDeColeta() {
        return localDeColeta;
    }

    public void setLocalDeColeta(String localDeColeta) {
        this.localDeColeta = localDeColeta;
    }

    public String getUF() {
        return UF;
    }

    public void setUF(String UF) {
        this.UF = UF;
    }

    public LocalDate getDataColeta() {
        return dataColeta;
    }

    public void setDataColeta(LocalDate dataColeta) {
        this.dataColeta = dataColeta;
    }

    public Coletor getColetor() {
        return coletor;
    }

    public void setColetor(Coletor coletor) {
        this.coletor = coletor;
    }

    public String getObservacoes() {
        return observacoes;
    }

    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Exemplar exemplar = (Exemplar) o;
        return Objects.equals(id, exemplar.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    @Override
    public String toString() {

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        return "Exemplar:\n" +
                "ID: " + id +
                "\nReino: " + reino +
                "\nFilo: " + filo +
                "\nClasse: " + classe +
                "\nOrdem: " + ordem +
                "\nFamília: " + familia +
                "\nGênero: " + genero +
                "\nEspécie: " + especie +
                "\nLocal de Coleta: " + localDeColeta +
                "\nUF: " + UF +
                "\nData de Coleta: " + dtf.format(dataColeta) +
                "\nColetor: " + coletor.getNome() +
                "\nObservações: " + observacoes;
    }
}
