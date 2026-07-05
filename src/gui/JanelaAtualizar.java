package gui;

import model.dao.DaoFactory;
import model.dao.ExemplarDao;
import model.entities.Exemplar;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class JanelaAtualizar {

    Font fonteGrande = new Font("Arial", Font.BOLD, 28);

    JFrame framePesquisar = new JFrame("Pesquisar Exemplar");
    JPanel painel = new JPanel();

    JLabel jlPergunta = new JLabel("Insira o ID do Exemplar desejado:");

    JLabel jlId = new JLabel("ID:");
    JTextField jtfId = new JTextField();

    JButton jbPesquisar = new JButton("Pesquisar");
    JButton jbLimpar = new JButton("Limpar");


    public void abreJanela() {
        painel.setLayout(null);
        painel.setBackground(new Color(225, 235, 250));

        jlPergunta.setFont(fonteGrande);
        jlPergunta.setBounds(305, 30, 669, 44);


        jlId.setFont(fonteGrande);
        jlId.setBounds(56, 111, 46, 44);

        jtfId.setBounds(56, 155, 249, 59);

        jbPesquisar.setBounds(56, 313, 249, 59);
        jbLimpar.setBounds(401, 313, 249, 59);


        painel.add(jlPergunta);
        painel.add(jlId);

        painel.add(jtfId);

        painel.add(jbPesquisar);
        painel.add(jbLimpar);

        framePesquisar.add(painel);
        framePesquisar.setSize(1206, 656);
        framePesquisar.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        framePesquisar.setVisible(true);

        jbPesquisar.addActionListener(e -> pesquisar());
        jbLimpar.addActionListener(e -> limpar());
    }


    private void pesquisar() {
        try {
            Integer id = Integer.parseInt(jtfId.getText().trim());
            Exemplar e = new Exemplar();
            e.setId(id);

            ExemplarDao dao = DaoFactory.createExemplarDao();

            List<Exemplar> resultados = dao.consultarExemplar(e);

            if (resultados.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Nenhum exemplar encontrado.\n");
            } else {
                Exemplar exemplar = resultados.getFirst();
                JOptionPane.showMessageDialog(null, "Exemplar encontrado: " + exemplar.getEspecie());

            // TODO fazer a lógica pra abrir a janela e atualizar

            }

            JOptionPane.showMessageDialog(null, "Exemplar de ID " + id + " atualizado.");
        }catch(NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Insira um número inteiro válido.\nErro:" + e.getMessage());
        }catch(Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao atualizar exemplar:\n" + e.getMessage());
        }
        limpar();
    }

    private void limpar() {
        jtfId.setText("");
    }
}
