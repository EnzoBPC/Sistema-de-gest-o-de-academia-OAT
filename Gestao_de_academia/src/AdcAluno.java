import javax.swing.*;
import javax.swing.text.MaskFormatter;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.text.ParseException;

public class AdcAluno extends JDialog {
    public AdcAluno(JFrame parent, DefaultTableModel modeloTabela) {
        super(parent, "Adicionar Aluno", true);
        setSize(300, 250);
        setLocationRelativeTo(parent);

        JPanel painelPrincipal = new JPanel(new GridLayout(5, 2, 5, 5));
        painelPrincipal.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        JTextField campoNome = new JTextField();

        JFormattedTextField campoCpf;
        JFormattedTextField campoTelefone;

        try {
            MaskFormatter cpfMask = new MaskFormatter("###.###.###-##");
            cpfMask.setPlaceholderCharacter('_');
            campoCpf = new JFormattedTextField(cpfMask);

            MaskFormatter telefoneMask = new MaskFormatter("(##) #####-####");
            telefoneMask.setPlaceholderCharacter('_');
            campoTelefone = new JFormattedTextField(telefoneMask);

        } catch (ParseException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Erro ao criar campos formatados.");
            return;
        }

        painelPrincipal.add(new JLabel("Nome:"));
        painelPrincipal.add(campoNome);
        painelPrincipal.add(new JLabel("CPF:"));
        painelPrincipal.add(campoCpf);
        painelPrincipal.add(new JLabel("Telefone:"));
        painelPrincipal.add(campoTelefone);

        JButton botaoSalvar = new JButton("Salvar");
        JButton botaoCancelar = new JButton("Cancelar");

        painelPrincipal.add(botaoSalvar);
        painelPrincipal.add(botaoCancelar);

        botaoSalvar.addActionListener(e -> {
            String nome = campoNome.getText().trim();
            String cpf = campoCpf.getText().trim();
            String telefone = campoTelefone.getText().trim();

            if (!nome.isEmpty() && !cpf.contains("_")) {
                Aluno novo = new Aluno(nome, cpf, telefone);
                CadastroAlunos.listaAlunos.add(novo);
                modeloTabela.addRow(new Object[]{nome, cpf, telefone});
                dispose();
            } else {
                JOptionPane.showMessageDialog(this, "Preencha ao menos o nome e CPF corretamente.");
            }
        });

        botaoCancelar.addActionListener(e -> dispose());

        setContentPane(painelPrincipal);
        setVisible(true);
    }
}
