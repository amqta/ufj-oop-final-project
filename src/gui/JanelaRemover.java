package gui;

import model.dao.DaoFactory;
import model.dao.ExemplarDao;
import model.dao.impl.ExemplarDaoFiles;
import model.entities.Exemplar;

import javax.swing.*;
import java.awt.*;

public class JanelaRemover {

    Font fonteGrande = new Font("Arial", Font.BOLD, 28);

    JFrame frameRemover = new JFrame("Remover Exemplar");
    JPanel painel = new JPanel();

    JLabel jlPergunta = new JLabel("Insira o ID do Exemplar a ser removido:");

    JLabel jlId = new JLabel("ID:");
    JTextField jtfId = new JTextField();

    JButton jbConfirmar = new JButton("Confirmar");
    JButton jbLimpar = new JButton("Limpar");


    public void abreJanela() {
        painel.setLayout(null);
        painel.setBackground(new Color(225, 235, 250));

        jlPergunta.setFont(fonteGrande);
        jlPergunta.setBounds(305, 30, 669, 44);


        jlId.setFont(fonteGrande);
        jlId.setBounds(56, 111, 46, 44);

        jtfId.setBounds(56, 155, 249, 59);

        jbConfirmar.setBounds(56, 313, 249, 59);
        jbLimpar.setBounds(401, 313, 249, 59);


        painel.add(jlPergunta);
        painel.add(jlId);

        painel.add(jtfId);

        painel.add(jbConfirmar);
        painel.add(jbLimpar);

        frameRemover.add(painel);
        frameRemover.setSize(1206, 656);
        frameRemover.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        frameRemover.setVisible(true);

        jbConfirmar.addActionListener(e -> apagar());
        jbLimpar.addActionListener(e -> limpar());
    }


    private void apagar() {
        try {
            Integer id = Integer.parseInt(jtfId.getText().trim());
            Exemplar e = new Exemplar();
            e.setId(id);

            ExemplarDao dao = DaoFactory.createExemplarDao();
            dao.removerExemplar(e);

            JOptionPane.showMessageDialog(null, "Exemplar de ID " + id + " removido.");
        }catch(NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Insira um número inteiro válido.\nErro:" + e.getMessage());
        }catch(Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao remover exemplar:\n" + e.getMessage());
        }
        limpar();
    }

    private void limpar() {
        jtfId.setText("");
    }
}
