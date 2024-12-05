package view;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class DashboardView extends JFrame {
    private JTable table;
    private JButton btnCerrar;

    public DashboardView() {
        setTitle("Dashboard de Población");
        setSize(600, 400);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLayout(null);

        // Tabla
        table = new JTable(new DefaultTableModel(new Object[]{"Municipio", "Localidad", "Población"}, 0));
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(20, 20, 550, 300);
        add(scrollPane);

        // Botón Cerrar
        btnCerrar = new JButton("Cerrar");
        btnCerrar.setBounds(250, 330, 100, 30);
        add(btnCerrar);
    }

    public JTable getTable() {
        return table;
    }

    public JButton getBtnCerrar() {
        return btnCerrar;
    }
}
