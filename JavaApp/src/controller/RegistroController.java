package controller;

import model.HabitanteDAO;
import model.LocalidadDAO;
import model.MunicipioDAO;
import model.ViviendaDAO;
import view.RegistroView;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class RegistroController {
    private RegistroView registroView;
    private MunicipioDAO municipioDAO;
    private LocalidadDAO localidadDAO;
    private ViviendaDAO viviendaDAO;
    private HabitanteDAO habitanteDAO;

    public RegistroController(RegistroView registroView) {
        this.registroView = registroView;
        this.municipioDAO = new MunicipioDAO();
        this.localidadDAO = new LocalidadDAO();
        this.viviendaDAO = new ViviendaDAO();
        this.habitanteDAO = new HabitanteDAO();

        cargarMunicipios();

        registroView.getComboMunicipios().addActionListener(e -> actualizarLocalidades());
        registroView.getSpinnerHabitantes().addChangeListener(e -> generarFormulariosHabitantes());
        registroView.getBtnRegistrar().addActionListener(e -> registrarDatos());
        registroView.getBtnCancelar().addActionListener(e -> registroView.dispose());
    }

    private void cargarMunicipios() {
        List<String> municipios = municipioDAO.obtenerMunicipios();
        if (!municipios.isEmpty()) {
            for (String municipio : municipios) {
                registroView.getComboMunicipios().addItem(municipio);
            }
        } else {
            System.out.println("No se encontraron municipios para poblar el combo.");
        }
    }

    private void actualizarLocalidades() {
        registroView.getComboLocalidades().removeAllItems();

        String municipioSeleccionado = (String) registroView.getComboMunicipios().getSelectedItem();
        if (municipioSeleccionado == null) {
            System.out.println("No hay municipio seleccionado para actualizar localidades.");
            return;
        }

        List<String> localidades = localidadDAO.obtenerLocalidadesPorMunicipio(municipioSeleccionado);
        if (!localidades.isEmpty()) {
            for (String localidad : localidades) {
                registroView.getComboLocalidades().addItem(localidad);
            }
        } else {
            System.out.println("No se encontraron localidades para el municipio: " + municipioSeleccionado);
        }

        registroView.getComboLocalidades().revalidate();
        registroView.getComboLocalidades().repaint();
    }

    private void generarFormulariosHabitantes() {
        int numeroHabitantes = (int) registroView.getSpinnerHabitantes().getValue();
        registroView.getPanelHabitantes().removeAll();

        String[] actividades = {
            "No tiene actividad", "Agricultura", "Comercio", "Construcción",
            "Servicios", "Industria", "Educación", "Salud", "Transporte",
            "Hogar", "Turismo", "Tecnología", "Finanzas", "Administración", 
            "Pesca", "Minería", "Manufactura", "Otro"
        };

        for (int i = 1; i <= numeroHabitantes; i++) {
            JPanel panel = new JPanel();
            panel.add(new JLabel("Habitante " + i + ":"));
            JTextField txtNombre = new JTextField(10);
            panel.add(txtNombre);
            JTextField txtEdad = new JTextField(5);
            panel.add(new JLabel("Edad:"));
            panel.add(txtEdad);
            JComboBox<String> comboSexo = new JComboBox<>(new String[]{"Masculino", "Femenino"});
            panel.add(new JLabel("Sexo:"));
            panel.add(comboSexo);
            JComboBox<String> comboActividad = new JComboBox<>(actividades);
            panel.add(new JLabel("Actividad:"));
            panel.add(comboActividad);
            registroView.getPanelHabitantes().add(panel);
        }

        registroView.getPanelHabitantes().revalidate();
        registroView.getPanelHabitantes().repaint();
    }

    private void registrarDatos() {
        String direccion = registroView.getTxtDireccion().getText();
        String tipoVivienda = (String) registroView.getComboTipoVivienda().getSelectedItem();
        String localidad = (String) registroView.getComboLocalidades().getSelectedItem();
        String municipio = (String) registroView.getComboMunicipios().getSelectedItem();

        if (direccion.isEmpty() || tipoVivienda == null || localidad == null || municipio == null) {
            JOptionPane.showMessageDialog(registroView, "Complete todos los campos.");
            return;
        }

        // Ahora usamos el método correcto para obtener el ID de la localidad
        int idLocalidad = localidadDAO.obtenerIdLocalidadPorNombre(localidad);
        if (idLocalidad == -1) {
            JOptionPane.showMessageDialog(registroView, "No se encontró la localidad seleccionada.");
            return;
        }

        int idMunicipio = municipioDAO.obtenerIdMunicipioPorNombre(municipio);
        if (idMunicipio == -1) {
            JOptionPane.showMessageDialog(registroView, "No se encontró el municipio seleccionado.");
            return;
        }

        int idVivienda = viviendaDAO.registrarVivienda(direccion, idLocalidad, tipoVivienda, idMunicipio);
        if (idVivienda == -1) {
            JOptionPane.showMessageDialog(registroView, "Error al registrar la vivienda.");
            return;
        }

        // Registrar los habitantes
        int numeroHabitantes = registroView.getPanelHabitantes().getComponentCount();
        for (int i = 0; i < numeroHabitantes; i++) {
            JPanel panel = (JPanel) registroView.getPanelHabitantes().getComponent(i);
            JTextField txtNombre = (JTextField) panel.getComponent(1);
            JTextField txtEdad = (JTextField) panel.getComponent(3);
            JComboBox<String> comboSexo = (JComboBox<String>) panel.getComponent(5);
            JComboBox<String> comboActividad = (JComboBox<String>) panel.getComponent(7);

            String nombre = txtNombre.getText();
            String edadTexto = txtEdad.getText();
            String sexo = (String) comboSexo.getSelectedItem();
            String actividad = (String) comboActividad.getSelectedItem();

            if (nombre.isEmpty() || edadTexto.isEmpty() || sexo == null || actividad == null) {
                JOptionPane.showMessageDialog(registroView, "Complete todos los campos para los habitantes.");
                return;
            }

            int edad = Integer.parseInt(edadTexto);
            boolean habitanteRegistrado = habitanteDAO.registrarHabitante(nombre, edad, sexo, actividad, idVivienda);
            if (!habitanteRegistrado) {
                JOptionPane.showMessageDialog(registroView, "Error al registrar el habitante: " + nombre);
            }
        }

        JOptionPane.showMessageDialog(registroView, "Registro completado con éxito.");
        registroView.dispose();
    }
}
