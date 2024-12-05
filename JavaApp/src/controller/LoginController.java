package controller;

import model.Usuario;
import model.UsuarioDAO;
import view.LoginView;
import view.MenuPrincipalView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginController {
    private LoginView loginView;
    private UsuarioDAO usuarioDAO;

    public LoginController(LoginView loginView, UsuarioDAO usuarioDAO) {
        this.loginView = loginView;
        this.usuarioDAO = usuarioDAO;

        this.loginView.addLoginListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                autenticarUsuario();
            }
        });
    }

    private void autenticarUsuario() {
        String usuario = loginView.getUsuario();
        String contraseña = loginView.getContraseña();
        Usuario user = new Usuario(usuario, contraseña);

        if (usuarioDAO.validarUsuario(user)) {
            JOptionPane.showMessageDialog(loginView, "Bienvenido " + usuario);
            loginView.dispose(); // Cerrar la ventana de login
            MenuPrincipalView.mostrarMenuPrincipal(); // Mostrar el menú principal
        } else {
            JOptionPane.showMessageDialog(loginView, "Credenciales incorrectas", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
