package view;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class RegistroView extends JFrame {
    private JComboBox<String> comboMunicipios;
    private JComboBox<String> comboLocalidades;
    private JComboBox<String> comboTipoVivienda;
    private JTextField txtDireccion;
    private JSpinner spinnerHabitantes;
    private JPanel panelHabitantes;
    private JButton btnRegistrar;
    private JButton btnCancelar;

    public RegistroView() {
        setTitle("Registro de Viviendas y Habitantes");
        setSize(600, 600);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLayout(null);

        // Etiqueta y combo de Municipios
        JLabel lblMunicipios = new JLabel("Municipio:");
        lblMunicipios.setBounds(20, 20, 100, 30);
        add(lblMunicipios);

        comboMunicipios = new JComboBox<>();
        comboMunicipios.setBounds(130, 20, 300, 30);
        add(comboMunicipios);

        // Etiqueta y combo de Localidades
        JLabel lblLocalidades = new JLabel("Localidad:");
        lblLocalidades.setBounds(20, 70, 100, 30);
        add(lblLocalidades);

        comboLocalidades = new JComboBox<>();
        comboLocalidades.setBounds(130, 70, 300, 30);
        add(comboLocalidades);

        // Etiqueta y combo de Tipo de Vivienda
        JLabel lblTipoVivienda = new JLabel("Tipo de Vivienda:");
        lblTipoVivienda.setBounds(20, 120, 100, 30);
        add(lblTipoVivienda);

        comboTipoVivienda = new JComboBox<>(new String[]{
            "Concreto", "Adobe", "Ladrillo", "Madera", "Cartón",
            "Piedra", "Prefabricada", "Material ecológico", "Paja", "Adobe moderno"
        });
        comboTipoVivienda.setBounds(130, 120, 300, 30);
        add(comboTipoVivienda);

        // Etiqueta y campo de Dirección
        JLabel lblDireccion = new JLabel("Dirección:");
        lblDireccion.setBounds(20, 170, 100, 30);
        add(lblDireccion);

        txtDireccion = new JTextField();
        txtDireccion.setBounds(130, 170, 300, 30);
        add(txtDireccion);

        // Etiqueta y spinner de número de habitantes
        JLabel lblHabitantes = new JLabel("Número de Habitantes:");
        lblHabitantes.setBounds(20, 220, 150, 30);
        add(lblHabitantes);

        spinnerHabitantes = new JSpinner(new SpinnerNumberModel(1, 1, 10, 1)); // Mínimo 1, máximo 10
        spinnerHabitantes.setBounds(180, 220, 50, 30);
        add(spinnerHabitantes);

        // Panel dinámico para formularios de habitantes
        panelHabitantes = new JPanel();
        panelHabitantes.setBounds(20, 270, 550, 200);
        panelHabitantes.setLayout(new BoxLayout(panelHabitantes, BoxLayout.Y_AXIS));
        add(panelHabitantes);

        // Botón Registrar
        btnRegistrar = new JButton("Registrar");
        btnRegistrar.setBounds(130, 500, 100, 30);
        add(btnRegistrar);

        // Botón Cancelar
        btnCancelar = new JButton("Cancelar");
        btnCancelar.setBounds(250, 500, 100, 30);
        add(btnCancelar);
    }

    // Métodos para los componentes
    public JComboBox<String> getComboMunicipios() {
        return comboMunicipios;
    }

    public JComboBox<String> getComboLocalidades() {
        return comboLocalidades;
    }

    public JComboBox<String> getComboTipoVivienda() {
        return comboTipoVivienda;
    }

    public JTextField getTxtDireccion() {
        return txtDireccion;
    }

    public JSpinner getSpinnerHabitantes() {
        return spinnerHabitantes;
    }

    public JPanel getPanelHabitantes() {
        return panelHabitantes;
    }

    public JButton getBtnRegistrar() {
        return btnRegistrar;
    }

    public JButton getBtnCancelar() {
        return btnCancelar;
    }
}
