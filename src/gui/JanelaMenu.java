package gui;

import javax.swing.*;
import java.awt.*;

public class JanelaMenu extends JFrame {
    private JButton btnCadastrarExemplar;
    private JButton btnConsultarExemplar;
    private JButton btnAtualizarExemplar;
    private JButton btnRemoverExemplar;

    Font fonteGrande = new Font("Arial", Font.BOLD, 28);


    public JanelaMenu() {
        setJanela();
        criarComponentes();
        setVisible(true);
    }

    private void setJanela() {
        setTitle("Sistema De Cadastro De Espécimes");
        setSize(500, 650);
        setLayout(null);
        setResizable(false);
        getContentPane().setBackground(new Color(225, 235, 250));
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    private void criarComponentes() {
        btnCadastrarExemplar = new JButton("Cadastrar Exemplar");
        btnConsultarExemplar = new JButton("Consultar Exemplar");
        btnAtualizarExemplar = new JButton("Atualizar Exemplar");
        btnRemoverExemplar = new JButton("Remover Exemplar");

        btnCadastrarExemplar.setBounds(46, 36, 409, 98);
        btnConsultarExemplar.setBounds(46, 182, 409, 98);
        btnAtualizarExemplar.setBounds(46, 333, 409, 98);
        btnRemoverExemplar.setBounds(46, 479, 409, 98);

        btnCadastrarExemplar.setFont(fonteGrande);
        btnConsultarExemplar.setFont(fonteGrande);
        btnAtualizarExemplar.setFont(fonteGrande);
        btnRemoverExemplar.setFont(fonteGrande);

        btnCadastrarExemplar.addActionListener(e -> {
            JanelaCadastrar janelaCadastrar = new JanelaCadastrar();
            janelaCadastrar.abreJanela();
        });

        btnRemoverExemplar.addActionListener(e -> {
            JanelaRemover janelaRemover = new JanelaRemover();
            janelaRemover.abreJanela();
        });

        add(btnCadastrarExemplar);
        add(btnConsultarExemplar);
        add(btnAtualizarExemplar);
        add(btnRemoverExemplar);
    }
}
