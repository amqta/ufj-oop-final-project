package gui;

import model.dao.DaoFactory;
import model.dao.ExemplarDao;
import model.dao.impl.ExemplarDaoFiles;
import model.entities.Coletor;
import model.entities.Exemplar;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class JanelaConsultar {
    Font fonteGrande = new Font("Arial", Font.BOLD, 28);

    JFrame frameConsultar = new JFrame("Consulta de Exemplar");
    JPanel painel = new JPanel();

    JLabel jlId = new JLabel("ID:");
    JTextField jtfId = new JTextField();

    JLabel jlEspecie = new JLabel("Espécie:");
    JTextField jtfEspecie = new JTextField();

    JLabel jlGenero = new JLabel("Gênero:");
    JTextField jtfGenero = new JTextField();

    JLabel jlColetorNome = new JLabel("Nome do Coletor:");
    JTextField jtfColetorNome = new JTextField();

    JLabel jlUF = new JLabel("UF:");
    JTextField jtfUF = new JTextField();

    JButton jbConsultar = new JButton("Consultar");
    JButton jbLimpar = new JButton("Limpar");

    JTextArea jtaResultados = new JTextArea();
    JScrollPane scrollResultados = new JScrollPane(jtaResultados);

    public void abreJanela() {
        painel.setLayout(null);
        painel.setBackground(new Color(225, 235, 250));

        jlId.setBounds(46, 30, 147, 35);
        jtfId.setBounds(46, 65, 200, 45);

        jlEspecie.setBounds(266, 30, 147, 35);
        jtfEspecie.setBounds(266, 65, 200, 45);

        jlGenero.setBounds(486, 30, 147, 35);
        jtfGenero.setBounds(486, 65, 200, 45);

        jlColetorNome.setBounds(706, 30, 147, 35);
        jtfColetorNome.setBounds(706, 65, 200, 45);

        jlUF.setBounds(926, 30, 147, 35);
        jtfUF.setBounds(926, 65, 100, 45);

        jbConsultar.setBounds(46, 130, 200, 50);
        jbLimpar.setBounds(266, 130, 200, 50);

        jtaResultados.setEditable(false);
        scrollResultados.setBounds(46, 200, 1080, 420);

        painel.add(jlId);
        painel.add(jtfId);

        painel.add(jlEspecie);
        painel.add(jtfEspecie);

        painel.add(jlGenero);
        painel.add(jtfGenero);

        painel.add(jlColetorNome);
        painel.add(jtfColetorNome);

        painel.add(jlUF);
        painel.add(jtfUF);

        painel.add(scrollResultados);

        painel.add(jbConsultar);
        painel.add(jbLimpar);

        frameConsultar.add(painel);
        frameConsultar.setSize(1280, 720);
        frameConsultar.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        frameConsultar.setVisible(true);


        jbConsultar.addActionListener(e -> consultar());
        jbLimpar.addActionListener(e -> limpar());

        listarTodos();
    }

    private void exibirResultados(List<Exemplar> resultados) {
        if (resultados.isEmpty()) {
            jtaResultados.setText("Nenhum exemplar encontrado");
        } else {
            StringBuilder sb = new StringBuilder();
            resultados.forEach(r -> {
                sb.append(r.toString());
                sb.append("\n-----------------------------\n");
            });

            jtaResultados.setText(sb.toString());
            jtaResultados.setCaretPosition(0);
        }
    }


    private void listarTodos() {
        ExemplarDao dao = DaoFactory.createExemplarDao();
        exibirResultados(dao.listagemGeral());
    }

    private void limpar() {
        jtfId.setText("");
        jtfEspecie.setText("");
        jtfUF.setText("");
        jtfGenero.setText("");
        jtfColetorNome.setText("");
        listarTodos();
    }


    private void consultar() {
        try {
            Exemplar filtro = new Exemplar();

            String idTexto = jtfId.getText().trim();
            if (!idTexto.isEmpty()) {
                filtro.setId(Integer.parseInt(idTexto));
            }

            filtro.setEspecie(jtfEspecie.getText().trim());
            filtro.setGenero(jtfGenero.getText().trim());
            filtro.setUF(jtfUF.getText().trim());
            filtro.setColetor(new Coletor(null, jtfColetorNome.getText().trim()));

            ExemplarDao dao = DaoFactory.createExemplarDao();
            List<Exemplar> resultados = dao.consultarExemplar(filtro);
            exibirResultados(resultados);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "O ID deve ser um número inteiro válido.\nErro:" + e.getMessage());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao consultar:\n" + e.getMessage());
        }
    }

}