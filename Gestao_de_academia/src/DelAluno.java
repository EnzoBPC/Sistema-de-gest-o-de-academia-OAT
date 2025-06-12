import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;

public class DelAluno extends JDialog {

    private final ArrayList<JCheckBox> checkboxes = new ArrayList<>();

    public DelAluno(JFrame parent, DefaultTableModel modeloTabela) {
        super(parent, "Excluir Alunos", true);
        setSize(350, 300);
        setLocationRelativeTo(parent);

        JPanel painelPrincipal = new JPanel(new BorderLayout(10, 10));
        painelPrincipal.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));

        JPanel painelLista = new JPanel();
        painelLista.setLayout(new BoxLayout(painelLista, BoxLayout.Y_AXIS));

        for (Aluno aluno : CadastroAlunos.listaAlunos) {
            JCheckBox checkbox = new JCheckBox(aluno.getNome() + " - CPF: " + aluno.getCpf());
            checkboxes.add(checkbox);
            painelLista.add(checkbox);
        }

        JScrollPane scroll = new JScrollPane(painelLista);
        painelPrincipal.add(scroll, BorderLayout.CENTER);

        JButton botaoExcluir = new JButton("Excluir Selecionados");
        JButton botaoCancelar = new JButton("Cancelar");

        JPanel botoes = new JPanel(new FlowLayout());
        botoes.add(botaoExcluir);
        botoes.add(botaoCancelar);

        painelPrincipal.add(botoes, BorderLayout.SOUTH);

        botaoExcluir.addActionListener(e -> {
            int confirm = JOptionPane.showConfirmDialog(
                    this,
                    "Tem certeza que deseja excluir os alunos selecionados?",
                    "Confirmar Exclusão",
                    JOptionPane.YES_NO_OPTION
            );

            if (confirm == JOptionPane.YES_OPTION) {
                // Percorre de trás para frente para evitar problemas ao remover
                for (int i = checkboxes.size() - 1; i >= 0; i--) {
                    if (checkboxes.get(i).isSelected()) {
                        CadastroAlunos.listaAlunos.remove(i);
                        modeloTabela.removeRow(i);
                    }
                }
                dispose();
            }
        });

        botaoCancelar.addActionListener(e -> dispose());

        setContentPane(painelPrincipal);
        setVisible(true);
    }
}
