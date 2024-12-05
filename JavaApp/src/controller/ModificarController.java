package controller;

import model.HabitanteDAO;
import view.ModificarView;

import javax.swing.*;

public class ModificarController {
    private ModificarView modificarView;
    private HabitanteDAO habitanteDAO;

    public ModificarController(ModificarView modificarView, HabitanteDAO habitanteDAO) {
        this.modificarView = modificarView;
        this.habitanteDAO = habitanteDAO;

        modificarView.getBtnBuscar().addActionListener(e -> buscarHabitante());
        modificarView.getBtnGuardar().addActionListener(e -> guardarCambios());
        modificarView.getBtnCancelar().addActionListener(e -> modificarView.dispose());
    }

    private void buscarHabitante() {
        try {
            int idHabitante = Integer.parseInt(modificarView.getTxtIdHabitante().getText());
            var habitante = habitanteDAO.obtenerHabitantePorId(idHabitante);

            if (habitante != null) {
                modificarView.getTxtNombre().setText(habitante.getNombre());
                modificarView.getTxtEdad().setText(String.valueOf(habitante.getEdad()));
                modificarView.getComboSexo().setSelectedItem(habitante.getSexo());
                modificarView.getComboActividad().setSelectedItem(habitante.getActividadEconomica());
            } else {
                JOptionPane.showMessageDialog(modificarView, "No se encontró el habitante.");
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(modificarView, "ID inválido.");
        }
    }

    private void guardarCambios() {
        try {
            int idHabitante = Integer.parseInt(modificarView.getTxtIdHabitante().getText());
            String nombre = modificarView.getTxtNombre().getText();
            int edad = Integer.parseInt(modificarView.getTxtEdad().getText());
            String sexo = (String) modificarView.getComboSexo().getSelectedItem();
            String actividad = (String) modificarView.getComboActividad().getSelectedItem();

            boolean actualizado = habitanteDAO.actualizarHabitante(idHabitante, nombre, edad, sexo, actividad);
            if (actualizado) {
                JOptionPane.showMessageDialog(modificarView, "Datos actualizados correctamente.");
                modificarView.dispose();
            } else {
                JOptionPane.showMessageDialog(modificarView, "Error al actualizar los datos.");
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(modificarView, "Datos inválidos.");
        }
    }
}
