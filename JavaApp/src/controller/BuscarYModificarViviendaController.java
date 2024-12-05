package controller;

import model.HabitanteDAO;
import model.Vivienda;
import model.ViviendaDAO;
import model.LocalidadDAO;
import view.BuscarYModificarViviendaView;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class BuscarYModificarViviendaController {
    private BuscarYModificarViviendaView view;
    private ViviendaDAO viviendaDAO;
    private HabitanteDAO habitanteDAO;
    private LocalidadDAO localidadDAO;

    public BuscarYModificarViviendaController(BuscarYModificarViviendaView view, ViviendaDAO viviendaDAO, HabitanteDAO habitanteDAO, LocalidadDAO localidadDAO) {
        this.view = view;
        this.viviendaDAO = viviendaDAO;
        this.habitanteDAO = habitanteDAO;
        this.localidadDAO = localidadDAO;

        cargarViviendas();

        view.getBtnSeleccionar().addActionListener(e -> cargarViviendaSeleccionada());
        view.getBtnAgregarHabitante().addActionListener(e -> agregarHabitante());
        view.getBtnEliminarHabitante().addActionListener(e -> eliminarHabitante());
        view.getBtnGuardarCambios().addActionListener(e -> guardarCambios());
        view.getBtnCancelar().addActionListener(e -> cerrarVentana());

        // Asegurar que la ventana sea visible
        this.view.setVisible(true);
    }

    private void cargarViviendas() {
        var viviendas = viviendaDAO.obtenerTodasLasViviendas();
        DefaultTableModel model = (DefaultTableModel) view.getTableViviendas().getModel();
        model.setRowCount(0);

        for (Vivienda vivienda : viviendas) {
            model.addRow(new Object[]{
                vivienda.getIdVivienda(),
                vivienda.getDireccion(),
                vivienda.getTipoVivienda(),
                vivienda.getNombreLocalidad(),
                vivienda.getNombreMunicipio()
            });
        }
    }

    private void cargarViviendaSeleccionada() {
        int row = view.getTableViviendas().getSelectedRow();
        if (row == -1) {
            JOptionPane.showMessageDialog(view, "Seleccione una vivienda.");
            return;
        }

        int idVivienda = (int) view.getTableViviendas().getValueAt(row, 0);
        var vivienda = viviendaDAO.obtenerViviendaPorId(idVivienda);
        var habitantes = habitanteDAO.obtenerHabitantesPorVivienda(idVivienda);

        if (vivienda != null) {
            view.getTxtDireccion().setText(vivienda.getDireccion());
            view.getComboTipoVivienda().setSelectedItem(vivienda.getTipoVivienda());
        }

        DefaultTableModel model = (DefaultTableModel) view.getTableHabitantes().getModel();
        model.setRowCount(0);

        for (var habitante : habitantes) {
            model.addRow(new Object[]{
                habitante.getIdHabitante(),
                habitante.getNombre(),
                habitante.getEdad(),
                habitante.getSexo(),
                habitante.getActividadEconomica()
            });
        }
    }

    private void agregarHabitante() {
        DefaultTableModel model = (DefaultTableModel) view.getTableHabitantes().getModel();
        model.addRow(new Object[]{"", "", "", "Masculino", "No tiene actividad"});
    }

    private void eliminarHabitante() {
        int row = view.getTableHabitantes().getSelectedRow();
        if (row != -1) {
            DefaultTableModel model = (DefaultTableModel) view.getTableHabitantes().getModel();
            String id = model.getValueAt(row, 0).toString();
            if (!id.isEmpty()) {
                habitanteDAO.eliminarHabitante(Integer.parseInt(id));
            }
            model.removeRow(row);
        } else {
            JOptionPane.showMessageDialog(view, "Seleccione un habitante para eliminar.");
        }
    }

    private void guardarCambios() {
    try {
        String direccion = view.getTxtDireccion().getText();
        String tipoVivienda = (String) view.getComboTipoVivienda().getSelectedItem();
        int row = view.getTableViviendas().getSelectedRow();
        if (row == -1) {
            JOptionPane.showMessageDialog(view, "Seleccione una vivienda para guardar los cambios.");
            return;
        }
        int idVivienda = (int) view.getTableViviendas().getValueAt(row, 0);

        String nombreLocalidad = viviendaDAO.obtenerViviendaPorId(idVivienda).getNombreLocalidad();
        int idLocalidad = localidadDAO.obtenerIdLocalidadPorNombre(nombreLocalidad);

        boolean viviendaActualizada = viviendaDAO.actualizarVivienda(idVivienda, direccion, tipoVivienda, idLocalidad);
        if (!viviendaActualizada) {
            JOptionPane.showMessageDialog(view, "Error al actualizar la vivienda.");
            return;
        }

        DefaultTableModel model = (DefaultTableModel) view.getTableHabitantes().getModel();
        for (int i = 0; i < model.getRowCount(); i++) {
            String id = model.getValueAt(i, 0) != null ? model.getValueAt(i, 0).toString().trim() : "";
            String nombre = model.getValueAt(i, 1) != null ? model.getValueAt(i, 1).toString().trim() : "";
            String edadStr = model.getValueAt(i, 2) != null ? model.getValueAt(i, 2).toString().trim() : "";
            String sexo = model.getValueAt(i, 3) != null ? model.getValueAt(i, 3).toString().trim() : "";
            String actividad = model.getValueAt(i, 4) != null ? model.getValueAt(i, 4).toString().trim() : "";

            if (nombre.isEmpty() || edadStr.isEmpty() || sexo.isEmpty()) {
                JOptionPane.showMessageDialog(view, "Los campos de los habitantes no pueden estar vacíos.");
                continue;
            }

            int edad;
            try {
                edad = Integer.parseInt(edadStr);
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(view, "La edad debe ser un número válido.");
                continue;
            }

            if (id.isEmpty()) {
                boolean registrado = habitanteDAO.registrarHabitante(nombre, edad, sexo, actividad, idVivienda);
                if (!registrado) {
                    JOptionPane.showMessageDialog(view, "Error al registrar el habitante: " + nombre);
                }
            } else {
                boolean actualizado = habitanteDAO.actualizarHabitante(Integer.parseInt(id), nombre, edad, sexo, actividad);
                if (!actualizado) {
                    JOptionPane.showMessageDialog(view, "Error al actualizar el habitante con ID: " + id);
                }
            }
        }

        JOptionPane.showMessageDialog(view, "Cambios guardados correctamente.");
        cargarViviendas();
    } catch (Exception e) {
        e.printStackTrace();
        JOptionPane.showMessageDialog(view, "Error al guardar los cambios.");
    }
}


    private void cerrarVentana() {
        this.view.dispose();
    }
}
