import javax.swing.*;
import java.awt.*;

public class Home {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Fit Monster - Página Inicial");
        frame.setSize(550, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);

        // Painel principal
        JPanel painelPrincipal = new JPanel();
        painelPrincipal.setLayout(new BoxLayout(painelPrincipal, BoxLayout.Y_AXIS));
        painelPrincipal.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        JLabel titulo = new JLabel("🏋️ Fit Monster", SwingConstants.CENTER);
        titulo.setFont(new Font("Arial", Font.BOLD, 26));
        titulo.setAlignmentX(Component.CENTER_ALIGNMENT);

        JLabel boasVindas = new JLabel("Bem-vindo(a) ao sistema de gestão da academia!", SwingConstants.CENTER);
        boasVindas.setFont(new Font("Arial", Font.PLAIN, 16));
        boasVindas.setAlignmentX(Component.CENTER_ALIGNMENT);

        // Espaçamento
        painelPrincipal.add(titulo);
        painelPrincipal.add(Box.createRigidArea(new Dimension(0, 15)));
        painelPrincipal.add(boasVindas);
        painelPrincipal.add(Box.createRigidArea(new Dimension(0, 30)));

        JPanel painelBotoes = new JPanel(new GridLayout(2, 3, 10, 10));

        JButton balunos = new JButton("Alunos");
        painelBotoes.add(balunos);
        JButton bprof = new JButton("Professores");
        painelBotoes.add(bprof);
        JButton btreinos = new JButton("Treinos");
        painelBotoes.add(btreinos);
        painelBotoes.add(new JLabel()); // espaço vazio para preencher grade
        JButton botaosairh = new JButton("Sair");
        painelBotoes.add(botaosairh);
        balunos.addActionListener(e -> {
            frame.dispose();
            CadastroAlunos.main(null);
        });
        botaosairh.addActionListener(e -> {
            frame.dispose();
            TelaLogin.main(null);
        });
        bprof.addActionListener(e -> {
            frame.dispose();
            Professores.main(null);
        });
        btreinos.addActionListener(e -> {
            frame.dispose();
            Treinos.main(null);
        });
        painelPrincipal.add(painelBotoes);

        frame.add(painelPrincipal);
        frame.setVisible(true);
    }
}