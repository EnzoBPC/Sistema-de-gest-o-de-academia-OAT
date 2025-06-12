import javax.swing.*;
import java.awt.*;

public class TelaLogin {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Login - Sistema de Academia");
        frame.setSize(350, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);

        JPanel painel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(8, 8, 8, 8);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // Usuário
        gbc.gridx = 0; gbc.gridy = 0;
        painel.add(new JLabel("Usuário:"), gbc);
        gbc.gridx = 1;
        JTextField campoUsuario = new JTextField(15);
        painel.add(campoUsuario, gbc);

        // Senha
        gbc.gridx = 0; gbc.gridy = 1;
        painel.add(new JLabel("Senha:"), gbc);
        gbc.gridx = 1;
        JPasswordField campoSenha = new JPasswordField(15);
        painel.add(campoSenha, gbc);

        // Botão Entrar
        gbc.gridx = 0; gbc.gridy = 2; gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        JButton botaoEntrar = new JButton("Entrar");
        painel.add(botaoEntrar, gbc);

        // Ação do botão Entrar
        botaoEntrar.addActionListener(e -> {
            // Aqui você pode validar usuário e senha antes de prosseguir
            frame.dispose();       // Fecha a tela de login
            Home.main(null);       // Abre a tela Home (classe Home.java)
        });

        frame.add(painel);
        frame.setVisible(true);
    }
}
