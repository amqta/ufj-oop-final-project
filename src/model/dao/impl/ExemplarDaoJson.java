package model.dao.impl;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import model.dao.ExemplarDao;
import model.entities.Exemplar;

import javax.swing.*;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

public class ExemplarDaoJson implements ExemplarDao {

    private static final String PATH = "data/exemplares.json";

    private final Gson gson = new GsonBuilder()
            .registerTypeAdapter(java.time.LocalDate.class, new LocalDateAdapter())
            .setPrettyPrinting()
            .create();

    private final Type tipoLista = new TypeToken<List<Exemplar>>() {}.getType();

    private void escrever(List<Exemplar> lista) {
        File arquivo = new File(PATH);
        File pasta = arquivo.getParentFile();
        if (pasta != null && !pasta.exists()) {
            pasta.mkdirs();
        }

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(PATH))) {
            gson.toJson(lista, bw);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao gravar arquivo JSON!\n" + ex.getMessage());
        }
    }

    @Override
    public void cadastroExemplar(Exemplar e) {
        List<Exemplar> lista = listagemGeral();
        lista.add(e);
        escrever(lista);
    }

    @Override
    public List<Exemplar> consultarExemplar(Exemplar e) {
        if (e == null) return listagemGeral();

        return listagemGeral().stream()
                .filter(exemplar -> e.getId() == null || e.getId().equals(exemplar.getId()))
                .filter(exemplar -> e.getEspecie() == null || e.getEspecie().isBlank() || e.getEspecie().equalsIgnoreCase(exemplar.getEspecie().trim()))
                .filter(exemplar -> e.getGenero() == null || e.getGenero().isBlank() || e.getGenero().equalsIgnoreCase(exemplar.getGenero().trim()))
                .filter(exemplar -> e.getColetor() == null || e.getColetor().getNome() == null || e.getColetor().getNome().isBlank() || e.getColetor().getNome().equalsIgnoreCase(exemplar.getColetor().getNome().trim()))
                .filter(exemplar -> e.getUF() == null || e.getUF().isBlank() || e.getUF().equalsIgnoreCase(exemplar.getUF().trim()))
                .toList();
    }

    @Override
    public void atualizarExemplar(Exemplar e) {
        List<Exemplar> lista = listagemGeral();
        int index = lista.indexOf(e);
        if (index != -1) {
            lista.set(index, e);
        }
        escrever(lista);
    }

    @Override
    public void removerExemplar(Exemplar e) {
        List<Exemplar> lista = listagemGeral();
        lista.remove(e);
        escrever(lista);
    }

    @Override
    public List<Exemplar> listagemGeral() {
        File arquivo = new File(PATH);

        if (!arquivo.exists()) {
            return new ArrayList<>();
        }

        try {
            String conteudo = new String(Files.readAllBytes(arquivo.toPath()));
            if (conteudo.isBlank()) {
                return new ArrayList<>();
            }

            List<Exemplar> lista = gson.fromJson(conteudo, tipoLista);
            return lista != null ? lista : new ArrayList<>();

        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao abrir arquivo JSON:\n" + ex.getMessage());
        } catch (com.google.gson.JsonSyntaxException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao interpretar o JSON:\n" + ex.getMessage());
        }

        return new ArrayList<>();
    }
}