
package Vista;

import javax.swing.*;
import controlador.ActividadEconomicaController;
import modelo.ActividadEconomica;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class ActividadEconomicaFrame extends JFrame {
    private JTextField txtDescripcion;
    private ActividadEconomicaController controller;

    public ActividadEconomicaFrame() {
        setTitle("Gestión de Actividades Económicas");
        setSize(400, 200);
        setLocationRelativeTo(null);
        setLayout(null);

        controller = new ActividadEconomicaController();

        JLabel lblDescripcion = new JLabel("Descripción:");
        lblDescripcion.setBounds(50, 50, 100, 25);
        add(lblDescripcion);

        txtDescripcion = new JTextField();
        txtDescripcion.setBounds(150, 50, 200, 25);
        add(txtDescripcion);

        JButton btnGuardar = new JButton("Guardar");
        btnGuardar.setBounds(150, 100, 100, 25);
        btnGuardar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    ActividadEconomica actividad = new ActividadEconomica(0, txtDescripcion.getText());
                    controller.agregarActividad(actividad);
                    JOptionPane.showMessageDialog(null, "Actividad económica guardada con éxito!");
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, "Error al guardar actividad: " + ex.getMessage());
                }
            }
        });
        add(btnGuardar);
    }
}
