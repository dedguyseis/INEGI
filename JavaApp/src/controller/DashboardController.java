package controller;

import model.DashboardDAO;
import view.DashboardView;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class DashboardController {
    private DashboardView view;
    private DashboardDAO dao;

    public DashboardController(DashboardView view, DashboardDAO dao) {
        this.view = view;
        this.dao = dao;

        cargarDatos();

        view.getBtnCerrar().addActionListener(e -> view.dispose());
        this.view.setVisible(true);
    }

    private void cargarDatos() {
        var data = dao.obtenerPoblacionPorLocalidad();
        DefaultTableModel model = (DefaultTableModel) view.getTable().getModel();
        model.setRowCount(0);

        for (var row : data) {
            model.addRow(new Object[]{
                    row.getMunicipio(),
                    row.getLocalidad(),
                    row.getPoblacion()
            });
        }
    }
}
