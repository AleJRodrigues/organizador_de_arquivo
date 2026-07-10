import organizador.MotorDeOrganizacao;

import javax.swing.*;
import java.awt.*;

public class OrganizadorGUI extends JFrame {

    private JTextArea areaTexto;
    private JButton botaoIniciar;
    private MotorDeOrganizacao motor;

    public OrganizadorGUI(){
        motor = new MotorDeOrganizacao();

        setTitle("Organizador de Download");
        setSize(600,400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout(10,10));

        botaoIniciar = new JButton("Organizar Meus Arquivos Agora");
        botaoIniciar.setFont(new Font("Segoe UI", Font.BOLD, 16));
        botaoIniciar.setBackground(new Color(255, 60, 160));
        botaoIniciar.setForeground(Color.WHITE);
        botaoIniciar.setFocusPainted(false);
        botaoIniciar.setPreferredSize(new Dimension(0, 50));
        botaoIniciar.setContentAreaFilled(false);
        botaoIniciar.setOpaque(true);


        areaTexto = new JTextArea();
        areaTexto.setEditable(false);
        areaTexto.setFont(new Font("Consolas", Font.PLAIN, 14));
        areaTexto.setMargin(new Insets(10, 10, 10, 10));

        JScrollPane scrollPane = new JScrollPane(areaTexto);
        // ---------------------------------

        motor.setLogger(mensagem -> {
            SwingUtilities.invokeLater(() -> {
                areaTexto.append(mensagem + "\n");
                areaTexto.setCaretPosition(areaTexto.getDocument().getLength());
            });
        });

        // Ação do Botão
        botaoIniciar.addActionListener(e -> {
            botaoIniciar.setEnabled(false);
            areaTexto.setText("");

            new Thread(() -> {
                motor.iniciar();
                SwingUtilities.invokeLater(() -> botaoIniciar.setEnabled(true));
            }).start();
        });


        add(botaoIniciar, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);
    }

    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception ignored) {}

        SwingUtilities.invokeLater(() -> {
            new OrganizadorGUI().setVisible(true);
        });
    }
}