import javax.swing.*;
import javax.swing.text.MaskFormatter;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.text.ParseException;

public class EdtAluno extends JDialog {

    public EdtAluno(JFrame parent, DefaultTableModel modeloTabela, int indice) {
        super(parent, "Editar Aluno", true);
        setSize(300, 250);
        setLocationRelativeTo(parent);

        JPanel painelPrincipal = new JPanel(new GridLayout(5, 2, 5, 5));
        painelPrincipal.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        Aluno alunoSelecionado = CadastroAlunos.listaAlunos.get(indice);

        JTextField campoNome = new JTextField(alunoSelecionado.getNome());

        JFormattedTextField campoCpf;
        JFormattedTextField campoTelefone;

        try {
            MaskFormatter cpfMask = new MaskFormatter("###.###.###-##");
            cpfMask.setPlaceholderCharacter('_');
            campoCpf = new JFormattedTextField(cpfMask);
            campoCpf.setText(alunoSelecionado.getCpf());

            MaskFormatter telefoneMask = new MaskFormatter("(##) #####-####");
            telefoneMask.setPlaceholderCharacter('_');
            campoTelefone = new JFormattedTextField(telefoneMask);
            campoTelefone.setText(alunoSelecionado.getTelefone());
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
                // Atualiza objeto da lista
                alunoSelecionado.setNome(nome);
                alunoSelecionado.setCpf(cpf);
                alunoSelecionado.setTelefone(telefone);

                // Atualiza a tabela
                modeloTabela.setValueAt(nome, indice, 0);
                modeloTabela.setValueAt(cpf, indice, 1);
                modeloTabela.setValueAt(telefone, indice, 2);

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
