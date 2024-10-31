
package Vista;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainFrame extends JFrame {
    public MainFrame() {
        setTitle("Censo de Población INEGI");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);

        JButton btnViviendas = new JButton("Gestión de Viviendas");
        btnViviendas.setBounds(100, 50, 200, 30);
        btnViviendas.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new ViviendaFrame().setVisible(true);
            }
        });
        add(btnViviendas);

        JButton btnHabitantes = new JButton("Gestión de Habitantes");
        btnHabitantes.setBounds(100, 100, 200, 30);
        btnHabitantes.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new HabitanteFrame().setVisible(true);
            }
        });
        add(btnHabitantes);

        JButton btnActividades = new JButton("Gestión de Actividades Económicas");
        btnActividades.setBounds(100, 150, 200, 30);
        btnActividades.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new ActividadEconomicaFrame().setVisible(true);
            }
        });
        add(btnActividades);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new MainFrame().setVisible(true));
    }
}
