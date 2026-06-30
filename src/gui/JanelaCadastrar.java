package gui;

import model.dao.DaoFactory;
import model.dao.ExemplarDao;
import model.entities.Coletor;
import model.entities.Exemplar;

import javax.swing.*;
import java.awt.*;
import java.time.DateTimeException;
import java.time.LocalDate;
import java.util.InputMismatchException;

public class JanelaCadastrar {

    Font fonteGrande = new Font("Arial", Font.BOLD, 28);


    JFrame frameCadastro = new JFrame("Cadastro de Exemplar");
    JPanel painel = new JPanel();

    JLabel jlId = new JLabel("ID Tombo:");
    JTextField jtfId = new JTextField();

    JLabel jlReino = new JLabel("Reino:");
    JTextField jtfReino = new JTextField();

    JLabel jlFilo = new JLabel("Filo:");
    JTextField jtfFilo = new JTextField();

    JLabel jlClasse = new JLabel("Classe:");
    JTextField jtfClasse = new JTextField();

    JLabel jlOrdem = new JLabel("Ordem:");
    JTextField jtfOrdem = new JTextField();

    JLabel jlFamilia = new JLabel("Família:");
    JTextField jtfFamilia = new JTextField();

    JLabel jlGenero = new JLabel("Gênero:");
    JTextField jtfGenero = new JTextField();

    JLabel jlEspecie = new JLabel("Espécie");
    JTextField jtfEspecie = new JTextField();

    JLabel jlLocal = new JLabel("Local de Coleta:");
    JTextField jtfLocal = new JTextField();

    JLabel jlUF = new JLabel("UF:");
    JTextField jtfUF = new JTextField();

    JLabel jlData = new JLabel("Data de Coleta: (yyyy-MM-dd)");
    JTextField jtfData = new JTextField();

    JLabel jlColetorId = new JLabel("ID do Coletor:");
    JTextField jtfColetorId = new JTextField();

    JLabel jlColetorNome = new JLabel("Nome do Coletor:");
    JTextField jtfColetorNome = new JTextField();

    JLabel jlObservacoes = new JLabel("Observações:");
    JTextField jtfObservacoes = new JTextField();

    JButton jbSalvar = new JButton("Salvar");
    JButton jbLimpar = new JButton("Limpar");

    public void abreJanela() {
        painel.setLayout(null);
        painel.setBackground(new Color(225, 235, 250));

        jlId.setBounds(48, 22, 147, 35);
        jtfId.setBounds(46, 57, 249, 59);

        jlReino.setBounds(46, 140, 147, 35);
        jtfReino.setBounds(46, 175, 249, 59);

        jlFilo.setBounds(46, 258, 147, 35);
        jtfFilo.setBounds(46, 293, 249, 59);

        jlClasse.setBounds(46, 376, 147, 35);
        jtfClasse.setBounds(46, 411, 249, 59);

        jlOrdem.setBounds(46, 494, 147, 35);
        jtfOrdem.setBounds(46, 529, 249, 59);

        jlFamilia.setBounds(391, 22, 147, 35);
        jtfFamilia.setBounds(391, 57, 249, 59);

        jlGenero.setBounds(391, 140, 147, 35);
        jtfGenero.setBounds(391, 175, 249, 59);

        jlEspecie.setBounds(391, 258, 147, 35);
        jtfEspecie.setBounds(391, 293, 249, 59);

        jlLocal.setBounds(391, 376, 147, 35);
        jtfLocal.setBounds(391, 411, 249, 59);

        jlUF.setBounds(736, 22, 147, 35);
        jtfUF.setBounds(736, 57, 249, 59);

        jlData.setBounds(736, 140, 147, 35);
        jtfData.setBounds(736, 175, 249, 59);

        jlColetorId.setBounds(736, 258, 147, 35);
        jtfColetorId.setBounds(736, 293, 249, 59);

        jlColetorNome.setBounds(736, 376, 147, 35);
        jtfColetorNome.setBounds(736, 411, 249, 59);

        jlObservacoes.setBounds(736, 494, 147, 35);
        jtfObservacoes.setBounds(736, 529, 249, 59);

        jbSalvar.setBounds(640, 617, 249, 59);
        jbLimpar.setBounds(985, 617, 249, 59);

        painel.add(jlId);
        painel.add(jtfId);

        painel.add(jlReino);
        painel.add(jtfReino);

        painel.add(jlFilo);
        painel.add(jtfFilo);

        painel.add(jlClasse);
        painel.add(jtfClasse);

        painel.add(jlOrdem);
        painel.add(jtfOrdem);

        painel.add(jlFamilia);
        painel.add(jtfFamilia);

        painel.add(jlGenero);
        painel.add(jtfGenero);

        painel.add(jlEspecie);
        painel.add(jtfEspecie);

        painel.add(jlLocal);
        painel.add(jtfLocal);

        painel.add(jlUF);
        painel.add(jtfUF);

        painel.add(jlData);
        painel.add(jtfData);

        painel.add(jlColetorId);
        painel.add(jtfColetorId);

        painel.add(jlColetorNome);
        painel.add(jtfColetorNome);

        painel.add(jlObservacoes);
        painel.add(jtfObservacoes);

        painel.add(jbSalvar);
        painel.add(jbLimpar);

        frameCadastro.add(painel);
        frameCadastro.setSize(1280, 720);
        frameCadastro.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        frameCadastro.setVisible(true);

        jbSalvar.addActionListener(e -> salvar());
        jbLimpar.addActionListener(e -> limpar());

    }

    private void limpar() {
        jtfId.setText("");
        jtfReino.setText("");
        jtfFilo.setText("");
        jtfClasse.setText("");
        jtfOrdem.setText("");
        jtfFamilia.setText("");
        jtfGenero.setText("");
        jtfEspecie.setText("");
        jtfLocal.setText("");
        jtfUF.setText("");
        jtfData.setText("");
        jtfColetorId.setText("");
        jtfColetorNome.setText("");
        jtfObservacoes.setText("");
    }

    private void salvar() {
        try {
            Integer id = Integer.parseInt(jtfId.getText().trim());
            Integer idColetor = Integer.parseInt(jtfColetorId.getText().trim());

            String data = jtfData.getText().trim();
            LocalDate dataColeta = null;
            if (!data.isEmpty()) {
                dataColeta = LocalDate.parse(data);
            }

            Coletor c = new Coletor(idColetor, jtfColetorNome.getText().trim());
            Exemplar e = new Exemplar(id,
                    jtfReino.getText(),
                    jtfFilo.getText(),
                    jtfClasse.getText(),
                    jtfOrdem.getText(),
                    jtfFamilia.getText(),
                    jtfGenero.getText(),
                    jtfEspecie.getText(),
                    jtfLocal.getText(),
                    jtfUF.getText(),
                    dataColeta,
                    c,
                    jtfObservacoes.getText());

            ExemplarDao dao = DaoFactory.createExemplarDao();
            dao.cadastroExemplar(e);

            JOptionPane.showMessageDialog(null, "Cadastro feito com sucesso!\n");
            limpar();

        }catch(NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Os IDs devem ser números inteiros.\n" + e.getMessage());
        }catch(InputMismatchException e) {
            JOptionPane.showMessageDialog(null, "Verifique se todas as entradas estão corretas.\n" + e.getMessage());
        }catch(DateTimeException e) {
            JOptionPane.showMessageDialog(null, "O formato da data deve ser ANO-MÊS-DIA (yyyy-MM-dd).\n" + e.getMessage());
        }catch(Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao cadastrar:\n" + e.getMessage());
        }
    }
}
