package view;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class EliminarViviendaView extends JFrame {
    private JTable tableViviendas;
    private JButton btnEliminar;
    private JButton btnCancelar;

    public EliminarViviendaView() {
        setTitle("Eliminar Vivienda");
        setSize(600, 400);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLayout(new BorderLayout());

        // Crear tabla de viviendas
        tableViviendas = new JTable(new DefaultTableModel(
                new Object[]{"ID", "Dirección", "Tipo", "Localidad", "Municipio"}, 0
        ));
        JScrollPane scrollPane = new JScrollPane(tableViviendas);
        add(scrollPane, BorderLayout.CENTER);

        // Crear panel de botones
        JPanel panelBotones = new JPanel();
        btnEliminar = new JButton("Eliminar");
        btnCancelar = new JButton("Cancelar");
        panelBotones.add(btnEliminar);
        panelBotones.add(btnCancelar);
        add(panelBotones, BorderLayout.SOUTH);
    }

    public JTable getTableViviendas() {
        return tableViviendas;
    }

    public JButton getBtnEliminar() {
        return btnEliminar;
    }

    public JButton getBtnCancelar() {
        return btnCancelar;
    }
}
