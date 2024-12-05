package view;

import controller.BuscarYModificarViviendaController;
import controller.EliminarViviendaController;
import controller.DashboardController; // Importar controlador del dashboard
import model.HabitanteDAO;
import model.LocalidadDAO;
import model.ViviendaDAO;
import model.DashboardDAO; // Importar DAO del dashboard
import controller.RegistroController;

import javax.swing.*;

public class MenuPrincipalView extends JFrame {
    private JButton btnRegistrar;
    private JButton btnModificar;
    private JButton btnEliminar;
    private JButton btnDashboard; // Botón para el dashboard
    private JButton btnSalir; // Botón para cerrar el programa

    public MenuPrincipalView() {
        setTitle("Menú Principal");
        setSize(400, 450); // Ajustar el tamaño para el nuevo botón
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);

        // Botón Registrar
        btnRegistrar = new JButton("Registrar");
        btnRegistrar.setBounds(150, 50, 100, 30);
        add(btnRegistrar);

        // Botón Modificar
        btnModificar = new JButton("Modificar");
        btnModificar.setBounds(150, 100, 100, 30);
        add(btnModificar);

        // Botón Eliminar
        btnEliminar = new JButton("Eliminar");
        btnEliminar.setBounds(150, 150, 100, 30);
        add(btnEliminar);

        // Botón Dashboard
        btnDashboard = new JButton("Dashboard");
        btnDashboard.setBounds(150, 200, 100, 30);
        add(btnDashboard);

        // Botón Salir
        btnSalir = new JButton("Salir");
        btnSalir.setBounds(150, 250, 100, 30);
        add(btnSalir);

        // Acción para el botón Registrar
        btnRegistrar.addActionListener(e -> {
            RegistroView registroView = new RegistroView();
            new RegistroController(registroView);
            registroView.setVisible(true);
        });

        // Acción para el botón Modificar
        btnModificar.addActionListener(e -> {
            BuscarYModificarViviendaView buscarYModificarViviendaView = new BuscarYModificarViviendaView();
            ViviendaDAO viviendaDAO = new ViviendaDAO();
            HabitanteDAO habitanteDAO = new HabitanteDAO();
            LocalidadDAO localidadDAO = new LocalidadDAO();
            new BuscarYModificarViviendaController(buscarYModificarViviendaView, viviendaDAO, habitanteDAO, localidadDAO);
            buscarYModificarViviendaView.setVisible(true);
        });

        // Acción para el botón Eliminar
        btnEliminar.addActionListener(e -> {
            EliminarViviendaView eliminarViviendaView = new EliminarViviendaView();
            ViviendaDAO viviendaDAO = new ViviendaDAO();
            HabitanteDAO habitanteDAO = new HabitanteDAO();
            new EliminarViviendaController(eliminarViviendaView, viviendaDAO, habitanteDAO);
            eliminarViviendaView.setVisible(true);
        });

        // Acción para el botón Dashboard
        btnDashboard.addActionListener(e -> {
            DashboardView dashboardView = new DashboardView();
            DashboardDAO dashboardDAO = new DashboardDAO();
            new DashboardController(dashboardView, dashboardDAO);
            dashboardView.setVisible(true);
        });

        // Acción para el botón Salir
        btnSalir.addActionListener(e -> {
            int confirm = JOptionPane.showConfirmDialog(this, "¿Está seguro de que desea salir?", "Salir", JOptionPane.YES_NO_OPTION);
            if (confirm == JOptionPane.YES_OPTION) {
                System.exit(0); // Cerrar el programa
            }
        });
    }

    public static void mostrarMenuPrincipal() {
        SwingUtilities.invokeLater(() -> {
            MenuPrincipalView menuPrincipal = new MenuPrincipalView();
            menuPrincipal.setVisible(true);
        });
    }

    public static void main(String[] args) {
        mostrarMenuPrincipal();
    }
}
