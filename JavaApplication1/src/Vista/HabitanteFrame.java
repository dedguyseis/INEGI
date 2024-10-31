
package Vista;

import javax.swing.*;
import controlador.HabitanteController;
import modelo.Habitante;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class HabitanteFrame extends JFrame {
    private JTextField txtNombre, txtEdad, txtViviendaId;
    private HabitanteController controller;

    public HabitanteFrame() {
        setTitle("Gestión de Habitantes");
        setSize(400, 300);
        setLocationRelativeTo(null);
        setLayout(null);

        controller = new HabitanteController();

        JLabel lblNombre = new JLabel("Nombre:");
        lblNombre.setBounds(50, 50, 100, 25);
        add(lblNombre);

        txtNombre = new JTextField();
        txtNombre.setBounds(150, 50, 200, 25);
        add(txtNombre);

        JLabel lblEdad = new JLabel("Edad:");
        lblEdad.setBounds(50, 90, 100, 25);
        add(lblEdad);

        txtEdad = new JTextField();
        txtEdad.setBounds(150, 90, 200, 25);
        add(txtEdad);

        JLabel lblViviendaId = new JLabel("ID de Vivienda:");
        lblViviendaId.setBounds(50, 130, 100, 25);
        add(lblViviendaId);

        txtViviendaId = new JTextField();
        txtViviendaId.setBounds(150, 130, 200, 25);
        add(txtViviendaId);

        JButton btnGuardar = new JButton("Guardar");
        btnGuardar.setBounds(150, 200, 100, 25);
        btnGuardar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Habitante habitante = new Habitante(0, txtNombre.getText(), Integer.parseInt(txtEdad.getText()), Integer.parseInt(txtViviendaId.getText()));
                    controller.agregarHabitante(habitante);
                    JOptionPane.showMessageDialog(null, "Habitante guardado con éxito!");
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, "Error al guardar habitante: " + ex.getMessage());
                }
            }
        });
        add(btnGuardar);
    }
}
