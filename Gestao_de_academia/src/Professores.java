import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;

public class Professores {

    // Lista fixa de professores
    private static final ArrayList<String[]> professores = new ArrayList<>();

    public static void abrirTelaProfessores() {
        if (professores.isEmpty()) {
            professores.add(new String[]{"Carlos Mendes", "Musculação", "carlos@fitmonster.com"});
            professores.add(new String[]{"Juliana Souza", "Aeróbico", "juliana@fitmonster.com"});
            professores.add(new String[]{"Rodrigo Lima", "Funcional", "rodrigo@fitmonster.com"});
            professores.add(new String[]{"Fernanda Alves", "Alongamento", "fernanda@fitmonster.com"});
        }

        JFrame frame = new JFrame("Professores - Fit Monster");
        frame.setSize(500, 250);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);

        JPanel painel = new JPanel(new BorderLayout(10, 10));
        painel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        String[] colunas = {"Nome", "Especialidade", "Email"};
        DefaultTableModel modeloTabela = new DefaultTableModel(colunas, 0);

        // Adiciona os professores à tabela
        for (String[] prof : professores) {
            modeloTabela.addRow(prof);
        }

        JTable tabelaProfessores = new JTable(modeloTabela);
        tabelaProfessores.setDefaultEditor(Object.class, null);
        tabelaProfessores.setRowSelectionAllowed(false);
        tabelaProfessores.getTableHeader().setReorderingAllowed(false);

        painel.add(tabelaProfessores.getTableHeader(), BorderLayout.NORTH);
        painel.add(tabelaProfessores, BorderLayout.CENTER);

        JButton botaoVoltar = new JButton("Voltar");
        botaoVoltar.addActionListener(e -> {
            frame.dispose();
            Home.main(null); // Voltar à tela inicial
        });

        JPanel painelBotao = new JPanel();
        painelBotao.add(botaoVoltar);
        painel.add(painelBotao, BorderLayout.SOUTH);

        frame.add(painel);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        abrirTelaProfessores();
    }
}
