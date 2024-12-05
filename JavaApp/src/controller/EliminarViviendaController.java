package controller;

import model.ViviendaDAO;
import model.HabitanteDAO;
import view.EliminarViviendaView;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class EliminarViviendaController {
    private EliminarViviendaView view;
    private ViviendaDAO viviendaDAO;
    private HabitanteDAO habitanteDAO;

    public EliminarViviendaController(EliminarViviendaView view, ViviendaDAO viviendaDAO, HabitanteDAO habitanteDAO) {
        this.view = view;
        this.viviendaDAO = viviendaDAO;
        this.habitanteDAO = habitanteDAO;

        cargarViviendas();

        view.getBtnEliminar().addActionListener(e -> eliminarViviendaSeleccionada());
        view.getBtnCancelar().addActionListener(e -> view.dispose());
    }

    private void cargarViviendas() {
        var viviendas = viviendaDAO.obtenerTodasLasViviendas();
        DefaultTableModel model = (DefaultTableModel) view.getTableViviendas().getModel();
        model.setRowCount(0);

        for (var vivienda : viviendas) {
            model.addRow(new Object[]{
                    vivienda.getIdVivienda(),
                    vivienda.getDireccion(),
                    vivienda.getTipoVivienda(),
                    vivienda.getNombreLocalidad(),
                    vivienda.getNombreMunicipio()
            });
        }
    }

    private void eliminarViviendaSeleccionada() {
        int row = view.getTableViviendas().getSelectedRow();
        if (row == -1) {
            JOptionPane.showMessageDialog(view, "Seleccione una vivienda para eliminar.");
            return;
        }

        int idVivienda = (int) view.getTableViviendas().getValueAt(row, 0);

        // Eliminar habitantes de la vivienda
        boolean habitantesEliminados = habitanteDAO.eliminarHabitantesPorVivienda(idVivienda);
        if (!habitantesEliminados) {
            JOptionPane.showMessageDialog(view, "Error al eliminar los habitantes de la vivienda.");
            return;
        }

        // Eliminar la vivienda
        boolean viviendaEliminada = viviendaDAO.eliminarVivienda(idVivienda);
        if (!viviendaEliminada) {
            JOptionPane.showMessageDialog(view, "Error al eliminar la vivienda.");
            return;
        }

        JOptionPane.showMessageDialog(view, "Vivienda eliminada correctamente.");
        cargarViviendas(); // Actualizar la tabla
    }
}
