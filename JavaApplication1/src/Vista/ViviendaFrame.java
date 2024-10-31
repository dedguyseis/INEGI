
package Vista;
import javax.swing.*;
import controlador.ViviendaController;
import modelo.Vivienda;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class ViviendaFrame extends JFrame {
    private JTextField txtTipo, txtLocalidad, txtMunicipio;
    private ViviendaController controller;

    public ViviendaFrame() {
        setTitle("Gestión de Viviendas");
        setSize(400, 300);
        setLocationRelativeTo(null);
        setLayout(null);

        controller = new ViviendaController();

        JLabel lblTipo = new JLabel("Tipo:");
        lblTipo.setBounds(50, 50, 100, 25);
        add(lblTipo);

        txtTipo = new JTextField();
        txtTipo.setBounds(150, 50, 200, 25);
        add(txtTipo);

        JLabel lblLocalidad = new JLabel("Localidad:");
        lblLocalidad.setBounds(50, 90, 100, 25);
        add(lblLocalidad);

        txtLocalidad = new JTextField();
        txtLocalidad.setBounds(150, 90, 200, 25);
        add(txtLocalidad);

        JLabel lblMunicipio = new JLabel("Municipio:");
        lblMunicipio.setBounds(50, 130, 100, 25);
        add(lblMunicipio);

        txtMunicipio = new JTextField();
        txtMunicipio.setBounds(150, 130, 200, 25);
        add(txtMunicipio);

        JButton btnGuardar = new JButton("Guardar");
        btnGuardar.setBounds(150, 200, 100, 25);
        btnGuardar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Vivienda vivienda = new Vivienda(0, txtTipo.getText(), txtLocalidad.getText(), txtMunicipio.getText());
                    controller.agregarVivienda(vivienda);
                    JOptionPane.showMessageDialog(null, "Vivienda guardada con éxito!");
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, "Error al guardar vivienda: " + ex.getMessage());
                }
            }
        });
        add(btnGuardar);
    }
}
