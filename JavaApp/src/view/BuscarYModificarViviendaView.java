package view;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class BuscarYModificarViviendaView extends JFrame {
    private JTable tableViviendas;
    private JButton btnSeleccionar;
    private JTextField txtDireccion;
    private JComboBox<String> comboTipoVivienda;
    private JTable tableHabitantes;
    private JButton btnAgregarHabitante;
    private JButton btnEliminarHabitante;
    private JButton btnGuardarCambios;
    private JButton btnCancelar;

    public BuscarYModificarViviendaView() {
        setTitle("Buscar y Modificar Vivienda");
        setSize(800, 600);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLayout(null);

        // Tabla de viviendas
        JLabel lblViviendas = new JLabel("Viviendas:");
        lblViviendas.setBounds(20, 20, 100, 25);
        add(lblViviendas);

        tableViviendas = new JTable(new DefaultTableModel(new Object[]{"ID", "Dirección", "Tipo", "Localidad", "Municipio"}, 0));
        JScrollPane scrollViviendas = new JScrollPane(tableViviendas);
        scrollViviendas.setBounds(20, 50, 740, 200);
        add(scrollViviendas);

        btnSeleccionar = new JButton("Seleccionar");
        btnSeleccionar.setBounds(330, 260, 120, 30);
        add(btnSeleccionar);

        // Sección de modificación
        JLabel lblDireccion = new JLabel("Dirección:");
        lblDireccion.setBounds(20, 310, 100, 25);
        add(lblDireccion);

        txtDireccion = new JTextField();
        txtDireccion.setBounds(120, 310, 200, 25);
        add(txtDireccion);

        JLabel lblTipoVivienda = new JLabel("Tipo Vivienda:");
        lblTipoVivienda.setBounds(350, 310, 100, 25);
        add(lblTipoVivienda);

        comboTipoVivienda = new JComboBox<>(new String[]{
            "Concreto", "Adobe", "Ladrillo", "Madera", "Cartón", "Piedra",
            "Prefabricada", "Material Ecológico", "Paja", "Otro"
        });
        comboTipoVivienda.setBounds(450, 310, 200, 25);
        add(comboTipoVivienda);

        // Tabla de habitantes
        JLabel lblHabitantes = new JLabel("Habitantes:");
        lblHabitantes.setBounds(20, 350, 100, 25);
        add(lblHabitantes);

        tableHabitantes = new JTable(new DefaultTableModel(new Object[]{"ID", "Nombre", "Edad", "Sexo", "Actividad"}, 0));
        JScrollPane scrollHabitantes = new JScrollPane(tableHabitantes);
        scrollHabitantes.setBounds(20, 380, 740, 100);
        add(scrollHabitantes);

        // Botones para habitantes
        btnAgregarHabitante = new JButton("Agregar Habitante");
        btnAgregarHabitante.setBounds(20, 500, 150, 30);
        add(btnAgregarHabitante);

        btnEliminarHabitante = new JButton("Eliminar Habitante");
        btnEliminarHabitante.setBounds(200, 500, 150, 30);
        add(btnEliminarHabitante);

        // Botones de acción
        btnGuardarCambios = new JButton("Guardar Cambios");
        btnGuardarCambios.setBounds(400, 500, 150, 30);
        add(btnGuardarCambios);

        btnCancelar = new JButton("Cancelar");
        btnCancelar.setBounds(600, 500, 120, 30);
        add(btnCancelar);
    }

    public JTable getTableViviendas() {
        return tableViviendas;
    }

    public JButton getBtnSeleccionar() {
        return btnSeleccionar;
    }

    public JTextField getTxtDireccion() {
        return txtDireccion;
    }

    public JComboBox<String> getComboTipoVivienda() {
        return comboTipoVivienda;
    }

    public JTable getTableHabitantes() {
        return tableHabitantes;
    }

    public JButton getBtnAgregarHabitante() {
        return btnAgregarHabitante;
    }

    public JButton getBtnEliminarHabitante() {
        return btnEliminarHabitante;
    }

    public JButton getBtnGuardarCambios() {
        return btnGuardarCambios;
    }

    public JButton getBtnCancelar() {
        return btnCancelar;
    }
}
