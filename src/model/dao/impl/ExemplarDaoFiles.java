package model.dao.impl;

import model.dao.ExemplarDao;
import model.entities.Coletor;
import model.entities.Exemplar;

import javax.swing.*;
import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ExemplarDaoFiles implements ExemplarDao {

    private static final String PATH = "data/exemplares.csv";

    // pra formatar pro formato csv
    private String formatacao(Exemplar e) {
        return String.format("%d;%s;%s;%s;%s;%s;%s;%s;%s;%s;%s;%d;%s;%s",
                e.getId(),                      // fields[0] id do exemplar         Integer
                e.getReino(),                   // fields[1] reino do exemplar      String
                e.getFilo(),                    // fields[2] filo do exemplar       String
                e.getClasse(),                  // fields[3] classe do exemplar     String
                e.getOrdem(),                   // fields[4] ordem do exemplar      String
                e.getFamilia(),                 // fields[5] familia do exemplar    String
                e.getGenero(),                  // fields[6] genero do exemplar     String
                e.getEspecie(),                 // fields[7] especie do exemplar    String
                e.getLocalDeColeta(),           // fields[8] local de coleta        String
                e.getUF(),                      // fields[9] uf do exemplar         String
                e.getDataColeta(),              // fields[10] data de coleta        LocalDate
                e.getColetor().getId(),         // fields[11] id do coletor         Integer
                e.getColetor().getNome(),       // fields[12] nome do coletor       String
                e.getObservacoes());            // fields[13] observaçoes           String
    }

    // pra usar no atualizarExemplar e removerExemplar
    private void sobrescrever(List<Exemplar> lista) {
        try(BufferedWriter bw = new BufferedWriter(new FileWriter(PATH))) {
            lista.forEach(exemplar -> {
                String linha = formatacao(exemplar);
                try {
                    bw.write(linha);
                    bw.newLine();
                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(null, "Erro ao atualizar arquivo!\n" + ex.getMessage());
                }
            });
        }catch(IOException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao remover exemplar:\n" + ex.getMessage());
        }
    }


    @Override
    public void cadastroExemplar(Exemplar e) {
        File arquivo = new File(PATH);
        File pasta = arquivo.getParentFile();

        if(!pasta.exists()) {
            pasta.mkdirs();
        }

    try(BufferedWriter bw = new BufferedWriter(new FileWriter(PATH, true))) {
        String linha = formatacao(e);
        bw.write(linha);
        bw.newLine();

    } catch(IOException exception) {
        JOptionPane.showMessageDialog(null, "Erro ao carregar arquivo!\n" + exception.getMessage());
        }
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
        int index = lista.indexOf(e); // o override do equals verificando id ajuda aqui
        if (index != -1) {
            lista.set(index, e);
        }

        sobrescrever(lista);
    }

    @Override
    public void removerExemplar(Exemplar e) {
        List<Exemplar> lista = listagemGeral();
        lista.remove(e);
        sobrescrever(lista);
    }

    @Override
    public List<Exemplar> listagemGeral() {

        List<Exemplar> l = new ArrayList<>();
        File arquivo = new File(PATH);

        if (!arquivo.exists()) {
            return l;
        }

        try(BufferedReader br = new BufferedReader(new FileReader(PATH))) {
            String linha = br.readLine();
            while(linha != null) {

                String[] fields;
                fields = linha.split(";");

                Exemplar e = getExemplar(fields);
                l.add(e);

                linha = br.readLine();
            }
        }catch(IOException exception) {
            JOptionPane.showMessageDialog(null, "Erro ao abrir arquivo:\n" + exception.getMessage());
        }
        return l;
    }

    private static Exemplar getExemplar(String[] fields) {
        Coletor c = new Coletor(Integer.parseInt(fields[11]), fields[12]);
        Exemplar e = new Exemplar(Integer.parseInt(fields[0]),
                fields[1],
                fields[2],
                fields[3],
                fields[4],
                fields[5],
                fields[6],
                fields[7],
                fields[8],
                fields[9],
                LocalDate.parse(fields[10]),
                c,
                fields[13]);
        return e;
    }

}
