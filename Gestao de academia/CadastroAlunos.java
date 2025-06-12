import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;

public class CadastroAlunos {

    public static ArrayList<Aluno> listaAlunos = new ArrayList<>();

    public static void abrirCadastroAlunos() {
        if (listaAlunos.isEmpty()) {
            listaAlunos.add(new Aluno("João Silva", "123.456.789-00", "(11) 99999-0000"));
            listaAlunos.add(new Aluno("Ana Costa", "987.654.321-00", "(11) 88888-1111"));
        }

        JFrame frame = new JFrame("Cadastro de Alunos - Fit Monster");
        frame.setSize(550, 400);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);

        JPanel painel = new JPanel(new BorderLayout(10, 10));
        painel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        String[] colunas = {"Nome", "CPF", "Telefone"};
        DefaultTableModel modeloTabela = new DefaultTableModel(colunas, 0);
        JTable tabelaAlunos = new JTable(modeloTabela);
        tabelaAlunos.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        tabelaAlunos.setDefaultEditor(Object.class, null); // impede edição direta

        JScrollPane scroll = new JScrollPane(tabelaAlunos);

        atualizarTabela(modeloTabela);

        // Botões
        JButton botaoAdicionar = new JButton("Adicionar Aluno");
        JButton botaoEditar = new JButton("Editar");
        JButton botaoExcluir = new JButton("Excluir");
        JButton botaoVoltar = new JButton("Voltar");

        JPanel botoes = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
        botoes.add(botaoAdicionar);
        botoes.add(botaoEditar);
        botoes.add(botaoExcluir);
        botoes.add(botaoVoltar);

        painel.add(new JLabel("Alunos cadastrados:"), BorderLayout.NORTH);
        painel.add(scroll, BorderLayout.CENTER);
        painel.add(botoes, BorderLayout.SOUTH);

        // Ações
        botaoAdicionar.addActionListener(e -> new AdcAluno(frame, modeloTabela));

        botaoEditar.addActionListener(e -> {
            int linhaSelecionada = tabelaAlunos.getSelectedRow();
            if (linhaSelecionada >= 0) {
                new EdtAluno(frame, modeloTabela, linhaSelecionada);
            } else {
                JOptionPane.showMessageDialog(frame, "Selecione um aluno para editar.");
            }
        });

        botaoExcluir.addActionListener(e -> new DelAluno(frame, modeloTabela));

        botaoVoltar.addActionListener(e -> {
            frame.dispose();
            Home.main(null); // Altere se necessário
        });

        frame.add(painel);
        frame.setVisible(true);
    }

    public static void atualizarTabela(DefaultTableModel modeloTabela) {
        modeloTabela.setRowCount(0); // limpa a tabela
        for (Aluno aluno : listaAlunos) {
            modeloTabela.addRow(new Object[]{
                    aluno.getNome(),
                    aluno.getCpf(),
                    aluno.getTelefone()
            });
        }
    }

    public static void main(String[] args) {
        abrirCadastroAlunos();
    }
}
