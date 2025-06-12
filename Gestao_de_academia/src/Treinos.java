import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.HashMap;

public class Treinos extends JDialog {

    private final HashMap<String, String> treinosPadrao = new HashMap<>();

    public Treinos(JFrame parent) {
        super(parent, "Treinos por Grupo Muscular", true);
        setSize(450, 400);
        setLocationRelativeTo(parent);
        setLayout(new BorderLayout());

        treinosPadrao.put("Peito", """
                - Supino reto (3x10)
                - Supino inclinado com halteres (3x10)
                - Crucifixo reto (3x12)
                - Flexões (3x15)
                - Crossover (3x12)
                """);

        treinosPadrao.put("Costas", """
                - Puxada frente (3x10)
                - Remada curvada (3x10)
                - Remada baixa (3x12)
                - Pulldown (3x12)
                - Puxada na barra (3x8)
                """);

        treinosPadrao.put("Pernas", """
                - Agachamento livre (4x10)
                - Leg press (4x12)
                - Cadeira extensora (3x15)
                - Cadeira flexora (3x15)
                - Stiff com halteres (3x12)
                """);

        treinosPadrao.put("Braços", """
                - Rosca direta (3x10)
                - Rosca martelo (3x12)
                - Tríceps pulley (3x12)
                - Tríceps testa (3x10)
                - Rosca concentrada (3x10)
                """);

        treinosPadrao.put("Ombros", """
                - Elevação lateral (3x12)
                - Desenvolvimento com barra (3x10)
                - Elevação frontal (3x12)
                - Encolhimento com halteres (3x15)
                - Remada alta (3x12)
                """);

        JPanel painelPrincipal = new JPanel(new BorderLayout(10, 10));
        painelPrincipal.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));

        JPanel botoesTreino = new JPanel(new GridLayout(5, 1, 10, 10));
        for (String grupo : treinosPadrao.keySet()) {
            JButton botao = new JButton("Treino de " + grupo);
            botao.setFocusPainted(false);
            botao.addActionListener(mostrarTreino(grupo));
            botoesTreino.add(botao);
        }

        JButton botaoVoltar = new JButton("Voltar");
        botaoVoltar.addActionListener(e -> {
            dispose();
            Home.main(null);
        });

        JPanel painelInferior = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        painelInferior.add(botaoVoltar);

        painelPrincipal.add(botoesTreino, BorderLayout.CENTER);
        painelPrincipal.add(painelInferior, BorderLayout.SOUTH);

        add(painelPrincipal, BorderLayout.CENTER);

        setVisible(true);
    }

    private ActionListener mostrarTreino(String grupo) {
        return e -> {
            String treino = treinosPadrao.get(grupo);
            JOptionPane.showMessageDialog(this, treino, "Treino de " + grupo, JOptionPane.INFORMATION_MESSAGE);
        };
    }

    // MAIN PARA TESTES
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Treinos(null));
    }
}
