package view;

import javax.swing.*;

public class ModificarView extends JFrame {
    private JTextField txtIdHabitante;
    private JButton btnBuscar;
    private JTextField txtNombre;
    private JTextField txtEdad;
    private JComboBox<String> comboSexo;
    private JComboBox<String> comboActividad;
    private JButton btnGuardar;
    private JButton btnCancelar;

    public ModificarView() {
        setTitle("Modificar Habitante");
        setSize(400, 300);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLayout(null);

        JLabel lblIdHabitante = new JLabel("ID del Habitante:");
        lblIdHabitante.setBounds(20, 20, 120, 25);
        add(lblIdHabitante);

        txtIdHabitante = new JTextField();
        txtIdHabitante.setBounds(150, 20, 200, 25);
        add(txtIdHabitante);

        btnBuscar = new JButton("Buscar");
        btnBuscar.setBounds(150, 60, 100, 30);
        add(btnBuscar);

        JLabel lblNombre = new JLabel("Nombre:");
        lblNombre.setBounds(20, 100, 120, 25);
        add(lblNombre);

        txtNombre = new JTextField();
        txtNombre.setBounds(150, 100, 200, 25);
        add(txtNombre);

        JLabel lblEdad = new JLabel("Edad:");
        lblEdad.setBounds(20, 140, 120, 25);
        add(lblEdad);

        txtEdad = new JTextField();
        txtEdad.setBounds(150, 140, 200, 25);
        add(txtEdad);

        JLabel lblSexo = new JLabel("Sexo:");
        lblSexo.setBounds(20, 180, 120, 25);
        add(lblSexo);

        comboSexo = new JComboBox<>(new String[]{"Masculino", "Femenino"});
        comboSexo.setBounds(150, 180, 200, 25);
        add(comboSexo);

        JLabel lblActividad = new JLabel("Actividad:");
        lblActividad.setBounds(20, 220, 120, 25);
        add(lblActividad);

        comboActividad = new JComboBox<>(new String[]{
            "No tiene actividad", "Agricultura", "Comercio", "Construcción",
            "Servicios", "Industria", "Educación", "Salud", "Transporte",
            "Hogar", "Turismo", "Tecnología", "Finanzas", "Administración", 
            "Pesca", "Minería", "Manufactura", "Otro"
        });
        comboActividad.setBounds(150, 220, 200, 25);
        add(comboActividad);

        btnGuardar = new JButton("Guardar");
        btnGuardar.setBounds(50, 260, 120, 30);
        add(btnGuardar);

        btnCancelar = new JButton("Cancelar");
        btnCancelar.setBounds(200, 260, 120, 30);
        add(btnCancelar);
    }

    public JTextField getTxtIdHabitante() {
        return txtIdHabitante;
    }

    public JButton getBtnBuscar() {
        return btnBuscar;
    }

    public JTextField getTxtNombre() {
        return txtNombre;
    }

    public JTextField getTxtEdad() {
        return txtEdad;
    }

    public JComboBox<String> getComboSexo() {
        return comboSexo;
    }

    public JComboBox<String> getComboActividad() {
        return comboActividad;
    }

    public JButton getBtnGuardar() {
        return btnGuardar;
    }

    public JButton getBtnCancelar() {
        return btnCancelar;
    }
}
